package com.phamvannguyen.freshie.account;

import static com.phamvannguyen.freshie.MainActivity.db;
import static com.phamvannguyen.freshie.MainActivity.viewPager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.phamvannguyen.freshie.DataBaseHelper;
import com.phamvannguyen.freshie.MainActivity;
import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.databinding.ActivityEditProfileBinding;
import com.phamvannguyen.freshie.home.HomeAdapter;
import com.phamvannguyen.freshie.home.HomeFragment;
import com.phamvannguyen.freshie.watched.Watched;

import java.util.ArrayList;

public class EditProfile extends AppCompatActivity {
    ActivityEditProfileBinding binding;
    DataBaseHelper db;
    EditProfileAdapter adapter;
    ArrayList<EditProfile> editProfiles;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_edit_profile);
        binding = ActivityEditProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnProfileCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditProfile.this, AccountActivity.class);
                startActivity(intent);
            }
        });

        binding.btnProfileSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(EditProfile.this);
                dialog.setContentView(R.layout.dialog_saveprofile_success);
                Button btnBackHome = dialog.findViewById(R.id.btn_back);
                btnBackHome.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(EditProfile.this, AccountActivity.class);
                        startActivity(intent);
                    }
                }); dialog.show();
            }
        });



    }











}