package com.service;

import com.AccountFeignService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Description
 * @author: yangyingyang
 * @date: 2019/12/21.
 */
@FeignClient(name = "feign-service")
public interface AccountFeignClient extends AccountFeignService {

}
