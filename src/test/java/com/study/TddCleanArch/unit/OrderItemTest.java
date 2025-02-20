package com.study.TddCleanArch.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

import com.study.TddCleanArch.domain.entity.OrderItem;

public class OrderItemTest {
    @Test
    public void ShouldCreateAOrderItem() {
        OrderItem orderItem = new OrderItem(1, 1000.00, 10);
        Double total = orderItem.getTotal();
        assertEquals(10000.00, total);
    }
}
