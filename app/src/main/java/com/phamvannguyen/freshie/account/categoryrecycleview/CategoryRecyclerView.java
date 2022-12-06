package com.phamvannguyen.freshie.account.categoryrecycleview;

import com.phamvannguyen.freshie.account.itemrecycleview.ItemRecycler;

import java.util.List;

public class CategoryRecyclerView {
    private String categoryName;
    private List<ItemRecycler> itemRecyclerList;

    public CategoryRecyclerView(String categoryName, List<ItemRecycler> itemRecyclerList) {
        this.categoryName = categoryName;
        this.itemRecyclerList = itemRecyclerList;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<ItemRecycler> getItemRecyclerList() {
        return itemRecyclerList;
    }

    public void setItemRecyclerList(List<ItemRecycler> itemRecyclerList) {
        this.itemRecyclerList = itemRecyclerList;
    }
}
