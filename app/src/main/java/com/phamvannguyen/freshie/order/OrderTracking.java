package com.phamvannguyen.freshie.order;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.databinding.ActivityOderTrackingBinding;
import com.phamvannguyen.freshie.rating.RatingHistory;

public class OrderTracking extends AppCompatActivity {

    ActivityOderTrackingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_oder_tracking);

        binding = ActivityOderTrackingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvents();

    }

    private void addEvents() {

        //intent sang fragment cancel - order
        binding.btnCancelOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderTracking.this, order.class);
                startActivity(intent);
            }
        });

        //intent sang fragment delivered - order
        binding.btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderTracking.this, RatingHistory.class);
                startActivity(intent);
            }
        });
    }
}