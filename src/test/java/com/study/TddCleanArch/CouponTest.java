package com.study.TddCleanArch;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

public class CouponTest {
    @Test
    public void ShouldCreateAValidCoupon() {
        Coupon coupon = new Coupon("VALE20", 20.0, LocalDate.of(2021, 12, 20));
        Boolean isValid = coupon.isValid(LocalDate.of(2021, 12, 20));
        assertEquals(true, isValid);
    }

    @Test
    public void ShouldCreateExpiredCoupon() {
        Coupon coupon = new Coupon("VALE20", 20.0, LocalDate.of(2021, 3, 10));
        Boolean isExpired = coupon.isExpired(LocalDate.of(2021, 12, 10));
        assertEquals(true, isExpired);
    }
}
