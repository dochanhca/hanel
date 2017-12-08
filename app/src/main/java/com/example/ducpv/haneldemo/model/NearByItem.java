package com.example.ducpv.haneldemo.model;

/**
 * Created by ducpv on 12/7/17.
 */

public class NearByItem {

    private String shopName;
    private String address;
    private String ip;
    private String discount;
    private int resourceId;

    public NearByItem(String shopName, String address, String ip, String discount, int resourceId) {
        this.shopName = shopName;
        this.address = address;
        this.ip = ip;
        this.discount = discount;
        this.resourceId = resourceId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
}
