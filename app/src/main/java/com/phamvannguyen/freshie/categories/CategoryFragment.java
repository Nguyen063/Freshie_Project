package com.phamvannguyen.freshie.categories;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.phamvannguyen.freshie.DataBaseHelper;
import com.phamvannguyen.freshie.MainActivity;
import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.cart.CartActivity;
import com.phamvannguyen.freshie.databinding.FragmentCategoryBinding;
import com.phamvannguyen.freshie.models.Product;

import java.util.ArrayList;


public class CategoryFragment extends Fragment {


    private View view;
    private GridView gridView;
    static ArrayList<Product> products;

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
//        binding.btnCart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), CartActivity.class);
//                startActivity(intent);
//            }
//        });
    }

    private void loadListview(String category) {


        products = MainActivity.getListWhere(DataBaseHelper.COL_CATEGORY + " = '" + category + "'");

        CategoryAdapter adapter = new CategoryAdapter(getActivity(), R.layout.item_category, products);
        gridView.setAdapter(adapter);
    }

}