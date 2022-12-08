package com.phamvannguyen.freshie.login;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.account.AccountActivity;
import com.phamvannguyen.freshie.databinding.ActivityChangePasswordBinding;

public class ChangePassword extends AppCompatActivity {
    ActivityChangePasswordBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_change_password);
        binding = ActivityChangePasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(ChangePassword.this);
                dialog.setContentView(R.layout.dialog_verify_success);
                Button btnBackProfile = dialog.findViewById(R.id.btn_backProfile);
                btnBackProfile.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(ChangePassword.this, AccountActivity.class);
                        startActivity(intent);
                    }
                });
                dialog.show();
            }
        });
        back();
    }

    private void back() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Đổi mật khẩu");
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

    }
