package com.phamvannguyen.freshie.adapter;

import static java.lang.String.valueOf;

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

public class FlashSaleHomeAdapter extends BaseAdapter {

    Activity activity;
    int itemLayout;
    List<Product> flashSaleList;

    public FlashSaleHomeAdapter(Activity activity, int itemLayout, List<Product> flashSaleList) {
        this.activity = activity;
        this.itemLayout = itemLayout;
        this.flashSaleList = flashSaleList;
    }

    @Override
    public int getCount() {
        return flashSaleList.size();
    }

    @Override
    public Object getItem(int i) {
        return flashSaleList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(this.itemLayout,null);
            holder.imgProductThumb = view.findViewById(R.id.img_ProductThumb);
            holder.txtProductPrice = view.findViewById(R.id.txt_ProductPrice);

            view.setTag(holder);
        }
        else{
            holder = (ViewHolder) view.getTag();
        }

        Product product = flashSaleList.get(i);
        holder.txtProductPrice.setText(product.getFormattedPrice());
        new MainActivity.FetchImage( product.getThumbUrl(), holder.imgProductThumb).start();

        return view;
    }

    public static class ViewHolder {
        ImageView imgProductThumb;
        TextView txtProductPrice;
    }

}
