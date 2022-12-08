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

    private View view;
    FragmentNotificationsBinding binding;
    public NotificationsFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        view = inflater.inflate(R.layout.fragment_notifications, container, false);
        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        view = binding.getRoot();
        ListView lvNotification = view.findViewById(R.id.lv_notification);
        ArrayList<Notification> notifications = new ArrayList<>();

        Button btnPromotion = view.findViewById(R.id.btn_promotion);
        Button btnYourNoti = view.findViewById(R.id.btn_yourNoti);

        notifications.add(new Notification("Khuyến mãi","Khuyến mãi 20% cho đơn hàng trên 500k","12/12/2020"));
        notifications.add(new Notification("Khuyến mãi","Khuyến mãi 20% cho đơn hàng trên 500k","12/12/2020"));
        notifications.add(new Notification("Khuyến mãi","Khuyến mãi 20% cho đơn hàng trên 500k","12/12/2020"));
        NotificationAdapter adapter = new NotificationAdapter(getActivity(),R.layout.item_notification,notifications);
        lvNotification.setAdapter(adapter);

        btnPromotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notifications.clear();
                notifications.add(new Notification("Khuyến mãi","Khuyến mãi 20% cho đơn hàng trên 500k","12/12/2020"));
                notifications.add(new Notification("Khuyến mãi","Khuyến mãi 20% cho đơn hàng trên 500k","12/12/2020"));
                notifications.add(new Notification("Khuyến mãi","Khuyến mãi 20% cho đơn hàng trên 500k","12/12/2020"));
                adapter.notifyDataSetChanged();
                btnPromotion.setBackgroundColor(getResources().getColor(R.color.color_custom_pink));
                btnYourNoti.setBackgroundColor(getResources().getColor(R.color.color_custom_blue));
            }

        });

        btnYourNoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notifications.clear();
                notifications.add(new Notification("Bạn đang có 2 mã voucher sắp hết hạn","Voucher giảm 8% cho đơn hàng viên uống DHC từ 600K sẽ hết hạn vào ngày mai","12/12/2020"));
                notifications.add(new Notification("Thông báo","Đơn hàng #123456789 của bạn đã được giao","12/12/2020"));
                notifications.add(new Notification("Thông báo","Đơn hàng của bạn đã được giao","12/12/2020"));
                adapter.notifyDataSetChanged();
                btnPromotion.setBackgroundColor(getResources().getColor(R.color.color_custom_blue));
                btnYourNoti.setBackgroundColor(getResources().getColor(R.color.color_custom_pink));
            }
        });

        return view;
    }
}