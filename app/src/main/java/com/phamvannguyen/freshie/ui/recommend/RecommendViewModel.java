package com.phamvannguyen.freshie.ui.recommend;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RecommendViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public RecommendViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Recommend fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}