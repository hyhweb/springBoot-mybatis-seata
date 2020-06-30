package com.springboot.orderservice.controller;

import com.springboot.orderservice.entity.Order;
import com.springboot.orderservice.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Order)表控制层
 *
 * @author hyhong
 * @since 2020-06-30 17:41:02
 */
@RestController
@RequestMapping("order")
public class OrderController {
    /**
     * 服务对象
     */
    @Resource
    private OrderService orderService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Order selectOne(Long id) {
        return this.orderService.queryById(id);
    }

}