package com.lambdaschool.orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// deleted my OrdersService and OrdersServiceImpl files from services bc they were not needed

@SpringBootApplication
public class OrdersApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(OrdersApplication.class, args);
    }
}
