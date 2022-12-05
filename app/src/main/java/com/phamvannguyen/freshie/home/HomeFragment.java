package com.phamvannguyen.freshie.home;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

import com.phamvannguyen.freshie.DataBaseHelper;
import com.phamvannguyen.freshie.MainActivity;
import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.adapter.BestSellerHomeAdapter;
import com.phamvannguyen.freshie.adapter.FlashSaleHomeAdapter;
import com.phamvannguyen.freshie.adapter.NewProductHomeAdapter;
import com.phamvannguyen.freshie.adapter.ProductOrderAdapter;
import com.phamvannguyen.freshie.categories.CategoryAdapter;
import com.phamvannguyen.freshie.categories.CategoryFragment;
import com.phamvannguyen.freshie.databinding.FragmentHomeBinding;
import com.phamvannguyen.freshie.models.Product;
import com.phamvannguyen.freshie.models.ProductOrder;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private GridView gridView;

    DataBaseHelper db = MainActivity.db;
    List<Product> flashSale_list, newProduct_list, bestSeller_list, forYou_list;

    FragmentHomeBinding binding;
    private SliderView sliderView;
    int [] images = {
            R.drawable.banner1,
            R.drawable.banner2
    };
    public static final String INTENT_NAME = "HomeFragment";
    public static final String INTENT_DEALS = "Deals";
    public static final String INTENT_FRESH_NOW = "Fresh now";
    public static final String INTENT_HIGH_END = "HIgh end";
    public static final String INTENT_MY_VOUCHER = "My voucher";
    public static final String INTENT_CATEGORY = "Category";
    public static final String INTENT_ORDER = "Order";
    public static final String INTENT_POINT = "Point";
    public static final String INTENT_FREE_SHIP = "Free ship";
    public static final String INTENT_NEW = "New";
    public static final String INTENT_BEST_SELLER = "Best seller";


    Intent intent;
    public HomeFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

//        View view = inflater.inflate(R.layout.fragment_home, container, false);
        SliderView sliderView = (SliderView) view.findViewById(R.id.slide_view);
        SliderAdapter sliderAdapter = new SliderAdapter(images);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();

//        gridView = (GridView) view.findViewById(R.id.gridview_categories);


        loadData();
        listenEvents();

        return view;
    }

    private void loadData() {

        //flash sale gridView
        flashSale_list = new ArrayList<>();
        flashSale_list = getListItem(DataBaseHelper.COL_IS_DEAL,"= 1");
        FlashSaleHomeAdapter flashSaleHomeAdapter = new FlashSaleHomeAdapter(getActivity(), R.layout.item_flashsale_home, flashSale_list);
        binding.gridFlashSale.setAdapter(flashSaleHomeAdapter);

        //---new arrivals gridView
        newProduct_list = new ArrayList<>();
        newProduct_list = getListItem(DataBaseHelper.COL_IS_NEW,"= 1");
        NewProductHomeAdapter newProductAdapter = new NewProductHomeAdapter(getActivity(), R.layout.item_newproduct_home, newProduct_list);
        binding.gridNewProduct.setAdapter(newProductAdapter);

        //---best seller gridView
        bestSeller_list = new ArrayList<>();
        bestSeller_list = getListItem(DataBaseHelper.COL_IS_BEST_SELLER,"= 1");
        BestSellerHomeAdapter bestSellerAdapter = new BestSellerHomeAdapter(getActivity(), R.layout.item_bestseller_home, bestSeller_list);
        binding.gridBestseller.setAdapter(bestSellerAdapter);

        //---For you gridView
        forYou_list = new ArrayList<>();
        forYou_list = getListItem(DataBaseHelper.COL_IS_BEST_SELLER,"= 1");
        CategoryAdapter forYouAdapter = new CategoryAdapter(getActivity(), R.layout.item_category, forYou_list);
        binding.gridForYou.setAdapter(forYouAdapter);


    }

    private void listenEvents() {


        ///-------Circle items section----------------
        binding.txtDeals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), CategoryFragment.class);
                intent.putExtra(INTENT_NAME, INTENT_DEALS);
                startActivity(intent);
            }
        });

        binding.txtFreshnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), CategoryFragment.class);
                intent.putExtra(INTENT_NAME, INTENT_FRESH_NOW);
                startActivity(intent);
            }
        });
        binding.txtHignend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), CategoryFragment.class);
                intent.putExtra(INTENT_NAME, INTENT_HIGH_END);
                startActivity(intent);
            }
        });
        binding.txtMyvoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), CategoryFragment.class);
                intent.putExtra(INTENT_NAME, INTENT_MY_VOUCHER);
                startActivity(intent);
            }
        });
        binding.txtCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), CategoryFragment.class);
                intent.putExtra(INTENT_NAME, INTENT_CATEGORY);
                startActivity(intent);
            }
        });
        binding.txtOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), CategoryFragment.class);
                intent.putExtra(INTENT_NAME, INTENT_ORDER);
                startActivity(intent);
            }
        });
        binding.txtPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), CategoryFragment.class);
                intent.putExtra(INTENT_NAME, INTENT_POINT);
                startActivity(intent);
            }
        });
        binding.txtFreeship.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), CategoryFragment.class);
                intent.putExtra(INTENT_NAME, INTENT_FREE_SHIP);
                startActivity(intent);
            }
        });

        //-----------------Category section-----------------
        binding.txtViewFlashSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), CategoryFragment.class);
                intent.putExtra(INTENT_NAME, INTENT_DEALS);
                startActivity(intent);
            }
        });
        binding.txtViewBestSeller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), CategoryFragment.class);
                intent.putExtra(INTENT_NAME, INTENT_NEW);
                startActivity(intent);
            }
        });
        binding.txtViewBestSeller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), CategoryFragment.class);
                intent.putExtra(INTENT_NAME,INTENT_BEST_SELLER );
                startActivity(intent);
            }
        });
    }
    public  List<Product> getListItem(String ColName, String Condition){
        List<Product> list = new ArrayList<>();
        Cursor cursor = db.getData("SELECT * FROM " + DataBaseHelper.TBL_PRODUCT + " WHERE " + ColName +  Condition
                + " LIMIT 10");
        while (cursor.moveToNext()){
            list.add(new Product(cursor.getInt(0)));
        }
        return list;
    }


}