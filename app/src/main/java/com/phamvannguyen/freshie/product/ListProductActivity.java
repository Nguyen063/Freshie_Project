package com.phamvannguyen.freshie.product;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.databinding.ActivityListProductBinding;

public class ListProductActivity extends AppCompatActivity {

    ActivityListProductBinding binding;
    public static final String INTENT_FILTER = "filter";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_list_product);
        binding = ActivityListProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

}