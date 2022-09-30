package com.ib315168.orderapi.model;

public class Order
{
  private long id;
  private String desc;
  private double price;
  private boolean delivery;

  public Order() {}

  public Order(long id, String desc, double price, boolean delivery)
  {
    this.id = id;
    this.desc = desc;
    this.price = price;
    this.delivery = delivery;
  }

  public long getId()
  {
    return id;
  }

  public String getDesc()
  {
    return desc;
  }

  public double getPrice()
  {
    return price;
  }

  public boolean isDelivery()
  {
    return delivery;
  }

  public void setDesc(String desc)
  {
    this.desc = desc;
  }

  public void setPrice(double price)
  {
    this.price = price;
  }

  public void setDelivery(boolean delivery)
  {
    this.delivery = delivery;
  }

  @Override public String toString() {
    return "Id: " + id + "\nDesc: " + desc + "\nPrice: " + price + "\nDelivery: " + delivery;
  }
}
