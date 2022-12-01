package com.phamvannguyen.freshie.recommend;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.databinding.FragmentRecommendBinding;

public class RecommendFragment extends Fragment {

    public RecommendFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recommend, container, false);

    }
}