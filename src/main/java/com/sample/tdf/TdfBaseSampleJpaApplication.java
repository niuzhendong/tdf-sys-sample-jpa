package com.sample.tdf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableCaching
@SpringBootApplication(scanBasePackages = {"com.sample.tdf", "cn.com.taiji"})
@EntityScan(basePackages = {"com.sample.tdf", "cn.com.taiji"})
@EnableJpaRepositories(basePackages = {"com.sample.tdf", "cn.com.taiji"})
public class TdfBaseSampleJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TdfBaseSampleJpaApplication.class, args);
    }

}
