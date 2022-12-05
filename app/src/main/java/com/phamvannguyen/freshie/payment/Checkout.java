package com.phamvannguyen.freshie.payment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Spinner;

import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.adapter.ProductOrderAdapter;
import com.phamvannguyen.freshie.databinding.ActivityCheckoutBinding;
import com.phamvannguyen.freshie.models.Product;
import com.phamvannguyen.freshie.models.ProductOrder;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class Checkout extends AppCompatActivity {

    ActivityCheckoutBinding binding;
    Spinner spinnerProvince, spinnerDistrict, spinnerTown;

    ProductOrderAdapter productOrderAdapter;
    ArrayList<Product> orders = new ArrayList<>();

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

        Intent intent = getIntent();
        int id = intent.getIntExtra("productId", 0);
//        orders.add(new ProductOrder(R.drawable.product_photo,"Kem dưỡng da Vitamin Tree Water-Gel",350000,2));
//        orders.add(new ProductOrder(R.drawable.vitamintree,"Kem dưỡng da",250000,1));
//        orders.add(new ProductOrder(R.drawable.vitamintree,"Kem dưỡng da",250000,1));
//        orders.add(new ProductOrder(R.drawable.vitamintree,"Kem dưỡng da",250000,1));
//        orders.add(new ProductOrder(R.drawable.vitamintree,"Kem dưỡng da",250000,1));


        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.innisfree);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        orders.add(new Product(1,"Kem dưỡng da Vitamin Tree Water-Gel",1,"inisfree",10000,7000,1000,4.5,40, byteArray ));

        productOrderAdapter = new ProductOrderAdapter(this,R.layout.item_product_order,orders);
        binding.lvOrder.setAdapter(productOrderAdapter);
    }
}