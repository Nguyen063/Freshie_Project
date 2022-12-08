package com.phamvannguyen.freshie.product.categoryproduct;

import com.phamvannguyen.freshie.product.itemproduct.ItemProduct;

import java.util.List;

public class CategoryProduct {
    private List<ItemProduct> itemProductList;


    public CategoryProduct(List<ItemProduct> itemProductList) {
        this.itemProductList = itemProductList;
    }

    public List<ItemProduct> getItemProductList() {
        return itemProductList;
    }

    public void setItemProductList(List<ItemProduct> itemProductList) {
        this.itemProductList = itemProductList;
    }
}
