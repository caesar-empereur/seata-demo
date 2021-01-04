package com.feign;

import com.model.Order;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @author: yangyingyang
 * @date: 2021/1/4.
 */
@RequestMapping(value = "/order-service")
public interface OrderFeignService {

    @PostMapping("/save")
    void saveOrder(Order order);
}
