package com.phamvannguyen.freshie.cart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.databinding.ActivityCartBinding;
import com.phamvannguyen.freshie.payment.Checkout;
import com.phamvannguyen.freshie.payment.PaymentMethod;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class CartActivity extends AppCompatActivity {
        ActivityCartBinding binding;
        CartAdapter adapter;
        ArrayList<CartModel> cartList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_cart);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();

        addEvents();
    }

    private void addEvents() {
        binding.btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CartActivity.this, Checkout.class);
                startActivity(intent);
            }
        });
    }

    private void loadData() {
        cartList = new ArrayList<>();
        cartList.add(new CartModel(R.drawable.vitamintree,
                "Kem dưỡng da Vitamin Tree Water-Gel",
                350000.0,1));
        cartList.add(new CartModel(R.drawable.banobagi_cart,
                "Mặt nạ BNBG Whitening Stem Cell Collagen",
                180000.0, 1));
        cartList.add(new CartModel(R.drawable.vichymineral89,
                "Dưỡng chất cô đặc Vichy Mineral 89 – 75ml",
                980000.0, 1));
        cartList.add(new CartModel(R.drawable.serumlancome,
                "Tinh Chất Hỗ Trợ Dưỡng Ẩm & Trẻ Hóa Da Lancôme 100ml",
                990000.0,1));
        cartList.add(new CartModel(R.drawable.tonerklairs,
                "Nước Hoa Hồng Klairs Không Mùi Cho Da Nhạy Cảm 180ml",
                245000.0,1));
        cartList.add(new CartModel(R.drawable.lotionlancome,
                "Nước Hoa Hồng Lancome Tonique Confort Toner 125ml",
                570000.0,1));
        cartList.add(new CartModel(R.drawable.esteelauder,
                "Kem Dưỡng Phục Hồi Da Vùng Mắt Estée Lauder 15ml",
                860000.0, 1));
        cartList.add(new CartModel(R.drawable.goohndoc,
                "Serum dưỡng mờ thâm GoodnDoc Hydra B5 75ml",
                680000.0, 1));
        cartList.add(new CartModel(R.drawable.pair,
                "Kem Hỗ Trợ Cải Thiện Mụn Pair Nhật Bản 14g",
                125000.0, 1));
        cartList.add(new CartModel(R.drawable.tonerkiehls,
                "Nước Cân Bằng Hoa Cúc Kiehl’s 500ml",
                880000.0, 1));

        adapter = new CartAdapter(this, R.layout.item_list_product_cart, cartList);
        binding.lvProductCart.setAdapter(adapter);

    }




}