package com.coupon.dao;

import com.coupon.model.Coupon;

import java.util.List;
import java.util.Map;

public interface CouponDAO {
    Coupon getById(String id);
    Map<String, Coupon> all();
    List<Coupon> list();

    void insert(Coupon coupon);

    void update(Coupon coupon);

    void delete(String id);
}
