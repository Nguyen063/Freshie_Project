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
import com.phamvannguyen.freshie.models.ProductOrder;

import java.util.ArrayList;

public class wait_confirm extends Fragment {


    ArrayList<CartModel> listProduct;
    ProductOrderAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wait_confirm, container, false);
        ListView lvWaitConfirm = view.findViewById(R.id.lv_wait_confirm);

        listProduct = new ArrayList<>();
        listProduct.add(new CartModel(1, "kem dưỡng", 10000, 1000000, "Https://salt.tikicdn.com/cache/200x280/ts/product/e7/25/7a/98b0031e8295bfb862b6428da85e9370.png", 1));

        adapter = new ProductOrderAdapter(getActivity(), R.layout.item_product_order, listProduct);
        lvWaitConfirm.setAdapter(adapter);

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