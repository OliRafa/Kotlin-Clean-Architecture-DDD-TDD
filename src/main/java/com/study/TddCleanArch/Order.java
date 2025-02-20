package com.study.TddCleanArch;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Document document;
    private List<OrderItem> orderItems = new ArrayList<>();
    private Coupon coupon;

    public Order(String documentNumber) {
        this.document = new Document(documentNumber);
    }

    public void addItem(Item item, Integer quanitity) {
        this.orderItems.add(new OrderItem(item.id(), item.price(), quanitity));
    }

    public Double getTotal() {
        Double total = 0.0;
        for (OrderItem orderItem : this.orderItems) {
            total += orderItem.getTotal();
        }

        if (this.coupon != null) {
            total -= total * this.coupon.percentage() / 100;
        }

        return total;
    }

    public void addCoupon(Coupon coupon) {
        this.coupon = coupon;
    }
}
