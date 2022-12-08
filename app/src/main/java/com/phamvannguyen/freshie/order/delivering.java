package com.phamvannguyen.freshie.order;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.adapter.ProductOrderAdapter;
import com.phamvannguyen.freshie.cart.CartModel;

import java.util.ArrayList;


public class delivering extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delivering, container, false);
        ListView lvDelivering = view.findViewById(R.id.lv_delivering);
        ArrayList<CartModel> orders = new ArrayList<>();
        orders.add(new CartModel(1, "kem dưỡng", 10000, 1000000, "Https://salt.tikicdn.com/cache/200x280/ts/product/e7/25/7a/98b0031e8295bfb862b6428da85e9370.png", 1));
//        orders.add(new ProductOrder(R.drawable.vitamintree,"Kem dưỡng da",250000,1));

        ProductOrderAdapter productOrderAdapter = new ProductOrderAdapter(getActivity(),R.layout.item_product_order,orders);
        lvDelivering.setAdapter(productOrderAdapter);

        Button btnViewDetail = view.findViewById(R.id.btn_ViewDetail);
        btnViewDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), OrderTracking.class);
                startActivity(intent);
            }
        });

        return view;
    }
}