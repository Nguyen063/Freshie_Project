package com.phamvannguyen.freshie.home;

import static com.phamvannguyen.freshie.MainActivity.viewPager2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.GridView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.phamvannguyen.freshie.DataBaseHelper;
import com.phamvannguyen.freshie.MainActivity;
import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.adapter.BestSellerHomeAdapter;
import com.phamvannguyen.freshie.adapter.FlashSaleHomeAdapter;
import com.phamvannguyen.freshie.adapter.NewProductHomeAdapter;
import com.phamvannguyen.freshie.categories.CategoryAdapter;
import com.phamvannguyen.freshie.categories.CategoryFragment;
import com.phamvannguyen.freshie.databinding.FragmentHomeBinding;
import com.phamvannguyen.freshie.exchangegift.ExchangeGiftActivity;
import com.phamvannguyen.freshie.exchangegift.UserVoucherActivity;
import com.phamvannguyen.freshie.flashsale.FlashSale;
import com.phamvannguyen.freshie.models.Product;
import com.phamvannguyen.freshie.order.order;
import com.phamvannguyen.freshie.product.ListProductActivity;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private GridView gridView;
    private View view;

    SendMessage SM;
    DataBaseHelper db = MainActivity.db;
    List<Product> flashSale_list, newProduct_list, bestSeller_list, forYou_list;

    ViewPager viewPager = MainActivity.viewPager;
    FragmentHomeBinding binding;
    private SliderView sliderView;
    int [] images = {
            R.drawable.banner1,
            R.drawable.banner2,
            R.drawable.banner3,
    };
    public static final String INTENT_NAME = "HomeFragment";
    public static final String INTENT_DEALS = "Deals";
    public static final String INTENT_MY_VOUCHER = "My voucher";
    public static final String INTENT_ORDER = "Order";
    public static final String INTENT_POINT = "Point";
    public static final String INTENT_NEW = "New";
    public static final String INTENT_BEST_SELLER = "Best seller";


    Intent intent;
    public HomeFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        view = binding.getRoot();

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
        countdown();
//        binding.txtViewNewest.performClick();

        return view;
    }

    private void countdown() {
        new CountDownTimer(2239000, 1000){

            @Override
            public void onTick(long l) {
                binding.txtCountDown.setText(l/360000%24 + " : " + l/60000%60 + " : "+ l/1000%60 +"s");
            }
            @Override
            public void onFinish() {

            }

        }.start();
    }

    private void loadData() {

        //flash sale gridView
        flashSale_list = new ArrayList<>();
        flashSale_list = MainActivity.getListWhere( DataBaseHelper.COL_IS_DEAL + " = 1 LIMIT 4");
        FlashSaleHomeAdapter flashSaleHomeAdapter = new FlashSaleHomeAdapter(getActivity(), R.layout.item_flashsale_home, flashSale_list);
        binding.gridFlashSale.setAdapter(flashSaleHomeAdapter);

        //---new arrivals gridView
        newProduct_list = new ArrayList<>();
        newProduct_list = MainActivity.getListWhere( DataBaseHelper.COL_IS_DEAL + " = 1 LIMIT 4");
        NewProductHomeAdapter newProductAdapter = new NewProductHomeAdapter(getActivity(), R.layout.item_newproduct_home, newProduct_list);
        binding.gridNewProduct.setAdapter(newProductAdapter);

        //---best seller gridView
        bestSeller_list = new ArrayList<>();
        bestSeller_list = MainActivity.getListWhere(DataBaseHelper.COL_IS_BEST_SELLER + " = 1 LIMIT 4");
        BestSellerHomeAdapter bestSellerAdapter = new BestSellerHomeAdapter(getActivity(), R.layout.item_bestseller_home, bestSeller_list);
        binding.gridBestseller.setAdapter(bestSellerAdapter);

        //---For you gridView
        forYou_list = new ArrayList<>();
        forYou_list = MainActivity.getListWhere(DataBaseHelper.COL_IS_BEST_SELLER + " = 1");
        CategoryAdapter forYouAdapter = new CategoryAdapter(getActivity(), R.layout.item_category, forYou_list);
        binding.gridForYou.setAdapter(forYouAdapter);


    }

    private void listenEvents() {


        ///-------Circle items section----------------
        binding.txtDeals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), FlashSale.class);
                intent.putExtra(INTENT_NAME, INTENT_DEALS);
                startActivity(intent);
            }
        });
        binding.txtMyvoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), UserVoucherActivity.class);
                intent.putExtra(INTENT_NAME, INTENT_MY_VOUCHER);
                startActivity(intent);
            }
        });

        binding.txtOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), order.class);
                intent.putExtra(INTENT_NAME, INTENT_ORDER);
                startActivity(intent);
            }
        });
        binding.txtPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), ExchangeGiftActivity.class);
                intent.putExtra(INTENT_NAME, INTENT_POINT);
                startActivity(intent);
            }
        });

        //-----------------CategoryProduct section-----------------
        binding.txtViewFlashSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//               SM.sendData("Flash sale");
//               viewPager2.setCurrentItem(2);
                    intent = new Intent(getActivity(), FlashSale.class);
                    intent.putExtra(INTENT_NAME, INTENT_DEALS);
                    startActivity(intent);

                intent = new Intent(getActivity(), FlashSale.class);
                intent.putExtra(INTENT_NAME, INTENT_DEALS);
                startActivity(intent);


            }
        });
        binding.txtViewNewest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), ListProductActivity.class);
                intent.putExtra(ListProductActivity.INTENT_IS_NEW, "Sản phẩm mới");
                startActivity(intent);
            }
        });
        binding.txtViewBestSeller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), ListProductActivity.class);

                intent.putExtra(INTENT_NAME, INTENT_DEALS);
                startActivity(intent);

                intent.putExtra(ListProductActivity.INTENT_IS_DEAL, "Sản phẩm bán chạy");
                startActivity(intent);

            }
        });
        //-----------------GridView item click events-----------------
        binding.gridFlashSale.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MainActivity.sendToProductDetail(flashSale_list.get(i), getActivity());
            }
        });

        binding.gridNewProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MainActivity.sendToProductDetail(newProduct_list.get(i), getActivity());

            }
        });
        binding.gridForYou.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MainActivity.sendToProductDetail(forYou_list.get(i), getActivity());

            }
        });
        binding.gridBestseller.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MainActivity.sendToProductDetail(bestSeller_list.get(i), getActivity());

            }
        });



        //
    }
    public interface SendMessage {
        void sendData(String message);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            SM = (SendMessage) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Error in retrieving data. Please try again");
        }
    }
//    public  List<Product> getListItem(String ColName, String Condition){
//        List<Product> list = new ArrayList<>();
//        Cursor cursor = db.getData("SELECT * FROM " + DataBaseHelper.TBL_PRODUCT + " WHERE " + ColName +  Condition
//                + " LIMIT 10");
//        while (cursor.moveToNext()){
//            list.add(new Product(cursor.getInt(0)));
//        }
//        return list;
//    }


}