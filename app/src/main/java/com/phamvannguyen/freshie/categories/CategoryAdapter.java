package com.phamvannguyen.freshie.categories;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.models.OldRating;
import com.phamvannguyen.freshie.models.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends BaseAdapter {
    Activity activity;
    int layout;
    List<Product> products;

    public CategoryAdapter() {
    }
    public CategoryAdapter(FragmentActivity activity, int layout, ArrayList<Product> products) {
        this.activity = activity;
        this.layout = layout;
        this.products = products;
    }



    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int i) {
        return products.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_category, null);

            holder.txtName = view.findViewById(R.id.txt_ProductName);
            holder.txtPrice = view.findViewById(R.id.txt_Price);
            holder.txtDiscount = view.findViewById(R.id.txt_Discount);
            holder.txtRatingAverage = view.findViewById(R.id.txt_RatingAverage);
            holder.txtRatingCount = view.findViewById(R.id.txt_RatingCount);
            holder.txtSold = view.findViewById(R.id.txt_Sold);

            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }


        Product p = products.get(position);
        holder.txtName.setText(p.getProductName());
        holder.txtPrice.setText(p.getPrice() + "");
        holder.txtDiscount.setText(p.getDiscount() + "");
        holder.txtRatingAverage.setText(p.getRatingAverage() + "");
        holder.txtRatingCount.setText(p.getRatingCount() + "");
        holder.txtSold.setText(p.getSold() + "");
//        holder.imgProduct.setImageResource(R.drawable.logo);

        return view;
    }
    private class ViewHolder {
        TextView txtName, txtPrice, txtDiscount, txtRatingAverage, txtRatingCount,txtSold;
        ImageView imgProduct;
    }
}
