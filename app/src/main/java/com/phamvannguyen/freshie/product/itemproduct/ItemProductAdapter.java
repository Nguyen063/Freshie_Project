package com.phamvannguyen.freshie.product.itemproduct;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.phamvannguyen.freshie.R;

import java.util.List;

public class ItemProductAdapter extends RecyclerView.Adapter<ItemProductAdapter.ItemsViewHolder> {
    private List<ItemProduct> itemProduct;
    public void setData(List<ItemProduct> list) {
        this.itemProduct = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemProductAdapter.ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_viewproduct_details, parent, false);
        return new ItemsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemProductAdapter.ItemsViewHolder holder, int position) {
        ItemProduct productItemDetails = itemProduct.get(position);
        if (productItemDetails == null) {
            return;
        }
        holder.imvProductItemDetails.setImageResource(productItemDetails.getImageProductID());
        holder.txtProductNameDetails.setText(productItemDetails.getNameProduct());

    }

    @Override
    public int getItemCount() {
        if (itemProduct != null){
            return itemProduct.size();
        }
        return 0;
    }

public class ItemsViewHolder extends RecyclerView.ViewHolder {
    private ImageView imvProductItemDetails;
    private TextView txtProductNameDetails;

    public ItemsViewHolder(@NonNull View itemView) {
        super(itemView);
        imvProductItemDetails = itemView.findViewById(R.id.imv_productItemDetails);
        txtProductNameDetails = itemView.findViewById(R.id.txt_productNameDetails);

    }
}
}

