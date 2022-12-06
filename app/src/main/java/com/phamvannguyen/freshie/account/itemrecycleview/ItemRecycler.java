package com.phamvannguyen.freshie.account.itemrecycleview;

public class ItemRecycler {
    private int resourceId;
    private String voucherValue;

    public ItemRecycler(int resourceId, String voucherValue) {
        this.resourceId = resourceId;
        this.voucherValue = voucherValue;

    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getVoucherValue() {
        return voucherValue;
    }

    public void setVoucherValue(String voucherValue) {
        this.voucherValue = voucherValue;
    }


}








