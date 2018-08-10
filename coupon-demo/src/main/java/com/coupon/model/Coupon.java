package com.coupon.model;

public class Coupon {
    private String id;
    private String name;
    private String promocode;
    private String category;

    public Coupon() {    }

    public Coupon(String id, String name, String promocode, String category) {
        this.id = id;
        this.name = name;
        this.promocode = promocode;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPromocode() {
        return promocode;
    }

    public void setPromocode(String promocode) {
        this.promocode = promocode;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
