package com.phamvannguyen.freshie.home;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.phamvannguyen.freshie.DataBaseHelper;
import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.adapter.FlashSaleAdapter;
import com.phamvannguyen.freshie.adapter.HomeGridviewAdapter;
import com.phamvannguyen.freshie.adapter.ProductOrderAdapter;
import com.phamvannguyen.freshie.categories.CategoryFragment;
import com.phamvannguyen.freshie.databinding.FragmentHomeBinding;
import com.phamvannguyen.freshie.models.FlashSales;
import com.phamvannguyen.freshie.models.HomeGridView;
import com.phamvannguyen.freshie.models.Product;
import com.phamvannguyen.freshie.models.ProductOrder;
import com.phamvannguyen.freshie.product.ProductDetailActivity;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {


    FragmentHomeBinding binding;
    DataBaseHelper db;
    HomeGridviewAdapter adapterHome;
    HomeGridView putExtra;
    ArrayList<HomeGridView> homeGridViewArrayList;
    View view;
    int [] images = {
            R.drawable.banner1,
            R.drawable.banner2
    };

    public HomeFragment(){

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        SliderView sliderView = (SliderView) view.findViewById(R.id.slide_view);
        SliderAdapter sliderAdapter = new SliderAdapter(images);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();

        createDB();
        loadData();
//        addEvents();
        return view;


    }

    private void loadData() {
        homeGridViewArrayList = new ArrayList<>();
        Cursor c = db.getData("SELECT * FROM " + DataBaseHelper.TBL_PRODUCT);
        while (c.moveToNext()) {
            homeGridViewArrayList.add(new HomeGridView(c.getInt(2), c.getString(1),
                    c.getDouble(3), c.getDouble(9), c.getDouble(6),
                    c.getDouble(5), c.getDouble(10)));
        }
        c.close();
        adapterHome = new HomeGridviewAdapter(this, R.layout.item_gridview_home, homeGridViewArrayList);
        binding.gridviewCategories.setAdapter(adapterHome);
    }

   private void addEvents() {
       binding.gridviewCategories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
               putExtra = homeGridViewArrayList.get(i);
               //Attach data
               intent.putExtra("image", putExtra.getProductImg());
               intent.putExtra("name", putExtra.getProductNameHome());
               intent.putExtra("price", putExtra.getProductPriceHome());
               startActivity(intent);
           }
       });


    }


       private void createDB () {
           db = new DataBaseHelper(getActivity());
           db.createData();
       }


   }
