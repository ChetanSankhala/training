package com.coupon.action;

import com.coupon.dao.CouponDAO;
import com.coupon.dao.InMemoryCouponDAO;
import com.coupon.model.Coupon;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.validation.SkipValidation;

import java.util.List;

public class CouponCTRL extends ActionSupport {

    private CouponDAO dao = new InMemoryCouponDAO();
    private Coupon coupon;
    private List<Coupon> coupons;

    @SkipValidation
    public String index() {
        coupons = dao.list();
        return SUCCESS;
    }

    public String save() {
        if (coupon.getId() == null) {
            dao.insert(coupon);
        } else {
            dao.update(coupon);
        }
        return SUCCESS;
    }

    @SkipValidation
    public String edit() {
        coupon = dao.getById(coupon.getId());
        return INPUT;
    }

    @SkipValidation
    public String addNew() {
        coupon = dao.getById(coupon.getId());
        return INPUT;
    }

    @SkipValidation
    public String delete() {
        dao.delete(coupon.getId());
        return SUCCESS;
    }


    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public List<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }


    @Override
    public void validate() {
        if (coupon == null) {
            return;
        }

        if (coupon.getName()== null || coupon.getName().isEmpty()) {
            addFieldError("coupon.name", "Name is required");
        }

        if (coupon.getPromocode()== null || coupon.getPromocode().isEmpty()) {
            addFieldError("coupon.promocode", "Promocode is required");
        }
    }
}
