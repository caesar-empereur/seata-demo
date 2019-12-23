package com;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description
 * @author: yangyingyang
 * @date: 2019/12/23.
 */
@RequestMapping(value = "/storage-service")
public interface StockFeignService {

    @PostMapping("/reduce")
    void reduceStock(@RequestParam("skuId") String skuId, @RequestParam("num") int num);

    @GetMapping("/get")
    Sku getSku(@RequestParam("skuId") String skuId);
}
