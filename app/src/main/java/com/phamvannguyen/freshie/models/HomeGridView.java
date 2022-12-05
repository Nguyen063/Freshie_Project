package com.phamvannguyen.freshie.models;

public class HomeGridView {
    int productImg;
    String productNameHome;
    double productPriceHome;
    double productDiscountHome;
    double ratingValueHome;
    double ratingCountHome;
    double soldCountHome;

    public HomeGridView(int productImg, String productNameHome, double productPriceHome, double productDiscountHome, double ratingValueHome, double ratingCountHome, double soldCountHome) {
        this.productImg = productImg;
        this.productNameHome = productNameHome;
        this.productPriceHome = productPriceHome;
        this.productDiscountHome = productDiscountHome;
        this.ratingValueHome = ratingValueHome;
        this.ratingCountHome = ratingCountHome;
        this.soldCountHome = soldCountHome;
    }

    public int getProductImg() {
        return productImg;
    }

    public void setProductImg(int productImg) {
        this.productImg = productImg;
    }

    public String getProductNameHome() {
        return productNameHome;
    }

    public void setProductNameHome(String productNameHome) {
        this.productNameHome = productNameHome;
    }

    public double getProductPriceHome() {
        return productPriceHome;
    }

    public void setProductPriceHome(double productPriceHome) {
        this.productPriceHome = productPriceHome;
    }

    public double getProductDiscountHome() {
        return productDiscountHome;
    }

    public void setProductDiscountHome(double productDiscountHome) {
        this.productDiscountHome = productDiscountHome;
    }

    public double getRatingValueHome() {
        return ratingValueHome;
    }

    public void setRatingValueHome(double ratingValueHome) {
        this.ratingValueHome = ratingValueHome;
    }

    public double getRatingCountHome() {
        return ratingCountHome;
    }

    public void setRatingCountHome(int ratingCountHome) {
        this.ratingCountHome = ratingCountHome;
    }

    public double getSoldCountHome() {
        return soldCountHome;
    }

    public void setSoldCountHome(int soldCountHome) {
        this.soldCountHome = soldCountHome;
    }
}