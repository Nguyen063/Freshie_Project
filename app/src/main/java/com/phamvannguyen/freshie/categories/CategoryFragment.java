package com.phamvannguyen.freshie.categories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.phamvannguyen.freshie.R;

public class CategoryFragment extends Fragment {
    private View view;

    public CategoryFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ///
        view = inflater.inflate(R.layout.fragment_category, container, false);
        return view;


    }

}