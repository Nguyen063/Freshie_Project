package com.phamvannguyen.freshie.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.adapter.NotificationAdapter;
import com.phamvannguyen.freshie.databinding.FragmentNotificationsBinding;
import com.phamvannguyen.freshie.models.Notification;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;
    public NotificationsFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);
        ListView lvNotification = view.findViewById(R.id.lv_notification);
        ArrayList<Notification> notifications = new ArrayList<>();

        Button btnPromotion = view.findViewById(R.id.btn_promotion);
        Button bntYourNoti = view.findViewById(R.id.btn_yourNoti);

        notifications.add(new Notification("Khuyến mãi","Khuyến mãi 20% cho đơn hàng trên 500k","12/12/2020"));
        notifications.add(new Notification("Khuyến mãi","Khuyến mãi 20% cho đơn hàng trên 500k","12/12/2020"));
        notifications.add(new Notification("Khuyến mãi","Khuyến mãi 20% cho đơn hàng trên 500k","12/12/2020"));
        NotificationAdapter adapter = new NotificationAdapter(getActivity(),R.layout.item_notification,notifications);
        lvNotification.setAdapter(adapter);

        return view;
    }
}