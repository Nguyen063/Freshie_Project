package com.phamvannguyen.freshie.product.categoryproduct;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.product.itemproduct.ItemProductAdapter;

import org.w3c.dom.Text;

import java.util.List;

public class CategoryProductAdapter extends RecyclerView.Adapter<CategoryProductAdapter.CategoryProductViewHolder> {
    private Context mContext;
    private List<CategoryProduct> mCategoryProductList;

    public CategoryProductAdapter(Context mContext) {
        this.mContext = mContext;
    }
    public void setData(List<CategoryProduct> list){
        this.mCategoryProductList = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public CategoryProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category_product,parent,false);
        return new CategoryProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryProductViewHolder holder, int position) {
        CategoryProduct categoryProduct = mCategoryProductList.get(position);
        if (categoryProduct == null) {
            return;
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext,RecyclerView.HORIZONTAL,false);
        holder.rcvItemProducts.setLayoutManager(linearLayoutManager);

        ItemProductAdapter itemProductAdapter = new ItemProductAdapter();
        itemProductAdapter.setData(categoryProduct.getItemProductList());
        holder.rcvItemProducts.setAdapter((itemProductAdapter));


    }

    @Override
    public int getItemCount() {
        if (mCategoryProductList != null){
            return mCategoryProductList.size();
        }
        return 0;
    }

    public class CategoryProductViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView rcvItemProducts;

        public CategoryProductViewHolder(@NonNull View itemView) {
            super(itemView);
            rcvItemProducts = itemView.findViewById(R.id.rcv_itemProduct);
        }
    }
}

