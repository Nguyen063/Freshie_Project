package com.phamvannguyen.freshie.order;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.adapter.ProductOrderAdapter;
import com.phamvannguyen.freshie.models.ProductOrder;

import java.util.ArrayList;


public class delivering extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wait_confirm, container, false);
        ListView lvWaitConfirm = view.findViewById(R.id.lv_wait_confirm);
        ArrayList<ProductOrder> orders = new ArrayList<>();
        orders.add(new ProductOrder(R.drawable.product_photo,"Kem dưỡng da Vitamin Tree Water-Gel",350000,2));
        orders.add(new ProductOrder(R.drawable.vitamintree,"Kem dưỡng da",250000,1));

        ProductOrderAdapter productOrderAdapter = new ProductOrderAdapter(getActivity(),R.layout.item_product_order,orders);
        lvWaitConfirm.setAdapter(productOrderAdapter);

        return view;
    }
}