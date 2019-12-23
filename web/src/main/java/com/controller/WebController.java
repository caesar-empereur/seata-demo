package com.controller;

import com.Order;
import com.Sku;
import com.AccountFeignClient;
import com.service.AccountService;
import com.service.OrderFeignService;
import com.service.StockFeignService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @author: yangyingyang
 * @date: 2019/11/30.
 */
@RestController
@RequestMapping(value = "/order")
public class WebController {

    @Resource
    private AccountService accountService;
    @Resource
    private OrderFeignService orderFeignService;
    @Resource
    private StockFeignService stockFeignService;

    @PostMapping("/submit")
    @GlobalTransactional
    public void saveOrder(@RequestBody Submit submit){
        Sku sku = stockFeignService.getSku(submit.getSkuId());
        Integer totolPrice = sku.getPrice()*submit.getNum();

        stockFeignService.reduceStock(submit.getSkuId(), submit.getNum());

        accountService.deduction(submit.getAccountId(), totolPrice);

        Order order = new Order();
        order.setPrice(totolPrice);
        order.setAccountId(submit.getAccountId());
        order.setSkuId(submit.getSkuId());

        orderFeignService.saveOrder(order);
    }

    static class Submit{
        private String skuId;
        private String accountId;
        private Integer num;

        public String getSkuId() {
            return skuId;
        }

        public void setSkuId(String skuId) {
            this.skuId = skuId;
        }

        public String getAccountId() {
            return accountId;
        }

        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }

        public Integer getNum() {
            return num;
        }

        public void setNum(Integer num) {
            this.num = num;
        }
    }
}
