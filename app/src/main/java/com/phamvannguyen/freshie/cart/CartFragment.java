package com.phamvannguyen.freshie.cart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.databinding.FragmentCartBinding;

public class CartFragment extends Fragment {

    private View view;

    public CartFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cart, container, false);


    }
}