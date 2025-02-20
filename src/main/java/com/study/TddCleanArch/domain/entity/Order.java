package com.study.TddCleanArch.domain.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private Document document;
    private List<OrderItem> orderItems = new ArrayList<>();
    private Coupon coupon;
    private LocalDate date;

    public Order(String documentNumber, LocalDate date) {
        this.document = new Document(documentNumber);
        this.date = date;
    }

    public Order(String documentNumber) {
        this.document = new Document(documentNumber);
        this.date = LocalDate.now();
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
            total -= total * this.coupon.percentage / 100;
        }

        return total;
    }

    public void addCoupon(Coupon coupon) {
        if (coupon.isValid(this.date)) {
            this.coupon = coupon;
        }
    }
}
