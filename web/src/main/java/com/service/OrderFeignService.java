package com.service;

import com.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @author: yangyingyang
 * @date: 2019/11/30.
 */
@FeignClient(name = "feign-service")
@RequestMapping(value = "/order-service")
public interface OrderFeignService {

    @PostMapping("/save")
    void saveOrder(@RequestBody Order order);
}
