package com.phamvannguyen.freshie.model;

public class Rating {
    int productThumb;
    String productName;

    public Rating(int productThumb, String productName) {
        this.productThumb = productThumb;
        this.productName = productName;
    }

    public int getProductThumb() {
        return productThumb;
    }

    public void setProductThumb(int productThumb) {
        this.productThumb = productThumb;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
