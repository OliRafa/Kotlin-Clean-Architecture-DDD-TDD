package com.study.TddCleanArch.domain.useCase.placeOrder;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class PlaceOrderInput {
    String coupon;
    LocalDate date;
    String documentNumber;
    List<Map<String, Number>> orderItems;

    public PlaceOrderInput(String documentNumber, List<Map<String, Number>> orderItems, LocalDate date) {
        this.coupon = null;
        this.date = date;
        this.documentNumber = documentNumber;
        this.orderItems = orderItems;
    }

    public PlaceOrderInput(String documentNumber, List<Map<String, Number>> orderItems, LocalDate date, String coupon) {
        this.coupon = coupon;
        this.date = date;
        this.documentNumber = documentNumber;
        this.orderItems = orderItems;
    }
}
