package com.study.TddCleanArch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class OrderItemTest {
    @Test
    public void ShouldCreateAOrderItem() {
        OrderItem orderItem = new OrderItem(1, 1000.00, 10);
        Double total = orderItem.getTotal();
        assertEquals(10000.00, total);
    }
}
