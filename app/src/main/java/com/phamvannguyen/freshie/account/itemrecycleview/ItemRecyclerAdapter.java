package com.phamvannguyen.freshie.account.itemrecycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.phamvannguyen.freshie.R;

import java.util.List;

public class ItemRecyclerAdapter extends RecyclerView.Adapter<ItemRecyclerAdapter.VoucherBrandViewHolder> {
    private List<ItemRecycler> itemRecycler;

    public void setData(List<ItemRecycler> list) {
        this.itemRecycler = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VoucherBrandViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_voucher_brand, parent, false);
        return new VoucherBrandViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VoucherBrandViewHolder holder, int position) {
        ItemRecycler voucherBrand = itemRecycler.get(position);
        if (voucherBrand == null) {
            return;
        }
        holder.imvVoucherBrand.setImageResource(voucherBrand.getResourceId());
        holder.txtVoucherValue.setText(voucherBrand.getVoucherValue());

    }

    @Override
    public int getItemCount() {
        if (itemRecycler != null) {
            return itemRecycler.size();
        }
        return 0;
    }

    public class VoucherBrandViewHolder extends RecyclerView.ViewHolder {
        private ImageView imvVoucherBrand;
        private TextView txtVoucherValue, txtVoucherValid;


        public VoucherBrandViewHolder(@NonNull View itemView) {
            super(itemView);
            imvVoucherBrand = itemView.findViewById(R.id.imv_voucherBrand);
            txtVoucherValue = itemView.findViewById(R.id.txt_voucherValue);
        }
    }

}
