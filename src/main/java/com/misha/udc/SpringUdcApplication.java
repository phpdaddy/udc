package com.misha.udc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.misha.udc.repository.jpa")
@EntityScan(basePackages = "com.misha.udc.model.jpa")
public class SpringUdcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringUdcApplication.class, args);
    }
}
