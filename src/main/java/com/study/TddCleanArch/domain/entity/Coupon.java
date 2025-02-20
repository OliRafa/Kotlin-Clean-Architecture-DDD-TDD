package com.study.TddCleanArch.domain.entity;

import java.time.LocalDate;

public class Coupon {
    String code;
    Double percentage;
    LocalDate expireDate;

    public Coupon(String code, Double percentage) {
        this.code = code;
        this.percentage = percentage;
        this.expireDate = null;
    }

    public Coupon(String code, Double percentage, LocalDate expireDate) {
        this.code = code;
        this.percentage = percentage;
        this.expireDate = expireDate;
    }

    public Boolean isValid() {
        if (this.expireDate == null) {
            return true;
        }
        LocalDate today = LocalDate.now();
        return this.expireDate.isAfter(today);
    }

    public Boolean isValid(LocalDate today) {
        if (this.expireDate == null) {
            return true;
        }

        return this.expireDate.isAfter(today) || this.expireDate.equals(today);
    }

    public Boolean isExpired(LocalDate today) {
        return !this.isValid(today);
    }

    public Boolean isExpired() {
        LocalDate today = LocalDate.now();
        return !this.isValid(today);
    }
}
