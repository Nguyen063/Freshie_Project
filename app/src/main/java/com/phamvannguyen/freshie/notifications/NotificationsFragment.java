package com.phamvannguyen.freshie.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {

    public NotificationsFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notifications, container, false);

    }
}