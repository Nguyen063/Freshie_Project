package com.phamvannguyen.freshie.product.categoryproduct;

import com.phamvannguyen.freshie.product.itemproduct.ItemProduct;

import java.util.List;

public class CategoryProduct {
    private String categoryProductName;
    private List<ItemProduct> itemProductList;

    public CategoryProduct(String categoryProductName, List<ItemProduct> itemProductList) {
        this.categoryProductName = categoryProductName;
        this.itemProductList = itemProductList;
    }

    public String getCategoryProductName() {
        return categoryProductName;
    }

    public void setCategoryProductName(String categoryProductName) {
        this.categoryProductName = categoryProductName;
    }

    public List<ItemProduct> getItemProductList() {
        return itemProductList;
    }

    public void setItemProductList(List<ItemProduct> itemProductList) {
        this.itemProductList = itemProductList;
    }
}
