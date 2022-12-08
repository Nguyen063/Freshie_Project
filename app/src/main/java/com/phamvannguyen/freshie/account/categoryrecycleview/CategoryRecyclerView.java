package com.phamvannguyen.freshie.account.categoryrecycleview;

import com.phamvannguyen.freshie.account.itemrecycleview.ItemRecycler;

import java.util.List;

public class CategoryRecyclerView {
    private List<ItemRecycler> itemRecyclerList;

    public CategoryRecyclerView(List<ItemRecycler> itemRecyclerList) {
        this.itemRecyclerList = itemRecyclerList;
    }
    public List<ItemRecycler> getItemRecyclerList() {
        return itemRecyclerList;
    }

    public void setItemRecyclerList(List<ItemRecycler> itemRecyclerList) {
        this.itemRecyclerList = itemRecyclerList;
    }
}
