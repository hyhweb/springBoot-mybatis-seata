package com.springboot.ordersservice.feignclient.fallback;

import com.spring.accountservice.entity.Account;
import com.springboot.ordersservice.feignclient.AccountFeignClient;
import com.springboot.ordersservice.feignclient.StorageFeignClient;
import com.springboot.storageservice.entity.Storage;
import org.springframework.stereotype.Component;

@Component
public class StorageFallback implements StorageFeignClient {
    @Override
    public Storage selectOne(Long id) {
        return null;
    }

    @Override
    public Storage insert(Storage storage) {
        return null;
    }

    @Override
    public Storage update(Storage storage) {
        return null;
    }
}
