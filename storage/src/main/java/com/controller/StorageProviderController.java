package com.controller;

import com.model.Sku;
import com.feign.StockFeignService;
import com.repository.SkuRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @author: yangyingyang
 * @date: 2018/9/10.
 */
@RestController
public class StorageProviderController implements StockFeignService {

    @Resource
    private SkuRepository skuRepository;

    @Override
    public void reduceStock(@RequestParam("skuId") String skuId, @RequestParam("num") int num) {
        Sku sku = skuRepository.getOne(skuId);
        if (sku.getNum()<num){
            throw new RuntimeException("库存不足");
        }
        skuRepository.reduce(num, skuId);
    }

    @Override
    public Sku getSku(@RequestParam("skuId") String skuId) {
        return skuRepository.getOne(skuId);
    }
}
