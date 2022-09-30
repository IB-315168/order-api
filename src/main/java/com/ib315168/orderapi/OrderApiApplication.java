package com.ib315168.orderapi;

import com.ib315168.orderapi.model.Order;
import com.ib315168.orderapi.repository.OrderRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class OrderApiApplication
{

  public static void main(String[] args)
  {
    SpringApplication.run(OrderApiApplication.class, args);
  }
}
