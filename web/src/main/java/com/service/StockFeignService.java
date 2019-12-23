package com.service;

import com.Sku;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @author: yangyingyang
 * @date: 2019/11/30.
 */
@FeignClient(name = "feign-service")
@RequestMapping(value = "/storage-service")
public interface StockFeignService {

    @PostMapping("/reduce")
    void reduceStock(@RequestParam("skuId") String skuId, @RequestParam("num") int num);

    @GetMapping("/get")
    Sku getSku(@RequestParam("skuId") String skuId);
}
