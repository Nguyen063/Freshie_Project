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
import com.phamvannguyen.freshie.models.Product;
import com.phamvannguyen.freshie.models.ProductOrder;

import java.util.ArrayList;


public class delivering extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delivering, container, false);
        ListView lvDelivering = view.findViewById(R.id.lv_delivering);
        ArrayList<CartModel> orders = new ArrayList<>();
//        orders.add(new ProductOrder(R.drawable.product_photo,"Kem dưỡng da Vitamin Tree Water-Gel",350000,2));
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