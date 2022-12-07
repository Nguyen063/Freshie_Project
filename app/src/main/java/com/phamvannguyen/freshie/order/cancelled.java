package com.phamvannguyen.freshie.order;

import android.content.Intent;
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
import com.phamvannguyen.freshie.cart.CartModel;
import com.phamvannguyen.freshie.models.Product;
import com.phamvannguyen.freshie.models.ProductOrder;
import com.phamvannguyen.freshie.payment.Checkout;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class cancelled extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cancelled, container, false);
        ListView lvWaitConfirm = view.findViewById(R.id.lv_cancelled);
        ArrayList<CartModel> orders = new ArrayList<>();


        byte[] image = null;


//        orders.add(new Product(1,"Kem dưỡng da Vitamin Tree Water-Gel",
//                1,"inisfree",10000,7000,1000,4.5,40, image ));
//        orders.add(new Product(R.drawable.product_photo,"Kem dưỡng da Vitamin Tree Water-Gel",350000,2));
//        orders.add(new Product(R.drawable.vitamintree,"Kem dưỡng da",250000,1));

        ProductOrderAdapter productOrderAdapter = new ProductOrderAdapter(getActivity(),R.layout.item_product_order,orders);
        lvWaitConfirm.setAdapter(productOrderAdapter);

        Button btnReorder = view.findViewById(R.id.btn_reorder);
        btnReorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Checkout.class);
                startActivity(intent);
            }
        });

        return view;
    }
}