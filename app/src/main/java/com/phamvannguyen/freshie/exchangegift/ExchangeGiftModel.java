package com.phamvannguyen.freshie.exchangegift;

public class ExchangeGiftModel {
    int voucherGift;
    String voucherSale;
    String voucherCondition;
    String voucherTime;
    int voucherPoint;

    public ExchangeGiftModel(int voucherGift, String voucherSale, String voucherCondition,
                             String voucherTime, int voucherPoint ) {
        this.voucherGift = voucherGift;
        this.voucherSale = voucherSale;
        this.voucherCondition = voucherCondition;
        this.voucherTime = voucherTime;
        this.voucherPoint = voucherPoint;
    }

    public int getVoucherGift() {
        return voucherGift;
    }

    public void setVoucherGift(int voucherGift) {
        this.voucherGift = voucherGift;
    }

    public String getVoucherSale() {
        return voucherSale;
    }

    public void setVoucherSale(String voucherSale) {
        this.voucherSale = voucherSale;
    }

    public String getVoucherCondition() {
        return voucherCondition;
    }

    public void setVoucherCondition(String voucherCondition) {
        this.voucherCondition = voucherCondition;
    }

    public String getVoucherTime() {
        return voucherTime;
    }

    public void setVoucherTime(String voucherTime) {
        this.voucherTime = voucherTime;
    }

    public int getVoucherPoint() {
        return voucherPoint;
    }

    public void setVoucherPoint(int voucherPoint) {
        this.voucherPoint = voucherPoint;
    }
}
