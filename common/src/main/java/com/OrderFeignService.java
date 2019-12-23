package com;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @author: yangyingyang
 * @date: 2019/12/23.
 */
@RequestMapping(value = "/order-service")
public interface OrderFeignService{

    @PostMapping("/save")
    void saveOrder(@RequestBody Order order);
}
