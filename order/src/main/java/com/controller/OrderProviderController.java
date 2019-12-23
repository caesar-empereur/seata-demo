package com.controller;

import com.Order;
import com.repository.OrderRepository;
import com.service.OrderFeignClient;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @author: yangyingyang
 * @date: 2018/9/11.
 */
@RestController
//@RequestMapping(value = "/provider/order-service")
public class OrderProviderController implements OrderFeignClient {

    @Resource
    private OrderRepository orderRepository;

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }
}
