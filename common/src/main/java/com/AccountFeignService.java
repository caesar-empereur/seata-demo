package com;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description
 * @author: yangyingyang
 * @date: 2019/11/30.
 */

@RequestMapping(value = "/account-service")
public interface AccountFeignService {

    @PostMapping("/deduction")
    void deduction(@RequestParam("accountId") String id, @RequestParam("accountId") Integer money);
}
