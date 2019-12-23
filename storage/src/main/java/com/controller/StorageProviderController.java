package com.controller;

import com.Sku;
import com.repository.SkuRepository;
import com.service.StockFeignService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @author: yangyingyang
 * @date: 2018/9/10.
 */
@RestController
//@RequestMapping("/provider/storage-service")
public class StorageProviderController implements StockFeignService {

    @Resource
    private SkuRepository skuRepository;

    @Override
    public void reduceStock(String skuId, int num) {

        Sku sku = skuRepository.getOne(skuId);
        if (sku.getNum()<num){
            throw new RuntimeException("库存不足");
        }
        skuRepository.reduce(num, skuId);
    }

    @Override
    public Sku getSku(String skuId) {
        return skuRepository.getOne(skuId);
    }
}
