package com.phamvannguyen.freshie.cart;

import android.os.Parcel;

import com.phamvannguyen.freshie.models.ProductBase;

public class CartModel extends ProductBase  {
    int quantity;


    public CartModel(int productID, String productName, double originalPrice, double price, String thumbUrl, int quantity) {
        super(productID, productName, originalPrice, price,thumbUrl);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}




