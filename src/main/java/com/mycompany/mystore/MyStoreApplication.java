package com.mycompany.mystore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.mycompany.mystore"})
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.mycompany.mystore"})
public class MyStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyStoreApplication.class, args);
    }
}