package com.phamvannguyen.freshie.product;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.CountDownTimer;
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

    public static final String INTENT_PRODUCT_DETAIL = "Products Detail";
    public static final String INTENT_BUY_WITH_VOUCHER = "BuyWithVoucher";
    public static final String INTENT_PRODUCT_ID = "ProductId";

    Product product;

    ActivityProductDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_product_detail);
        binding = ActivityProductDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadProductDetail();

        addEvents();
        countdown();
    }

    private void countdown() {

        new CountDownTimer(2239000, 1000){

            @Override
            public void onTick(long l) {
                binding.txtCountDown.setText(l/360000%24 + " : " + l/60000%60 + " : "+ l/1000%60 +"s");
            }
            @Override
            public void onFinish() {

            }

        }.start();

    }

    private void loadProductDetail() {
       product = MainActivity.getProductWithId(getIntentId());
       new MainActivity.FetchImage(product.getImageUrl(), binding.imgProduct).start();
       binding.txtDescription.setText(product.getDescription());
       binding.txtProductName.setText(product.getProductName());
       binding.txtPrice.setText(product.getFormattedPrice());
       binding.txtOriginalPrice.setText(product.getFormattedOriginalPrice());
       binding.txtDiscount.setText(product.getFormattedDiscount());



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
                intent.putExtra(INTENT_PRODUCT_DETAIL, INTENT_BUY_WITH_VOUCHER);
                startActivity(intent);
            }
        });
    }

    private int getIntentId() {
        Intent intent = getIntent();
        return intent.getIntExtra(INTENT_PRODUCT_ID, 1);
    }



}