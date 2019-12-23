package com.service;

import com.AccountFeignClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description
 * @author: yangyingyang
 * @date: 2019/12/21.
 */
@FeignClient(name = "feign-service")
@RequestMapping(value = "/account-service")
public interface AccountService
//        extends AccountFeignClient
{

    @PostMapping("/deduction")
    void deduction(@RequestParam("accountId") String id, Integer money);

}
