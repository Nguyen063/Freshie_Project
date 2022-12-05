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

import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.models.Product;
import com.phamvannguyen.freshie.models.ProductOrder;

import java.util.List;

public class ProductOrderAdapter extends BaseAdapter {

    Activity activity;
    int item_layout;
    List<Product> ProductList;

    public ProductOrderAdapter(Activity activity, int item_layout, List<Product> ProductList) {
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
            holder.txtName = view.findViewById(R.id.txt_categories_home);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        if (ProductList.size() == 0) {

            Product notRating = ProductList.get(i);
            holder.txtName.setText(notRating.getProductName());
            holder.txtPrice.setText(notRating.getFormattedPrice());
            holder.txtNum.setText("1");
            holder.txtName.setText(notRating.getProductName());
            try {
                holder.imgProduct.setImageBitmap(BitmapFactory.decodeByteArray(notRating.getImage(), 0,
                        notRating.getImage().length));
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
        else {
//            holder.txtName.setText("Không có sản phẩm nào");
            Toast.makeText(activity, "Không có sản phẩm nào", Toast.LENGTH_SHORT).show();
        }

        return view;
    }

    private class ViewHolder {
        TextView txtName, txtPrice, txtNum, txtBrand;
        ImageView imgProduct;
    }
}