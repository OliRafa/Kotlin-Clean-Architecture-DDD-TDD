package com.study.TddCleanArch.domain.useCase.placeOrder;

import java.util.Map;
import java.util.Optional;

import com.study.TddCleanArch.domain.entity.Coupon;
import com.study.TddCleanArch.domain.entity.Item;
import com.study.TddCleanArch.domain.entity.Order;
import com.study.TddCleanArch.domain.repository.CouponRepository;
import com.study.TddCleanArch.domain.repository.ItemRepository;
import com.study.TddCleanArch.domain.repository.OrderRepository;

public class PlaceOrder {
    ItemRepository itemRepository;
    OrderRepository orderRepository;
    CouponRepository couponRepository;

    public PlaceOrder(CouponRepository couponRepository, ItemRepository itemRepository,
            OrderRepository orderRepository) {
        this.couponRepository = couponRepository;
        this.itemRepository = itemRepository;
        this.orderRepository = orderRepository;
    }

    public PlaceOrderOutput execute(PlaceOrderInput input) throws Exception {
        Order order = new Order(input.documentNumber, input.date);
        for (Map<String, Number> orderItem : input.orderItems) {
            Optional<Item> item = this.itemRepository.findById(orderItem.get("idItem").toString());
            if (item.isEmpty()) {
                throw new Exception("Item not found.");
            }

            order.addItem(item.get(), orderItem.get("quantity"));
        }
        if (input.coupon != null) {
            Optional<Coupon> coupon = this.couponRepository.findByCode(input.coupon);
            if (coupon.isPresent()) {
                order.addCoupon(coupon.get());
            }
        }
        this.orderRepository.save(order);
        return new PlaceOrderOutput(order.getTotal());
    }
}
