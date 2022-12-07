package com.phamvannguyen.freshie.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.phamvannguyen.freshie.MainActivity;
import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.models.Product;

import java.util.List;

public class BestSellerHomeAdapter extends BaseAdapter {

    Activity activity;
    int itemLayout;
    List<Product> bestSellerList;

    public BestSellerHomeAdapter(Activity activity, int itemLayout, List<Product> bestSellerList) {
        this.activity = activity;
        this.itemLayout = itemLayout;
        this.bestSellerList = bestSellerList;
    }

    @Override
    public int getCount() {
        return bestSellerList.size();
    }

    @Override
    public Object getItem(int i) {
        return bestSellerList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;
        if (view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(itemLayout, null);

            holder.imgProductThumb = view.findViewById(R.id.img_ProductThumb);
            holder.txtProductName = view.findViewById(R.id.txt_ProductName);
            holder.txtSoldCount = view.findViewById(R.id.txt_soldCount);

            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }

        Product product = bestSellerList.get(i);
        holder.txtProductName.setText(product.getProductName());
        holder.txtSoldCount.setText(String.valueOf(product.getSold())+" đã bán");
        new MainActivity.FetchImage(product.getThumbUrl(), holder.imgProductThumb).start();

        return view;
    }

    public static class ViewHolder{
        ImageView imgProductThumb;
        TextView txtProductName, txtSoldCount;
    }
}
