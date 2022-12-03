package com.phamvannguyen.freshie.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.models.Notification;

import java.util.List;

public class NotificationAdapter extends BaseAdapter {

    Activity activity;
    int item_layout;
    List<Notification> notificationList;

    public NotificationAdapter(Activity activity, int item_layout, List<Notification> notificationList) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.notificationList = notificationList;
    }

    @Override
    public int getCount() {
        return notificationList.size();
    }

    @Override
    public Object getItem(int i) {
        return notificationList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(this.item_layout,null);

            holder.txtTitle = view.findViewById(R.id.txt_NotiTitle);
            holder.txtContent = view.findViewById(R.id.txt_NotiContent);
            holder.txtDate = view.findViewById(R.id.txt_NotiTime);

            view.setTag(holder);
        }
        else{
            holder = (ViewHolder) view.getTag();
        }

        Notification notification = notificationList.get(i);
        holder.txtTitle.setText(notification.getTitle());
        holder.txtContent.setText(notification.getContent());
        holder.txtDate.setText(notification.getDate());

        return view;
    }

    public static class ViewHolder{
        TextView txtTitle, txtContent, txtDate;
    }
}
