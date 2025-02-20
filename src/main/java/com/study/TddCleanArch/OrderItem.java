package com.study.TddCleanArch;

public class OrderItem {
    private Integer idItem;
    private Double price;
    private Integer quantity;

    public OrderItem(Integer idItem, Double price, Integer quantity) {
        this.idItem = idItem;
        this.price = price;
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getTotal() {
        return this.price * this.quantity;
    }
}
