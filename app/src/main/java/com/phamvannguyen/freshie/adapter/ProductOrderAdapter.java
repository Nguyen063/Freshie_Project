package com.phamvannguyen.freshie.adapter;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.phamvannguyen.freshie.MainActivity;
import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.cart.CartModel;
import com.phamvannguyen.freshie.models.Product;
import com.phamvannguyen.freshie.models.ProductOrder;

import java.util.List;

public class ProductOrderAdapter extends BaseAdapter {

    Activity activity;
    int item_layout;
    List<CartModel> ProductList;

    public ProductOrderAdapter(Activity activity, int item_layout, List<CartModel> ProductList) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.ProductList = ProductList;
    }

    @Override
    public int getCount() {
        return ProductList.size();
    }

    @Override
    public Object getItem(int i) {
        return ProductList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(this.item_layout, null);

            holder.txtName = view.findViewById(R.id.txt_ProductName);
            holder.txtPrice = view.findViewById(R.id.txt_Price);
            holder.txtNum = view.findViewById(R.id.txt_NumProduct);
            holder.imgProduct = view.findViewById(R.id.img_Product);
//            holder.txtName = view.findViewById(R.id.txt_categories_home);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }


            CartModel notRating = ProductList.get(i);
            holder.txtName.setText(notRating.getProductName());
            holder.txtPrice.setText(String.format("%,.0f ₫", notRating.getPrice()));
            holder.txtNum.setText(String.valueOf(notRating.getQuantity()));
            new MainActivity.FetchImage(notRating.getThumbUrl(), holder.imgProduct).start();


        return view;
    }

    private class ViewHolder {
        TextView txtName, txtPrice, txtNum, txtBrand;
        ImageView imgProduct;
    }
}