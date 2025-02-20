package com.study.TddCleanArch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {
    private String documentNumber = "1234";
    private final Order order = new Order(documentNumber);

    @Test
    public void ShouldCreateOrder() {
        Double total = order.getTotal();
        assertEquals(0.0, total);
    }

    @Test
    public void ShouldCreateOrderWith3Items() {
        order.addItem(new Item(1, "Música", "CD", 30.00), 3);
        order.addItem(new Item(2, "Vídeo", "DVD", 50.00), 1);
        order.addItem(new Item(3, "Vídeo", "VHS", 10.00), 2);

        Double total = order.getTotal();

        assertEquals(160, total);
    }

    @Test
    public void ShouldCreateOrderWith3ItemsAndDiscountCoupon() {
        order.addItem(new Item(1, "Música", "CD", 30.00), 3);
        order.addItem(new Item(2, "Vídeo", "DVD", 50.00), 1);
        order.addItem(new Item(3, "Vídeo", "VHS", 10.00), 2);
        order.addCoupon(new Coupon("VALE20", 20.00));

        Double total = order.getTotal();

        assertEquals(128, total);
    }
}
