package com.phamvannguyen.freshie.categories;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.adapter.OldRatingAdapter;
import com.phamvannguyen.freshie.models.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends Fragment {
    private View view;
    private GridView gridView;
    List<Product> products = new ArrayList<Product>();


    public CategoryFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_category,
                container, false);
        gridView = (GridView) rootView.findViewById(R.id.gv_ListProduct);
        view = inflater.inflate(R.layout.fragment_category, container, false);

        products.add(new Product(1, "Sửa rửa mặt", "Sửa rửa mặt", "senka", 1000,800,
                41,4.2,100));
        products.add(new Product(1, "Sửa rửa mặt", "Sửa rửa mặt", "senka", 1000,800,
                41,4.2,100));
        products.add(new Product(1, "Sửa rửa mặt", "Sửa rửa mặt", "senka", 1000,800,
                41,4.2,100));
        products.add(new Product(1, "Sửa rửa mặt", "Sửa rửa mặt", "senka", 1000,800,
                41,4.2,100));
        ArrayAdapter<Product> adapter ;
        adapter = new CategoryAdapter();
        gridView.setAdapter(adapter);

        return view;


    }
    public class CategoryAdapter extends ArrayAdapter<Product> {


        public CategoryAdapter() {
            super(getActivity(), R.layout.item_category, products);
        }
        @Override
        public View getView(int position, View view, ViewGroup parent) {
            ViewHolder holder;
            if (view == null){
                holder = new ViewHolder();
                LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
            holder.imgProduct.setImageResource(R.drawable.logo);

            return view;
        }
        private class ViewHolder {
            TextView txtName, txtPrice, txtDiscount, txtRatingAverage, txtRatingCount,txtSold;
            ImageView imgProduct;
        }
    }

}