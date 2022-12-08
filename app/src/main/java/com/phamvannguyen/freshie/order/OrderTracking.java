package com.phamvannguyen.freshie.order;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.databinding.ActivityOderTrackingBinding;
import com.phamvannguyen.freshie.rating.RatingHistory;

public class OrderTracking extends AppCompatActivity {

    ActivityOderTrackingBinding binding;
    AdapterTablayoutOrder adapterTablayoutOrder = new AdapterTablayoutOrder(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_oder_tracking);

        binding = ActivityOderTrackingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvents();
        back();

    }



    private void back() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Theo dõi đơn hàng");
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