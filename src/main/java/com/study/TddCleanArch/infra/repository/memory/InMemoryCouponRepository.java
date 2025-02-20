package com.study.TddCleanArch.infra.repository.memory;

import java.util.List;
import java.util.Optional;

import com.study.TddCleanArch.domain.entity.Coupon;
import com.study.TddCleanArch.domain.repository.CouponRepository;

public class InMemoryCouponRepository implements CouponRepository {
    List<Coupon> coupons;

    public InMemoryCouponRepository() {
        this.coupons = List.of(
                new Coupon("VALE20", 20.0));
    }

    @Override
    public Optional<Coupon> findByCode(String code) {
        for (Coupon coupon : this.coupons) {
            if (coupon.getCode().equals(code)) {
                return Optional.of(coupon);
            }
        }
        return Optional.empty();
    }
}
