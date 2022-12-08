package com.phamvannguyen.freshie.cache;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.phamvannguyen.freshie.MainActivity;
import com.phamvannguyen.freshie.cart.CartModel;

import java.util.ArrayList;

public class cacheCart {
    public static ArrayList<CartModel> cartList = new ArrayList<>();
    public static void initCartListData() {
//        Product p;
//        for (int i = 1; i < 5; i++) {
//            p =  MainActivity.getProductWithId(i);
//            cartList.add( new CartModel(p.getProductID(), p.getProductName(), p.getOriginalPrice(), p.getPrice(),p.getThumbUrl(),1));
//        }

        SQLiteDatabase db = MainActivity.db.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT ProductID, ProductName, OriginalPrice, Price, Thumb FROM product WHERE ProductID in (1,2,3,4,5)", null);
        while (c.moveToNext()) {
            int productID = c.getInt(0);
            String productName = c.getString(1);
            double originalPrice = c.getDouble(2);
            double price = c.getDouble(3);
            String thumbUrl = c.getString(4);
            cartList.add(new CartModel(productID, productName, originalPrice, price, thumbUrl, 1));
        }
    }

    public static double total = 0;
    public static void initTotalData() {
        total = 0;
        for (int i = 0; i < cartList.size(); i++) {
            total += cartList.get(i).getQuantity() * cartList.get(i).getPrice();
        }
    }

    public static void addCart(CartModel cartModel){
        cartList.add(cartModel);
    }

    public static void removeCart(CartModel cartModel){
        cartList.remove(cartModel);
    }

    public static void updateCart(CartModel cartModel){
        for (int i = 0; i < cartList.size(); i++) {
            if(cartList.get(i).getProductID() == cartModel.getProductID()){
                cartList.get(i).setQuantity(cartModel.getQuantity());
            }
        }
    }

    public static void updateTotalValue() {
        for (int i = 0; i < cartList.size(); i++) {
            total += cartList.get(i).getQuantity() * cartList.get(i).getPrice();
        }
    }
}
