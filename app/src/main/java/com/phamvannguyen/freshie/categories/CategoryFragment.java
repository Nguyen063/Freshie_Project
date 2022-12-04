package com.phamvannguyen.freshie.categories;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.models.Product;

import java.util.ArrayList;


public class CategoryFragment extends Fragment {


    private View view;
    private GridView gridView;
    static ArrayList<Product> products;

    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        products = new ArrayList<Product>();
        view = inflater.inflate(R.layout.fragment_category, container, false);

        gridView = (GridView) view.findViewById(R.id.gv_ListProduct);

        products.add(new Product(1, "Sửa rửa mặt", "Sửa rửa mặt", "senka", 1000,800,
                41,4.2,100));
        products.add(new Product(1, "Sửa rửa mặt", "Sửa rửa mặt", "senka", 1000,800,
                41,4.2,100));
        products.add(new Product(1, "Sửa rửa mặt", "Sửa rửa mặt", "senka", 1000,800,
                41,4.2,100));
        products.add(new Product(1, "Sửa rửa mặt", "Sửa rửa mặt", "senka", 1000,800,
                41,4.2,100));
        CategoryAdapter adapter = new CategoryAdapter(getActivity(), R.layout.item_category, products);
        gridView.setAdapter(adapter);

        return view;



    }
}