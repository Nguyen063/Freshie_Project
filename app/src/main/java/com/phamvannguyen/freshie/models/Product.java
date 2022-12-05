package com.phamvannguyen.freshie.models;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.phamvannguyen.freshie.DataBaseHelper;
import com.phamvannguyen.freshie.MainActivity;

public class Product {
    private DataBaseHelper db = MainActivity.db;
    int ProductID;
    String ProductName;
    String Category;
    String Brand;
    double OriginalPrice;
    double Price;
    double Discount;
    int Sold;
    double RatingAverage;
    int RatingCount;
    String ThumbUrl;
    String ImageUrl;
    String Description;


    public Product(int productID) {
        ProductID = productID;
        Cursor c = db.getData("SELECT * FROM "+ DataBaseHelper.TBL_PRODUCT + " WHERE "+ DataBaseHelper.COL_ID +" = " + ProductID);

        c.moveToFirst();
        ProductName = c.getString(1);
        Category = c.getString(2);
        Brand = c.getString(3);
        OriginalPrice = c.getDouble(4);
        Price = c.getDouble(5);
        Discount = (OriginalPrice - Price)/OriginalPrice * 100;
        Sold = c.getInt(6);
        RatingAverage = c.getDouble(7);
        RatingCount = c.getInt(8);
        ThumbUrl = c.getString(12);
        ImageUrl = c.getString(10);


    }

    public DataBaseHelper getDb() {
        return db;
    }

    public void setDb(DataBaseHelper db) {
        this.db = db;
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

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getThumbUrl() {
        return ThumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        ThumbUrl = thumbUrl;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public Bitmap getThumb(){
        return MainActivity.getBitmapFromURL(ThumbUrl);
    }
    public Bitmap getImage(){
        return MainActivity.getBitmapFromURL(ImageUrl);
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
