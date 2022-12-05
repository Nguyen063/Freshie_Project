package com.phamvannguyen.freshie.product;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import com.phamvannguyen.freshie.DataBaseHelper;
import com.phamvannguyen.freshie.MainActivity;
import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.cart.CartActivity;
import com.phamvannguyen.freshie.databinding.ActivityProductDetailBinding;
import com.phamvannguyen.freshie.home.HomeFragment;
import com.phamvannguyen.freshie.models.Product;
import com.phamvannguyen.freshie.payment.PaymentMethod;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class ProductDetailActivity extends AppCompatActivity {

    ActivityProductDetailBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        getIntentInfo();


    }



    private void getIntentInfo() {
        Intent intent = getIntent();

//        binding.imgProduct.setImageResource(intent.getByteExtra("Thumb", (byte) R.drawable.banner1));
//        binding.txtProductName.setText(intent.getStringExtra("name"));
//        binding.txtDtPrice.setText(String.valueOf(intent.getStringExtra("price")));

    }
}