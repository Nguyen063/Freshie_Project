package com.phamvannguyen.freshie.account;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.databinding.FragmentAccountBinding;

public class AccountFragment extends Fragment {


    public AccountFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_account, container, false);

    }
}