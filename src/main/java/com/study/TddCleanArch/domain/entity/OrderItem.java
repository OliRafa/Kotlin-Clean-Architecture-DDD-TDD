package com.study.TddCleanArch.domain.entity;

public class OrderItem {
    private Integer idItem;
    private Double price;
    private Number quantity;

    public OrderItem(Integer idItem, Double price, Number quantity) {
        this.idItem = idItem;
        this.price = price;
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public Number getQuantity() {
        return quantity;
    }

    public Double getTotal() {
        return this.price * this.quantity.doubleValue();
    }
}
