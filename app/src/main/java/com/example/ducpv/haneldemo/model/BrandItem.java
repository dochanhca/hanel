package com.example.ducpv.haneldemo.model;

/**
 * Created by ducpv on 12/7/17.
 */

public class BrandItem {

    public static final int GROUP_TYPE = 0;
    public static final int CHILD_TYPE = 1;

    private String brandName;
    private String discountNum;
    private int logo;
    private boolean isLike;
    private int type;

    public BrandItem() {
    }

    public BrandItem(String brandName, String discountNum, int logo, boolean isLike, int type) {
        this.brandName = brandName;
        this.discountNum = discountNum;
        this.logo = logo;
        this.isLike = isLike;
        this.type = type;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getDiscountNum() {
        return discountNum;
    }

    public void setDiscountNum(String discountNum) {
        this.discountNum = discountNum;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
