package com.phamvannguyen.freshie.login;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.phamvannguyen.freshie.R;
import com.smarteist.autoimageslider.SliderView;


public class login extends Fragment {

    Button btnLogin;
    EditText edtAccount, edtPassword;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        btnLogin = view.findViewById(R.id.btn_Login);
        edtAccount = view.findViewById(R.id.edt_Account);
        edtPassword = view.findViewById(R.id.edt_Password);



        return view;

    }
}