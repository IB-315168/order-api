package com.ib315168.orderapi.controller;

import com.ib315168.orderapi.model.Order;
import com.ib315168.orderapi.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ControllerAdvice
@RequestMapping("/orders")
public class OrderController
{
  public OrderController()
  {
  }

  @RequestMapping(method = RequestMethod.POST,
  produces = {MediaType.APPLICATION_JSON_VALUE})
  @ResponseStatus(HttpStatus.CREATED)
  @ResponseBody
  public Order createOrder(@RequestBody Order order) {
    return OrderRepository.create(order.getDesc(), order.getPrice(), order.isDelivery());
  }

  @RequestMapping(method = RequestMethod.PATCH)
  @ResponseBody
  public void updateOrder(@RequestBody Order order) {
    OrderRepository.update(order);
  }

  @RequestMapping(method = RequestMethod.GET,
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public List<Order> getAllOrders() {
    return OrderRepository.getAll();
  }

  @RequestMapping(value = "/{id}",
      method = RequestMethod.GET,
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public Order getOrder(@PathVariable Long id) {;
    Order order;
    try {
      order = OrderRepository.get(id);
    } catch (Exception e) {
      return new Order(-1L, e.getMessage(), 0, false);
    }
    return order;
  }
}
