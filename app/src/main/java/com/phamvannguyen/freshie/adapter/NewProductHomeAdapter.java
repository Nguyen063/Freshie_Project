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

public class NewProductHomeAdapter extends BaseAdapter {

    Activity activity;
    int itemLayout;
    List<Product> newproduct;

    public NewProductHomeAdapter(Activity activity, int itemLayout, List<Product> newproduct) {
        this.activity = activity;
        this.itemLayout = itemLayout;
        this.newproduct = newproduct;
    }

    @Override
    public int getCount() {
        return newproduct.size();
    }

    @Override
    public Object getItem(int i) {
        return newproduct.get(i);
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

            holder.imgNewProduct = view.findViewById(R.id.img_ProductThumb);
            holder.txtNameNewProduct = view.findViewById(R.id.txt_ProductName);

            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }

        Product product = newproduct.get(i);
        holder.txtNameNewProduct.setText(product.getProductName());
        new MainActivity.FetchImage(product.getThumbUrl(), holder.imgNewProduct).start();

        return view;
    }

    public static class ViewHolder{
        ImageView imgNewProduct;
        TextView txtNameNewProduct;
    }

}
