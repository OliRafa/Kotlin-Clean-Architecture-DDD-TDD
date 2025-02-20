package com.study.TddCleanArch.domain.repository;

import com.study.TddCleanArch.domain.entity.Order;

public interface OrderRepository {
    void save(Order order);
}
