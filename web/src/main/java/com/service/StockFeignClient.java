package com.service;

import com.StockFeignService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Description
 * @author: yangyingyang
 * @date: 2019/11/30.
 */
@FeignClient(name = "storage-service")
public interface StockFeignClient extends StockFeignService {

}
