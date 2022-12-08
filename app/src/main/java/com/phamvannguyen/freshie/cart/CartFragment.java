package com.phamvannguyen.freshie.cart;

import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcelable;
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
import com.phamvannguyen.freshie.cache.cacheCart;
import com.phamvannguyen.freshie.databinding.FragmentCartBinding;
import com.phamvannguyen.freshie.models.Product;
import com.phamvannguyen.freshie.payment.Checkout;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

public class CartFragment extends Fragment {
    private View view;
    FragmentCartBinding binding;
    CartAdapter adapter;
    public static ArrayList<CartModel> cartList;
    Product p;
    Button btnInc, btnDec;
    double total = 0;
    DataBaseHelper db = MainActivity.db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        view = inflater.inflate(R.layout.fragment_category, container, false);

        binding = FragmentCartBinding.inflate(inflater, container, false);
        view = binding.getRoot();
        loadData();
        addEvents();
        return view;
    }

    public void updateTotalValue() {
//        total = 0;
//        for (int i = 0; i < cartList.size(); i++) {
//            total += cartList.get(i).getQuantity() * cartList.get(i).getPrice();
//        }
//        binding.txtCartTotalPrice.setText(total + "");

        //Test cacheCart: Update total value
        cacheCart.updateTotalValue();
        binding.txtCartTotalPrice.setText(cacheCart.total + "");
    }

    private void addEvents() {
        binding.lvProductCart.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        binding.btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Bundle bundle = new Bundle();
//                bundle.putParcelable(Checkout.INTENT_PRODUCT, (Parcelable) cartList);
//                Intent intent = new Intent(getActivity(), Checkout.class);
//                intent.putExtra(Checkout.INTENT_PRODUCT, bundle);
//                startActivity(intent);
                Intent intent = new Intent(getActivity(), Checkout.class);
                startActivity(intent);
            }
        });


    }

    private void loadData() {
        cartList = new ArrayList<>();
//        if (cacheCart.cartList.size() == 0) {
//            for (int i = 1; i < 5; i++) {
//                p =  MainActivity.getProductWithId(i);
//                cartList.add( new CartModel(p.getProductID(), p.getProductName(), p.getOriginalPrice(), p.getPrice(),p.getThumbUrl(),1));
//                cacheCart.addCart(new CartModel(p.getProductID(), p.getProductName(), p.getOriginalPrice(), p.getPrice(),p.getThumbUrl(),1));
//            }
//            cacheCart.updateTotalValue();

        int id, quantity;
        ArrayList<Integer> idList = new ArrayList<>();
        ArrayList<Integer> quantityList = new ArrayList<>();
        Cursor cursor = db.getData("SELECT * FROM " + DataBaseHelper.TBL_CART);

        if(cursor.getCount() > 0){
            while (cursor.moveToNext()) {
                idList.add(cursor.getInt(0));
                quantityList.add(cursor.getInt(1));
            }

        }
        cursor.close();
        for (int i = 0; i < idList.size(); i++) {
            id = idList.get(i);
            quantity = quantityList.get(i);
            p = MainActivity.getProductWithId(id);
            cartList.add(new CartModel(p.getProductID(), p.getProductName(), p.getOriginalPrice(), p.getPrice(), p.getThumbUrl(), quantity));
            cacheCart.addCart(new CartModel(p.getProductID(), p.getProductName(), p.getOriginalPrice(), p.getPrice(), p.getThumbUrl(), quantity));
        }
        adapter = new CartAdapter(getActivity(), R.layout.item_list_product_cart, cacheCart.cartList);
        binding.lvProductCart.setAdapter(adapter);
        updateTotalPrice();

    }

        ////---Update total price

    public void updateTotalPrice(){
        for (CartModel item : cartList) {
            total += item.getPrice() * item.getQuantity();
        }
        binding.txtCartTotalPrice.setText(String.format("%,.0f đ", total));
    }
    public void onCartDecrease(){
        updateTotalPrice();
    }
    public void onCartIncrease(){
        updateTotalPrice();
    }
}
