package com.phamvannguyen.freshie.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.home.HomeFragment;
import com.phamvannguyen.freshie.models.FlashSales;
import com.phamvannguyen.freshie.models.HomeGridView;

import java.util.ArrayList;
import java.util.List;

public class HomeGridviewAdapter extends BaseAdapter {

    //Activity activity;
    HomeFragment fragment;
    int item_layout;
    List<HomeGridView> homeGridViews;

    public HomeGridviewAdapter(HomeFragment fragment, int item_layout, List<HomeGridView> homeGridViews) {
        this.fragment = fragment;
        this.item_layout = item_layout;
        this.homeGridViews = homeGridViews;
    }

    @Override
    public int getCount() {
        return homeGridViews.size();
    }

    @Override
    public Object getItem(int i) {
        return homeGridViews.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(fragment.getContext());
            view = inflater.inflate(item_layout, null);
            holder = new HomeGridviewAdapter.ViewHolder();
            holder.img_productHome = view.findViewById(R.id.img_productHome);
            holder.txt_ProductNameHome = view.findViewById(R.id.txt_ProductNameHome);
            holder.txt_ProductPrice = view.findViewById(R.id.txt_ProductPrice);
            holder.txt_Discount = view.findViewById(R.id.txt_Discount);
            holder.txt_RatingAverage = view.findViewById(R.id.txt_RatingAverage);
            holder.txt_RatingCount = view.findViewById(R.id.txt_RatingCount);
            holder.txt_Sold = view.findViewById(R.id.txt_Sold);
            view.setTag(holder);
        } else {
            holder = (HomeGridviewAdapter.ViewHolder) view.getTag();
        }
//
//
        HomeGridView grv = homeGridViews.get(i);
        holder.img_productHome.setImageResource(grv.getProductImg());
        holder.txt_ProductNameHome.setText(grv.getProductNameHome());
        holder.txt_ProductPrice.setText(toString().valueOf(grv.getProductPriceHome()));
        holder.txt_Discount.setText("-" + grv.getProductDiscountHome() + "%");
        holder.txt_RatingAverage.setText(toString().valueOf(grv.getRatingValueHome()));
        holder.txt_RatingCount.setText("(" + grv.getRatingCountHome() + ")");
        holder.txt_Sold.setText(grv.getSoldCountHome() + " đã bán");

        return view;
    }

    public static class ViewHolder {

        ImageView img_productHome;
        TextView txt_ProductNameHome, txt_ProductPrice, txt_Discount, txt_RatingAverage, txt_RatingCount, txt_Sold;
    }
}





