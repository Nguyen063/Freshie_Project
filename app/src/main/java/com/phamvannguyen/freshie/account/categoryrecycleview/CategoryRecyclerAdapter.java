package com.phamvannguyen.freshie.account.categoryrecycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.account.itemrecycleview.ItemRecyclerAdapter;

import java.util.List;

public class CategoryRecyclerAdapter extends RecyclerView.Adapter<CategoryRecyclerAdapter.CategoryRecyclerViewHolder> {
    private Context mContext;
    private List<CategoryRecyclerView> mCategoryRecyclerViewList;

    public CategoryRecyclerAdapter(Context mContext) {
        this.mContext = mContext;
    }
    public void setData(List<CategoryRecyclerView> list){
        this.mCategoryRecyclerViewList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category_recycleview,parent,false);
        return new CategoryRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryRecyclerViewHolder holder, int position) {
        CategoryRecyclerView categoryRecyclerView = mCategoryRecyclerViewList.get(position);
        if (categoryRecyclerView == null) {
            return;
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext,RecyclerView.HORIZONTAL,false);
        holder.rcvItemReCycle.setLayoutManager(linearLayoutManager);

        ItemRecyclerAdapter itemRecyclerAdapter = new ItemRecyclerAdapter();
        itemRecyclerAdapter.setData(categoryRecyclerView.getItemRecyclerList());
        holder.rcvItemReCycle.setAdapter((itemRecyclerAdapter));

    }

    @Override
    public int getItemCount() {
        if (mCategoryRecyclerViewList != null){
            return mCategoryRecyclerViewList.size();
        }
        return 0;
    }

    public class CategoryRecyclerViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView rcvItemReCycle;

        public CategoryRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            rcvItemReCycle = itemView.findViewById(R.id.rcv_itemRecycler);

        }
    }
}
