package com.phamvannguyen.freshie.models;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Product {
    int ProductID;
    String ProductName;
    int Category;
    String Brand;
    double OriginalPrice;
    double Price;
    double Discount;
    int Sold;
    double RatingAverage;
    int RatingCount;
    byte[] Image;

    public Product(int productID, String productName, int category,
                   String brand, double originalPrice, double price,
                   int sold, double ratingAverage, int ratingCount, byte[]image) {
        ProductID = productID;
        ProductName = productName;
        Category = category;
        Brand = brand;
        OriginalPrice = originalPrice;
        Price = price;
        Discount = (OriginalPrice - Price) / OriginalPrice * 100;
        Sold = sold;
        RatingAverage = ratingAverage;
        RatingCount = ratingCount;
        Image = image;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int productID) {
        ProductID = productID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public int getCategory() {
        return Category;
    }

    public void setCategory(int category) {
        Category = category;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public double getOriginalPrice() {
        return OriginalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        OriginalPrice = originalPrice;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public double getDiscount() {
        return Discount;
    }

    public void setDiscount(double discount) {
        Discount = discount;
    }

    public int getSold() {
        return Sold;
    }

    public void setSold(int sold) {
        Sold = sold;
    }

    public double getRatingAverage() {
        return RatingAverage;
    }

    public void setRatingAverage(double ratingAverage) {
        RatingAverage = ratingAverage;
    }

    public int getRatingCount() {
        return RatingCount;
    }

    public byte[] getImage() {
        return Image;
    }

    public void setImage(byte[] image) {
        Image = image;
    }

    public Bitmap getImageBitmap() {

        return BitmapFactory.decodeByteArray(Image, 0, Image.length);
    }

    public void setRatingCount(int ratingCount) {
        RatingCount = ratingCount;
    }
    public String getFormattedPrice() {
        return String.format("%,.0f đ", Price);
    }
    public String getFormattedOriginalPrice (){
        return String.format("%,.0f đ", OriginalPrice);
    }
    public String getFormattedDiscount (){
        return String.format("-%.0f%% ", Discount);
    }
}
