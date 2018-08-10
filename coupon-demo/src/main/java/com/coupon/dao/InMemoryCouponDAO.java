package com.coupon.dao;

import com.coupon.model.Coupon;

import java.util.*;

public class InMemoryCouponDAO implements CouponDAO {

    private static Map<String, Coupon> byId;
    private static List<Coupon> list;

    static {
        byId = new HashMap<String, Coupon>();
        list = new ArrayList<Coupon>();
        byId.put("1", new Coupon("1", "50% Off On Recharge", "GET50", "Recharge"));
        Collection<Coupon> values = byId.values();
        for (Coupon c : values) {
            list.add(c);
        }
    }

    @Override
    public Coupon getById(String id) {
        return byId.get(id);
    }

    @Override
    public Map<String, Coupon> all() {
        return byId;
    }

    @Override
    public List<Coupon> list() {
        return list;
    }

    @Override
    public void insert(Coupon coupon) {
        byId.put(coupon.getId(), coupon);
        list.add(coupon);
    }

    @Override
    public void update(Coupon coupon) {
        byId.put(coupon.getId(), coupon);
        Iterator<Coupon> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId().equals(coupon.getId())) {
                iterator.remove();
            }
        }

        list.add(coupon);
    }

    @Override
    public void delete(String id) {
        byId.remove(id);
        Iterator<Coupon> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId().equals(id)) {
                iterator.remove();
            }
        }
    }
}
