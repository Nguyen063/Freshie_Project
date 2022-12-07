package com.phamvannguyen.freshie.categories;

import static com.phamvannguyen.freshie.MainActivity.sendToProductDetail;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.phamvannguyen.freshie.DataBaseHelper;
import com.phamvannguyen.freshie.MainActivity;
import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.databinding.FragmentCategoryBinding;
import com.phamvannguyen.freshie.models.Product;
import com.phamvannguyen.freshie.product.ProductDetailActivity;

import java.util.ArrayList;


public class CategoryFragment extends Fragment {


   private View view;
//    private GridView gridView;
//    static ArrayList<Product> products;
//
//    public static final String INTENT_NAME = "CategoryFragment";
//    public static final String INTENT_DEALS = "Deals";
    FragmentCategoryBinding binding;
//    private DataBaseHelper db = MainActivity.db;
////    public CategoryFragment() {
////        // Required empty public constructor
////    }
//
    public CategoryFragment() {
        // Required empty public constructor
    }
//
//
////    public static CategoryFragment newInstance(String filter) {
////        Bundle args = new Bundle();
////        args.putString(INTENT_NAME, filter);
////        CategoryFragment fragment = new CategoryFragment();
////        fragment.setArguments(args);
////        return fragment;
////    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        view = inflater.inflate(R.layout.fragment_category, container, false);

        binding = FragmentCategoryBinding.inflate(inflater, container, false);
        view = binding.getRoot();


        return view;


    }

//    private String loadBundle() {
//        Bundle bundle = this.getArguments();
//        if (bundle != null) {
//          return  bundle.getString(INTENT_NAME);
//        }
//        else return null;
//    }
//
//    private void addEvents() {
//        binding.btnHairCare.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                loadListview("Hair");
//            }
//        });
//        binding.btnMakeup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                loadListview("Makeup");
//            }
//        });
//        binding.btnSkincare.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                loadListview("Skincare");
//            }
//
//        });
//        binding.btnPerfume.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                loadListview("Perfume");
//            }
//        });
////        binding.btnCart.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                Intent intent = new Intent(getActivity(), CartActivity.class);
////                startActivity(intent);
////            }
////        });
//        binding.gvListProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                sendToProductDetail(products.get(i), getActivity());
//            }
//        });
//    }
//
//    private void loadListview(String category) {
//
//
//        products = MainActivity.getListWhere(DataBaseHelper.COL_CATEGORY + " = '" + category + "'");
//
//        CategoryAdapter adapter = new CategoryAdapter(getActivity(), R.layout.item_category, products);
//        gridView.setAdapter(adapter);
//    }
//
//    private void setInitialColor(Button btn) {
////        binding.btnHairCare.setBackgroundColor();
//
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//    }
//    public void displayReceivedData(String message)
//    {
//
//        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
//    };
}