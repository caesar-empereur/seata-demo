package com.controller;

import com.model.Order;
import com.feign.OrderFeignService;
import com.repository.OrderRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @author: yangyingyang
 * @date: 2018/9/11.
 */
@RestController
public class OrderProviderController implements OrderFeignService {

    @Resource
    private OrderRepository orderRepository;

    @Override
    public void saveOrder(@RequestBody Order order) {
        orderRepository.save(order);
    }
}
