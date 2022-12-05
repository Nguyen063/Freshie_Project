package com.phamvannguyen.freshie.order;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.adapter.ProductOrderAdapter;
import com.phamvannguyen.freshie.models.Product;
import com.phamvannguyen.freshie.models.ProductOrder;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class cancelled extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wait_confirm, container, false);
        ListView lvWaitConfirm = view.findViewById(R.id.lv_wait_confirm);
        ArrayList<Product> orders = new ArrayList<>();


        byte[] image = null;


//        orders.add(new Product(1,"Kem dưỡng da Vitamin Tree Water-Gel",
//                1,"inisfree",10000,7000,1000,4.5,40, image ));
//        orders.add(new Product(R.drawable.product_photo,"Kem dưỡng da Vitamin Tree Water-Gel",350000,2));
//        orders.add(new Product(R.drawable.vitamintree,"Kem dưỡng da",250000,1));

        ProductOrderAdapter productOrderAdapter = new ProductOrderAdapter(getActivity(),R.layout.item_product_order,orders);
        lvWaitConfirm.setAdapter(productOrderAdapter);

        return view;
    }
}