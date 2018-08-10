package com.coupon.action;

import com.coupon.dao.CouponDAO;
import com.coupon.dao.InMemoryCouponDAO;
import com.coupon.model.Coupon;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import java.util.List;

@Results({
        @Result(name="success", type = "redirectAction", params = {"actionName","coupon"})
})
public class CouponCTRL extends ActionSupport implements ModelDriven<Coupon> {

    private CouponDAO dao = new InMemoryCouponDAO();
    private Coupon coupon;
    private List<Coupon> coupons;

    @SkipValidation
    public HttpHeaders index() {
        coupons = dao.list();
        return new DefaultHttpHeaders("index")
                .disableCaching();
    }

    public String editNew() {
        return SUCCESS;
    }

    public String create() {
        dao.insert(coupon);
        return SUCCESS;
    }

    public String update() {
        dao.update(coupon);
        return SUCCESS;
    }

    @SkipValidation
    public String edit() {
        coupon = dao.getById(coupon.getId());
        return INPUT;
    }

    @SkipValidation
    public String destroy() {
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

    @Override
    public Coupon getModel() {
        return coupon;
    }
}
