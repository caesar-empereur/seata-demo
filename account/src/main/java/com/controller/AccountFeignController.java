package com.controller;

import com.Account;
import com.AccountFeignService;
import com.repository.AccountRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @author: yangyingyang
 * @date: 2018/9/10.
 */
@RestController
@RequestMapping(value = "/account-service")
public class AccountFeignController
//        implements AccountFeignService
{

    @Resource
    private AccountRepository accountRepository;

//    @Override
    @PostMapping("/deduction")
    public void deduction(@RequestParam("accountId") String id, @RequestParam("money") Integer money) {
        Account account = accountRepository.getOne(id);
        if (account.getBalance()<money){
            throw new RuntimeException("余额不足");
        }
        accountRepository.reduce(money, id);
    }
}
