package com.phamvannguyen.freshie.watched;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.phamvannguyen.freshie.MainActivity;
import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.categories.CategoryAdapter;
import com.phamvannguyen.freshie.models.Product;

import java.util.List;

public class WatchedAdapter extends BaseAdapter {

    Activity activity;
    List<Product> products;
    int item_layout;

    public WatchedAdapter(Activity activity, List<Product> products, int item_layout) {
        this.activity = activity;
        this.products = products;
        this.item_layout = item_layout;
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
    public View getView(int i, View view, ViewGroup viewGroup) {
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
            holder.imgProduct = view.findViewById(R.id.imv_Thumb);

            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }


        Product p = products.get(i);
        holder.txtName.setText(p.getProductName());
        holder.txtPrice.setText(String.valueOf(p.getFormattedPrice()));
        holder.txtDiscount.setText(String.valueOf(p.getFormattedDiscount()));
        holder.txtRatingAverage.setText(String.valueOf(p.getRatingAverage()));
        holder.txtRatingCount.setText( String.valueOf(p.getRatingCount()));
        holder.txtSold.setText(String.valueOf(p.getSold()));

//        holder.imgProduct.setImageBitmap(p.getThumb());
        new MainActivity.FetchImage( p.getThumbUrl(), holder.imgProduct).start();

        return view;
    }

    private class ViewHolder {
        TextView txtName, txtPrice, txtDiscount, txtRatingAverage, txtRatingCount,txtSold;
        ImageView imgProduct;
    }
}
