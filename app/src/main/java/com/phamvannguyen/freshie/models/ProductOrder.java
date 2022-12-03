package com.phamvannguyen.freshie.models;

public class ProductOrder {
    int productThumb;
    String productName;
    double productPrice;
    int productNum;

    public ProductOrder(int productThumb, String productName, double productPrice, int productNum) {
        this.productThumb = productThumb;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productNum = productNum;
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

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductNum() {
        return productNum;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }
}
