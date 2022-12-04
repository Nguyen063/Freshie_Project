package com.phamvannguyen.freshie.cart;

public class CartModel {
    int cartProduct;
    String cartproductName;
    double cartproductPrice;
    int quantity;

    public CartModel(int cartProduct, String cartproductName, double cartproductPrice, int quantity) {
        this.cartProduct = cartProduct;
        this.cartproductName = cartproductName;
        this.cartproductPrice = cartproductPrice;
        this.quantity = quantity;
    }

    public int getCartProduct() {
        return cartProduct;
    }

    public void setCartProduct(int cartProduct) {
        this.cartProduct = cartProduct;
    }

    public String getCartproductName() {
        return cartproductName;
    }

    public void setCartproductName(String cartproductName) {
        this.cartproductName = cartproductName;
    }

    public double getCartproductPrice() {
        return cartproductPrice;
    }

    public void setCartproductPrice(Double cartproductPrice) {
        this.cartproductPrice = cartproductPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getFormattedPrice() {
        return  String.format("%,.0f đ", cartproductPrice );

    }


}




