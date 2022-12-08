package com.phamvannguyen.freshie.models;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Parcel;
import android.os.Parcelable;

import com.phamvannguyen.freshie.DataBaseHelper;
import com.phamvannguyen.freshie.MainActivity;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Product extends ProductBase implements Parcelable {
    private DataBaseHelper db = MainActivity.db;
//    int ProductID;
//    String ProductName;
    String Category;
    String Brand;
//    double OriginalPrice;
//    double Price;
    double Discount;
    int Sold;
    double RatingAverage;
    int RatingCount;
    String ImageUrl;
//    String ThumbUrl;
    int IsDeal;
    int IsBestSeller;
    int IsNew;
    String Description;

    public Product(int productID, String productName,  String category, String brand, double originalPrice, double price, int sold, double ratingAverage,
                   int ratingCount, String imageUrl, String thumbUrl, int isDeal, int isBestSeller, int isNew, String description) {
        super(productID, productName, originalPrice, price, thumbUrl);
        Category = category;
        Brand = brand;
        Discount = (originalPrice - price) / originalPrice * 100;
        Sold = sold;
        RatingAverage = ratingAverage;
        RatingCount = ratingCount;
        ImageUrl = imageUrl;
//        ThumbUrl = thumbUrl;
        IsDeal = isDeal;
        IsBestSeller = isBestSeller;
        IsNew = isNew;
        Description = description;
    }

    //    public Product( int productID, String productName, String category,
//                   String brand, double originalPrice, double price,  int sold, double ratingAverage,
//                   int ratingCount, String imageUrl, String thumbUrl, int isDeal, int isBestSeller, int isNew,
//                    String description) {
//        ProductID = productID;
//        ProductName = productName;
//        CategoryProduct = category;
//        Brand = brand;
//        OriginalPrice = originalPrice;
//        Price = price;
//        Discount = (OriginalPrice - Price)/OriginalPrice * 100;
//        Sold = sold;
//        RatingAverage = ratingAverage/10;
//        RatingCount = ratingCount;
//        ImageUrl = imageUrl;
//        ThumbUrl = thumbUrl;
//        IsDeal = isDeal;
//        IsBestSeller = isBestSeller;
//        IsNew = isNew;
//        Description = description;
//    }


    //    public Product(int productID) {
//        ProductID = productID;
//        Cursor c = db.getData("SELECT * FROM "+ DataBaseHelper.TBL_PRODUCT + " WHERE "+ DataBaseHelper.COL_ID +" = " + ProductID);
//
//        c.moveToFirst();
//        ProductName = c.getString(1);
//        CategoryProduct = c.getString(2);
//        Brand = c.getString(3);
//        OriginalPrice = c.getDouble(4);
//        Price = c.getDouble(5);
//        Discount = (OriginalPrice - Price)/OriginalPrice * 100;
//        Sold = c.getInt(6);
//        RatingAverage = c.getDouble(7);
//        RatingCount = c.getInt(8);
//        ThumbUrl = c.getString(12);
//        ImageUrl = c.getString(10);
//        Description = c.getString(16);
//        IsDeal = c.getInt(13) == 1;
//        IsBestSeller = c.getInt(14) == 1;
//        IsNew = c.getInt(15) == 1;
//
//
//    }





    public DataBaseHelper getDb() {
        return db;
    }

    public void setDb(DataBaseHelper db) {
        this.db = db;
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


    public int getIsDeal() {
        return IsDeal;
    }

    public void setIsDeal(int isDeal) {
        IsDeal = isDeal;
    }

    public int getIsBestSeller() {
        return IsBestSeller;
    }

    public void setIsBestSeller(int isBestSeller) {
        IsBestSeller = isBestSeller;
    }

    public int getIsNew() {
        return IsNew;
    }

    public void setIsNew(int isNew) {
        IsNew = isNew;
    }

    public void setRatingCount(int ratingCount) {
        RatingCount = ratingCount;
    }

    public String getFormattedDiscount (){
        if(Discount > 0){
            return String.format("-%.0f%% ", Discount);

        }
        else{
            return "";
        }
    }

    public Bitmap getImageBitmap(){
        InputStream inputStream = null;
        try {
            inputStream = new URL(ImageUrl).openStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(inputStream);
            return myBitmap;
        } catch (IOException e) {
            // Log exception
            return null;
        }
    }

    public void writeToParcel(Parcel parcel, int i){
        parcel.writeInt(ProductID);
        parcel.writeString(ProductName);
        parcel.writeString(Category);
        parcel.writeString(Brand);
        parcel.writeDouble(OriginalPrice);
        parcel.writeDouble(Price);
        parcel.writeDouble(Discount);
        parcel.writeInt(Sold);
        parcel.writeDouble(RatingAverage);
        parcel.writeInt(RatingCount);
        parcel.writeString(ImageUrl);
        parcel.writeString(ThumbUrl);
        parcel.writeInt(IsDeal);
        parcel.writeInt(IsBestSeller);
        parcel.writeInt(IsNew);
        parcel.writeString(Description);
    }
    protected Product(Parcel in) {
        super(in);
        ProductID = in.readInt();
        ProductName = in.readString();
        Category = in.readString();
        Brand = in.readString();
        OriginalPrice = in.readDouble();
        Price = in.readDouble();
        Discount = in.readDouble();
        Sold = in.readInt();
        RatingAverage = in.readDouble();
        RatingCount = in.readInt();
        ImageUrl = in.readString();
        ThumbUrl = in.readString();
        IsDeal = in.readInt();
        IsBestSeller = in.readInt();
        IsNew = in.readInt();
        Description = in.readString();
    }

}
