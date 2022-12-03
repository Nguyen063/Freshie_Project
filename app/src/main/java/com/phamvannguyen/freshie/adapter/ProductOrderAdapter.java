package com.phamvannguyen.freshie.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.models.ProductOrder;

import java.util.List;

public class ProductOrderAdapter extends BaseAdapter {

    Activity activity;
    int item_layout;
    List<ProductOrder> notRatingList;

    public ProductOrderAdapter(Activity activity, int item_layout, List<ProductOrder> notRatingList) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.notRatingList = notRatingList;
    }

    @Override
    public int getCount() {
        return notRatingList.size();
    }

    @Override
    public Object getItem(int i) {
        return notRatingList.get(i);
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
            view = inflater.inflate(this.item_layout,null);

            holder.txtName = view.findViewById(R.id.txt_ProductName);
            holder.txtPrice = view.findViewById(R.id.txt_Price);
            holder.txtNum = view.findViewById(R.id.txt_NumProduct);
            holder.imgProduct = view.findViewById(R.id.img_Product);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        ProductOrder notRating = notRatingList.get(i);
        holder.txtName.setText(notRating.getProductName());
        holder.txtPrice.setText(notRating.getProductPrice() + "đ");
        holder.txtNum.setText("x" + notRating.getProductNum());
        holder.imgProduct.setImageResource(notRating.getProductThumb());

        return view;
    }

    public static class ViewHolder{
        TextView txtName, txtPrice, txtNum;
        ImageView imgProduct;
    }
}
