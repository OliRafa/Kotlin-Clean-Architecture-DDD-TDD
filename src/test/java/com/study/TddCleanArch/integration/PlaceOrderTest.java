package com.study.TddCleanArch.integration;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.study.TddCleanArch.domain.useCase.placeOrder.PlaceOrder;
import com.study.TddCleanArch.domain.useCase.placeOrder.PlaceOrderInput;
import com.study.TddCleanArch.domain.useCase.placeOrder.PlaceOrderOutput;
import com.study.TddCleanArch.infra.repository.memory.InMemoryCouponRepository;
import com.study.TddCleanArch.infra.repository.memory.InMemoryItemRepository;
import com.study.TddCleanArch.infra.repository.memory.InMemoryOrderRepository;

public class PlaceOrderTest {
    @Test
    public void ShouldPlaceAnOrder() throws Exception {
        InMemoryCouponRepository couponRepository = new InMemoryCouponRepository();
        InMemoryItemRepository itemRepository = new InMemoryItemRepository();
        InMemoryOrderRepository orderRepository = new InMemoryOrderRepository();
        PlaceOrder placeOrder = new PlaceOrder(couponRepository, itemRepository, orderRepository);

        PlaceOrderInput input = new PlaceOrderInput("1234.1243.12",
                List.of(Map.of("idItem", 1, "quantity", 1), Map.of("idItem", 2, "quantity", 2),
                        Map.of("idItem", 3, "quantity", 3)),
                LocalDate.of(2021, 12, 10),
                "VALE20");

        PlaceOrderOutput output = placeOrder.execute(input);
        Double total = output.total();
        assertEquals(Double.valueOf(128.00), total);
    }
}
