package com.phamvannguyen.freshie.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;


import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.databinding.ActivitySignupBinding;

import kotlin.contracts.Returns;

public class sign_up extends Fragment {  // Inflate the layout for this fragment

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);//
             return view;

    }
}
