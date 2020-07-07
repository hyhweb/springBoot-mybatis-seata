package com.springboot.ordersservice.controller;

import com.spring.accountservice.entity.Account;
import com.springboot.ordersservice.entity.Order;
import com.springboot.ordersservice.feignclient.AccountFeignClient;
import com.springboot.ordersservice.feignclient.StorageFeignClient;
import com.springboot.ordersservice.service.OrderService;
import com.springboot.storageservice.entity.Storage;
import io.seata.core.context.RootContext;
import io.seata.core.exception.TransactionException;
import io.seata.spring.annotation.GlobalTransactional;
import io.seata.tm.api.GlobalTransactionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * (Order)表控制层
 *
 * @author hyhong
 * @since 2020-07-03 14:28:24
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    /**
     * 服务对象
     */
    @Resource
    private OrderService orderService;
   @Autowired
   private AccountFeignClient accountFeignClient;
   @Autowired
   private StorageFeignClient storageFeignClient;

    private Lock lock = new ReentrantLock();

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public Order selectOne(Long id) {
        return this.orderService.queryById(id);
    }
    @GetMapping("/insert")
    @GlobalTransactional(name="my_tx_group",rollbackFor = Exception.class)
    public Object insert() throws TransactionException {
        lock.lock();
        try {
      System.out.println("-----------------"+RootContext.getXID());
            Order order = new Order();
            order.setUserId(Long.valueOf(1));
            order.setProductId(Long.valueOf(1));
            order.setCount(10);
            order.setMoney(Double.valueOf(10));
            order.setStatus(0);
            orderService.insert(order);
            Account account = accountFeignClient.selectOne(order.getUserId());
            Account newAccount = new Account();
            newAccount.setUserId(order.getUserId());
            newAccount.setUsed(account.getUsed()+order.getMoney());
            newAccount.setResidue(account.getResidue()-order.getMoney());
            accountFeignClient.update(newAccount);

            Storage storage = storageFeignClient.selectOne(order.getProductId());
            Storage newStorage = new Storage();
            newStorage.setProductId(order.getProductId());
            newStorage.setUsed(storage.getUsed()+order.getCount());
            newStorage.setResidue(storage.getResidue()-order.getCount());
            storageFeignClient.update(newStorage);
            order.setStatus(1);
            orderService.update(order);

            return "添加成功";
        }catch (Exception e){
            GlobalTransactionContext.reload(RootContext.getXID()).rollback();
            return "添加失败";
        }finally{
            lock.unlock();
        }

    }

}
