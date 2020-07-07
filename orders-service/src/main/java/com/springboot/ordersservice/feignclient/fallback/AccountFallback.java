package com.springboot.ordersservice.feignclient.fallback;

import com.spring.accountservice.entity.Account;
import com.springboot.ordersservice.feignclient.AccountFeignClient;
import org.springframework.stereotype.Component;

@Component
public class AccountFallback implements AccountFeignClient {
    @Override
    public Account selectOne(Long id) {
        return null;
    }

    @Override
    public Account insert(Account account) {
        return null;
    }

    @Override
    public Account update(Account account) {
        return null;
    }
}
