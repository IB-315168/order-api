package com.ib315168.orderapi.repository;

import com.ib315168.orderapi.model.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRepository
{
  private static final Map<Long, Order> orders = new HashMap<>();

  //CRUD DB (interface later)
  static
  {
    initDataSource();
  }

  private static void initDataSource()
  {
    Order o = new Order(1345L, "12 \n1x + Bacon \n1x + Kylling", 84, true);
    Order o1 = new Order(1346L, "46 \n1x + Dressing", 75, true);
    Order o2 = new Order(1347L, "46", 75, false);
    Order o3 = new Order(1348L, "46 \n 1.5l sodavand", 130, true);

    orders.put(o.getId(), o);
    orders.put(o1.getId(), o1);
    orders.put(o2.getId(), o2);
    orders.put(o3.getId(), o3);
  }

  public static Order create(String desc, double price, boolean delivery)
  {
    long id = (long) orders.keySet().toArray()[orders.keySet().size() - 1];
    id += 1;

    return orders.put(id, new Order(id, desc, price, delivery));
  }

  public static Order get(long id)
  {
    return orders.getOrDefault(id,
        new Order(-1L, "Order with " + id + " does not exist", 0, false));
  }

  public static void update(Order order)
  {
    orders.replace(order.getId(), order);
  }

  public static Order delete(Order order)
  {
    return orders.remove(order.getId());
  }

  public static List<Order> getAll() {
    return orders.values().stream().toList();
  }
}
