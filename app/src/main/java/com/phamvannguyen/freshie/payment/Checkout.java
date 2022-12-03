package com.phamvannguyen.freshie.payment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.adapter.ProductOrderAdapter;
import com.phamvannguyen.freshie.databinding.ActivityCheckoutBinding;
import com.phamvannguyen.freshie.models.ProductOrder;

import java.util.ArrayList;

public class Checkout extends AppCompatActivity {

    ActivityCheckoutBinding binding;
    Spinner spinnerProvince, spinnerDistrict, spinnerTown;

    ProductOrderAdapter productOrderAdapter;
    ArrayList<ProductOrder> orders = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_checkout);
        binding = ActivityCheckoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

      //  spinnerProvince = findViewById(R.id.spinner_Province);
        spinnerDistrict = findViewById(R.id.spinner_District);
        spinnerTown = findViewById(R.id.spinner_Town);

        loadData();
    }

    private void loadData() {
        orders.add(new ProductOrder(R.drawable.product_photo,"Kem dưỡng da Vitamin Tree Water-Gel",350000,2));
        orders.add(new ProductOrder(R.drawable.vitamintree,"Kem dưỡng da",250000,1));
        orders.add(new ProductOrder(R.drawable.vitamintree,"Kem dưỡng da",250000,1));
        orders.add(new ProductOrder(R.drawable.vitamintree,"Kem dưỡng da",250000,1));
        productOrderAdapter = new ProductOrderAdapter(this,R.layout.item_product_order,orders);
        binding.lvOrder.setAdapter(productOrderAdapter);
    }
}