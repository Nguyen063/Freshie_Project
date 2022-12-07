package com.phamvannguyen.freshie.cart;

import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.phamvannguyen.freshie.MainActivity;
import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.databinding.FragmentCartBinding;
import com.phamvannguyen.freshie.models.Product;
import com.phamvannguyen.freshie.payment.Checkout;

import java.util.ArrayList;

public class CartFragment extends Fragment {
    private View view;
    FragmentCartBinding binding;
    CartAdapter adapter;
    ArrayList<CartModel> cartList;
    Product p;
    Button btnInc, btnDec;
    double total = 0;

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

    private void addEvents() {
        binding.lvProductCart.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


            }

        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "click", Toast.LENGTH_SHORT).show();
            }
        });
        binding.btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
//                bundle.putParcelable(Checkout.INTENT_PRODUCT, (Parcelable) cartList);
                Intent intent = new Intent(getActivity(), Checkout.class);
                intent.putExtra(Checkout.INTENT_PRODUCT, bundle);
                startActivity(intent);
            }
        });


    }

    private void loadData() {
        cartList = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            p =  MainActivity.getProductWithId(i);
            cartList.add( new CartModel(p.getProductID(), p.getProductName(), p.getOriginalPrice(), p.getPrice(),p.getThumbUrl(),i));
        }
        adapter = new CartAdapter(getActivity(), R.layout.item_list_product_cart, cartList);
        binding.lvProductCart.setAdapter(adapter);

        ////---Update total price

       updateTotalPrice();
    }
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
