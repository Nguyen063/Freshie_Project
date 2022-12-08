package com.phamvannguyen.freshie.models;

import android.os.Parcel;
import android.os.Parcelable;

public class ProductBase implements Parcelable {
    int ProductID;
    String ProductName;
    double OriginalPrice;
    double Price;
    String ThumbUrl;

    public ProductBase(int productID, String productName, double originalPrice, double price, String thumbUrl) {
        ProductID = productID;
        ProductName = productName;
        OriginalPrice = originalPrice;
        Price = price;
        ThumbUrl = thumbUrl;
    }

    protected ProductBase(Parcel in) {
        super();
        ProductID = in.readInt();
        ProductName = in.readString();
        OriginalPrice = in.readDouble();
        Price = in.readDouble();
        ThumbUrl = in.readString();
    }

    public static final Creator<ProductBase> CREATOR = new Creator<ProductBase>() {
        @Override
        public ProductBase createFromParcel(Parcel in) {
            return new ProductBase(in);
        }

        @Override
        public ProductBase[] newArray(int size) {
            return new ProductBase[size];
        }
    };

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
    public String getFormattedPrice() {
        return String.format("%,.0f đ", Price);
    }
    public String getFormattedOriginalPrice (){
        return String.format("%,.0f đ", OriginalPrice);
    }

    public String getThumbUrl() {
        return ThumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        ThumbUrl = thumbUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(ProductID);
        parcel.writeString(ProductName);
        parcel.writeDouble(OriginalPrice);
        parcel.writeDouble(Price);
        parcel.writeString(ThumbUrl);
    }
}
