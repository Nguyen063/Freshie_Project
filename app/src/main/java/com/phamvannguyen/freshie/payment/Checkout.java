package com.phamvannguyen.freshie.payment;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.phamvannguyen.freshie.MainActivity;
import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.adapter.ProductOrderAdapter;
import com.phamvannguyen.freshie.cache.cacheCart;
import com.phamvannguyen.freshie.cart.CartFragment;
import com.phamvannguyen.freshie.cart.CartModel;
import com.phamvannguyen.freshie.databinding.ActivityCheckoutBinding;
import com.phamvannguyen.freshie.exchangegift.UserVoucherActivity;
import com.phamvannguyen.freshie.models.Product;
import com.phamvannguyen.freshie.models.ProductBase;
import com.phamvannguyen.freshie.order.order;
import com.phamvannguyen.freshie.product.ProductDetailActivity;

import java.util.ArrayList;

public class Checkout extends AppCompatActivity {

    ActivityCheckoutBinding binding;
    Spinner spinnerProvince, spinnerDistrict, spinnerTown;

    ProductBase product;
    ProductOrderAdapter productOrderAdapter;
    ArrayList<CartModel> orders = new ArrayList<CartModel>();
    public static final String INTENT_PRODUCT = "INTENT_PRODUCT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_checkout);
        binding = ActivityCheckoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        spinnerProvince = findViewById(R.id.spinner_Province);
        String [] Province = new String[] {"Hà Nội", "Thành phố Hồ Chí Minh", "Bình Thuận", "Bình Định"};
        ArrayAdapter<String> province = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Province);
        spinnerProvince.setAdapter(province);

        spinnerDistrict = findViewById(R.id.spinner_District);
        String [] District = new String[] {"Q1", "Q2", "Q3", "Q4", "Q5", "Thủ Đức"};
        ArrayAdapter<String> district = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, District);
        spinnerDistrict.setAdapter(district);

        spinnerTown = findViewById(R.id.spinner_Town);
        String [] Town = new String[] {"Linh Xuân", "Linh Trung", "Linh Chiểu"};
        ArrayAdapter<String> town = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Town);
        spinnerTown.setAdapter(town);

        loadData();

        addEvents();
        back();


    }
    private void loadData() {

        orders = CartFragment.cartList;
        if(orders != null){
            binding.txtPaymentMethod.setText("Thanh toán khi nhận hàng");
            binding.txtTotalPrice.setText(String.format("%,.0f ₫", cacheCart.total));
            binding.txtToPay.setText(String.format("%,.0f ₫", cacheCart.total));
            binding.txtPlaceOrderPrice.setText(String.format("%,.0f ₫", cacheCart.total));

            productOrderAdapter = new ProductOrderAdapter(this,R.layout.item_product_order,orders);
            binding.lvOrder.setAdapter(productOrderAdapter);
        }
        else{

            orders = new ArrayList<>();
            Bundle bundle = getIntent().getExtras();
            product = (ProductBase) bundle.getParcelable(INTENT_PRODUCT);
            binding.txtPaymentMethod.setText("Thanh toán khi nhận hàng");
            product = MainActivity.getProductWithId(product.getProductID());
//            product = MainActivity.getProductWithId(p.getProductID());
            binding.txtToPay.setText(String.format("%,.0f ₫", product.getPrice()));

            orders.add(new CartModel(product.getProductID(),product.getProductName(),product.getPrice(),product.getOriginalPrice(),product.getThumbUrl(), 1));

            productOrderAdapter = new ProductOrderAdapter(this,R.layout.item_product_order,orders);
            binding.lvOrder.setAdapter(productOrderAdapter);
        }


    }


    private void back() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Thanh toán");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void addEvents() {

        binding.btnUseVoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.edtVoucher.getText().toString().equals("")){
                    Toast.makeText(Checkout.this, "Vui lòng nhập mã voucher", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Checkout.this, "Đã áp dụng mã voucher", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.txtChooseVoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Checkout.this, UserVoucherActivity.class);
                startActivity(intent);
            }
        });

        binding.btnChangePayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Checkout.this, PaymentMethod.class);
                startActivity(intent);
            }
        });

        binding.btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(Checkout.this);
                dialog.setContentView(R.layout.dialog_checkout_success);

                Button btnOrderTracking = dialog.findViewById(R.id.btn_orderTracking);

                btnOrderTracking.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(Checkout.this, order.class);
                        startActivity(intent);
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent payment = getIntent();
        String paymentItent = payment.getStringExtra("paymentMethod");
        if(paymentItent != null)
        {
            binding.txtPaymentMethod.setText(paymentItent);
        }


    }


}