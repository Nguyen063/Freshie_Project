package com.phamvannguyen.freshie.payment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.databinding.ActivityCheckoutBinding;

public class Checkout extends AppCompatActivity {

    ActivityCheckoutBinding binding;
    Spinner spinnerProvince, spinnerDistrict, spinnerTown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_checkout);
        binding = ActivityCheckoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

      //  spinnerProvince = findViewById(R.id.spinner_Province);
        spinnerDistrict = findViewById(R.id.spinner_District);
        spinnerTown = findViewById(R.id.spinner_Town);
    }
}