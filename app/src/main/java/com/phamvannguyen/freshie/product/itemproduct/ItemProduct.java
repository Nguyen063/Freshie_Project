package com.phamvannguyen.freshie.product.itemproduct;

public class ItemProduct {
    private int imageProductID;
    private String nameProduct;

    public ItemProduct(int imageProductID, String nameProduct) {
        this.imageProductID = imageProductID;
        this.nameProduct = nameProduct;
    }

    public int getImageProductID() {
        return imageProductID;
    }

    public void setImageProductID(int imageProductID) {
        this.imageProductID = imageProductID;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }
}
