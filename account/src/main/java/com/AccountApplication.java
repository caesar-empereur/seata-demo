package com;

import io.seata.spring.annotation.GlobalTransactionScanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by yang on 2018/1/8.
 */
@ComponentScan("com")
@EntityScan("com")
@SpringCloudApplication
@EnableFeignClients
@EnableSwagger2
@Import(DataSourceProxyConfiguration.class)
public class AccountApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }

    @Bean
    public GlobalTransactionScanner globalTransactionScanner() {
        return new GlobalTransactionScanner("account-service", "seata-group");
    }
}
