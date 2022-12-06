package com.phamvannguyen.freshie.product;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.phamvannguyen.freshie.DataBaseHelper;
import com.phamvannguyen.freshie.MainActivity;
import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.cart.CartActivity;
import com.phamvannguyen.freshie.customerservice.CustomerService;
import com.phamvannguyen.freshie.databinding.ActivityProductDetailBinding;
import com.phamvannguyen.freshie.home.HomeFragment;
import com.phamvannguyen.freshie.models.Product;
import com.phamvannguyen.freshie.payment.Checkout;
import com.phamvannguyen.freshie.payment.PaymentMethod;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class ProductDetailActivity extends AppCompatActivity {

    public static final String INTENT_NAME = "Products Detail";
    public static final String INTENT_BUYWITHVOUCHER = "BuyWithVoucher";


    ActivityProductDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_product_detail);
        binding = ActivityProductDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getIntentInfo();

        addEvents();
    }

    private void addEvents() {

        binding.btnChatNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductDetailActivity.this, CustomerService.class);
                startActivity(intent);
            }
        });

        binding.btnAddToCart.setOnClickListener(new View.OnClickListener() {

            //truyen data sang cart

            //show dialog
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(ProductDetailActivity.this);
                dialog.setContentView(R.layout.dialog_addtocart_success);

                Button btnViewCart = dialog.findViewById(R.id.btn_viewCart);
                btnViewCart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ProductDetailActivity.this, CartActivity.class);
                        startActivity(intent);
                    }
                });

                dialog.show();
            }
        });

        binding.btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductDetailActivity.this, Checkout.class);
                intent.putExtra(INTENT_NAME, INTENT_BUYWITHVOUCHER);
                startActivity(intent);
            }
        });
    }

    private void getIntentInfo() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("productID", 0);
    }



}