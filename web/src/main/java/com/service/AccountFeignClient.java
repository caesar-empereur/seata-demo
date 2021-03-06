package com.service;

import com.feign.AccountFeignService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Description
 * @author: yangyingyang
 * @date: 2019/12/21.
 */
@FeignClient(name = "account-service")
public interface AccountFeignClient extends AccountFeignService {

}
