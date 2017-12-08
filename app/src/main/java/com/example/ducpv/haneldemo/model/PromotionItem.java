package com.example.ducpv.haneldemo.model;

/**
 * Created by ducpv on 12/8/17.
 */

public class PromotionItem {

    private String title;
    private String des;
    private int resouceId;
    private String date;

    public PromotionItem() {
    }

    public PromotionItem(String title, String des, int resouceId, String date) {
        this.title = title;
        this.des = des;
        this.resouceId = resouceId;
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
