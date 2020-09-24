package com.spring.accountservice.controller;

import com.spring.accountservice.entity.Account;
import com.spring.accountservice.service.AccountService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Account)表控制层
 *
 * @author hyhong
 * @since 2020-06-30 16:43:02
 */
@RestController
@RequestMapping("/account")
public class AccountController {
    /**
     * 服务对象
     */
    @Resource
    private AccountService accountService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public Account selectOne(Long id) {
        return this.accountService.queryById(id);
    }

    @PostMapping("/insert")
    public Account insert(@RequestBody Account account) {
        return this.accountService.insert(account);
    }

    @PostMapping("/update")
    public Account update(@RequestBody Account account) {
        return this.accountService.update(account);
    }

}
