package com.phamvannguyen.freshie.categories;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.phamvannguyen.freshie.DataBaseHelper;
import com.phamvannguyen.freshie.MainActivity;
import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.databinding.FragmentCategoryBinding;
import com.phamvannguyen.freshie.models.Product;
import com.phamvannguyen.freshie.product.ProductDetailActivity;

import java.util.ArrayList;


public class CategoryFragment extends Fragment {


    private View view;
    private GridView gridView;
    static ArrayList<Product> products;
    Product selectproduct;
    FragmentCategoryBinding binding;
    private DataBaseHelper db = MainActivity.db;
    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        view = inflater.inflate(R.layout.fragment_category, container, false);

        binding = FragmentCategoryBinding.inflate(inflater, container, false);
        view = binding.getRoot();
        products = new ArrayList<Product>();

        gridView = (GridView) view.findViewById(R.id.gv_ListProduct);

        loadListview("Skincare");
        addEvents();
        return view;

    }

    private void addEvents() {
        binding.btnHairCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadListview("Hair");
            }
        });
        binding.btnMakeup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadListview("Makeup");
            }
        });
        binding.btnSkincare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadListview("Skincare");
            }
        });
        binding.btnPerfume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadListview("Perfume");
            }
        });
        binding.gvListProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
                selectproduct = products.get(i);
                //Attach data
//                intent.putExtra("image", selectproduct.getThumbUrl());
//                intent.putExtra("name", selectproduct.getProductName());
//                intent.putExtra("price", selectproduct.getPrice());

                startActivity(intent);
            }
        });
    }

    private void loadListview(String category) {


        products = MainActivity.getListWhere(DataBaseHelper.COL_CATEGORY + " = '" + category + "'");

        CategoryAdapter adapter = new CategoryAdapter(getActivity(), R.layout.item_category, products);
        gridView.setAdapter(adapter);
    }

}