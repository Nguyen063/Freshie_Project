package com.phamvannguyen.freshie.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.phamvannguyen.freshie.MainActivity;
import com.phamvannguyen.freshie.databinding.ActivitySignupBinding;

public class SignupActivity extends AppCompatActivity {

    ActivitySignupBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_signup);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvents();
    }

    private void addEvents() {
        binding.btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = binding.edtName.getText().toString();
                String password = binding.edtPassword.getText().toString();
                String email = binding.edtEmail.getText().toString();
                String confirmPass = binding.edtConfirmPassword.getText().toString();
                if(username.isEmpty()) {
                    binding.edtName.setError("Username is required");
                    binding.edtName.requestFocus();
                    return;
                }
                if(password.isEmpty()) {
                    binding.edtPassword.setError("Password is required");
                    binding.edtPassword.requestFocus();
                    return;
                }
                if(email.isEmpty()) {
                    binding.edtEmail.setError("Email is required");
                    binding.edtEmail.requestFocus();
                    return;
                }
                if(confirmPass.isEmpty()){
                    binding.edtConfirmPassword.setError("Confirm password is required");
                    binding.edtConfirmPassword.requestFocus();
                    return;
                }
                if(!confirmPass.equals(password)){
                    binding.edtConfirmPassword.setError("Confirm password is not match");
                    binding.edtConfirmPassword.requestFocus();
                    return;
                }
                Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        binding.txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        binding.tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }

}