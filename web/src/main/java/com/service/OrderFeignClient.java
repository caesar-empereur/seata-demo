package com.service;

import com.feign.OrderFeignService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Description
 * @author: yangyingyang
 * @date: 2019/11/30.
 */
@FeignClient(name = "order-service")
public interface OrderFeignClient extends OrderFeignService {

}
