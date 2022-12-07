package com.phamvannguyen.freshie.account;

import static com.phamvannguyen.freshie.MainActivity.db;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.AccessibilityDelegateCompat;

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
import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.databinding.ActivityEditProfileBinding;
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
//        loadData();

        binding.btnProfileCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditProfile.this, AccountActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loadData() {
        editProfiles = new ArrayList<>();
        Cursor c = db.getData("SELECT * FROM " + DataBaseHelper.TBL_USER);
//        while (c.moveToNext()) {
//            editProfiles.add(new EditProfile(c.getString(0), c.getString(1), c.getString(2), c.getString(3),
//                    c.getString(4)));
//        }
    c.close();

        }





    public void openEditDialog(EditProfileModel editProfileModel) {
        Dialog dialog = new Dialog(EditProfile.this);
        dialog.setContentView(R.layout.dialog_edit_userinfo);
        EditText edtUserName, edtUserEmail, edtUserPhone, edtUserAddress;
        RadioGroup rdgUserGender;
        RadioButton rdbMale, rdbFemale, rdbOther;
        Button btnSave, btnCancel;


        edtUserName = dialog.findViewById(R.id.edt_userName);
        edtUserName.setText(editProfileModel.getUserName());

        edtUserEmail = dialog.findViewById(R.id.edt_userEmail);
        edtUserEmail = dialog.findViewById(R.id.edt_userEmail);

        edtUserPhone = dialog.findViewById(R.id.edt_userPhone);
        edtUserPhone.setText(editProfileModel.getUserPhone());

        edtUserAddress = dialog.findViewById(R.id.edt_userAddress);
        edtUserAddress.setText(editProfileModel.getUserAddress());


        rdgUserGender = dialog.findViewById(R.id.rdg_Gender);
        rdbMale = dialog.findViewById(R.id.radio_Male);
        rdbFemale = dialog.findViewById(R.id.radio_Female);
        rdbOther = dialog.findViewById(R.id.radio_Other);
        btnSave = dialog.findViewById(R.id.btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.execSql("UPDATE" + DataBaseHelper.TBL_USER + " SET " + DataBaseHelper.COL_UserName
                        + "='" + edtUserName.getText().toString() + "', " + DataBaseHelper.COL_UserEmail + "="
//                + edtUserEmail.getText().toString() + "', " + DataBaseHelper.COL_UserPhone + "='"
                        + edtUserPhone.getText().toString() + "', " + DataBaseHelper.COL_UserAddress + "='"
                        + edtUserAddress.getText().toString() + "', " + DataBaseHelper.COL_UserGender + "='"
                        + rdgUserGender.getCheckedRadioButtonId());

                loadData();
                dialog.dismiss();


            }
        });
        btnCancel = dialog.findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }











}