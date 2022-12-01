package com.phamvannguyen.freshie.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }

}