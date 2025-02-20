package com.study.TddCleanArch.domain.repository;

import java.util.Optional;

import com.study.TddCleanArch.domain.entity.Coupon;

public interface CouponRepository {
    Optional<Coupon> findByCode(String code);
}
