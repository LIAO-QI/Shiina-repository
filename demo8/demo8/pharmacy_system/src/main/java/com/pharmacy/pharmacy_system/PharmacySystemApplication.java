package com.pharmacy.pharmacy_system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan(basePackages = {"com.pharmacy.pharmacy_system.business.dao"})
@SpringBootApplication
@EnableScheduling
@EnableAsync
public class PharmacySystemApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PharmacySystemApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(PharmacySystemApplication.class, args);
    }
}
