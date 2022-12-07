package com.phamvannguyen.freshie.categories;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.phamvannguyen.freshie.MainActivity;
import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.models.OldRating;
import com.phamvannguyen.freshie.models.Product;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends BaseAdapter {
    Activity activity;
    int layout;
    List<Product> products;
    byte[] decodedString;
    Bitmap decodedByte;


    public CategoryAdapter() {
    }
    public CategoryAdapter(FragmentActivity activity, int layout, List<Product> products) {
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
            holder.imgProduct = view.findViewById(R.id.imv_Thumb);

            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }


        Product p = products.get(position);
        holder.txtName.setText(p.getProductName());
        holder.txtPrice.setText(String.valueOf(p.getFormattedPrice()));
        holder.txtDiscount.setText(String.valueOf(p.getFormattedDiscount()));
        holder.txtRatingAverage.setText(String.valueOf(p.getRatingAverage()));
        holder.txtRatingCount.setText( "(" + p.getRatingCount() +")");
        holder.txtSold.setText("Đã bán "+ p.getSold());

//        holder.imgProduct.setImageBitmap(p.getThumb());
        new MainActivity.FetchImage( p.getThumbUrl(), holder.imgProduct).start();

        return view;
    }
    private class ViewHolder {
        TextView txtName, txtPrice, txtDiscount, txtRatingAverage, txtRatingCount,txtSold;
        ImageView imgProduct;
    }
}