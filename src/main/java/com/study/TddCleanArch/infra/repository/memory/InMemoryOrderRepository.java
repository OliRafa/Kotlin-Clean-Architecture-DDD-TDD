package com.study.TddCleanArch.infra.repository.memory;

import java.util.ArrayList;
import java.util.List;

import com.study.TddCleanArch.domain.entity.Order;
import com.study.TddCleanArch.domain.repository.OrderRepository;

public class InMemoryOrderRepository implements OrderRepository {
    List<Order> orders;

    public InMemoryOrderRepository() {
        this.orders = new ArrayList<Order>();
    }

    @Override
    public void save(Order order) {
        this.orders.add(order);
    }
}
