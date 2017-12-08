package com.example.ducpv.haneldemo.model;

/**
 * Created by ducpv on 12/7/17.
 */

public class NewestItem {

    private String title;
    private String des;
    private int resouceId;
    private double price;
    private double promoPrice;

    public NewestItem(String title, String des, int resouceId, double price, double promoPrice) {
        this.title = title;
        this.des = des;
        this.resouceId = resouceId;
        this.price = price;
        this.promoPrice = promoPrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getResouceId() {
        return resouceId;
    }

    public void setResouceId(int resouceId) {
        this.resouceId = resouceId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPromoPrice() {
        return promoPrice;
    }

    public void setPromoPrice(double promoPrice) {
        this.promoPrice = promoPrice;
    }
}
