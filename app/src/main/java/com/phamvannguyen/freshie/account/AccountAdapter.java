package com.phamvannguyen.freshie.account;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.phamvannguyen.freshie.R;

import java.util.List;

public class AccountAdapter extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<Account> accountList;

    public AccountAdapter(Activity activity, int item_layout, List<Account> accountList) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.accountList = accountList;
    }

    @Override
    public int getCount() {
        return accountList.size();
    }

    @Override
    public Object getItem(int i) {
        return accountList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);
            // Link views
           holder.imageButtonEditProfile = view.findViewById(R.id.imageButton_editProfile);
           holder.linearLayoutViewOrder = view.findViewById(R.id.ll_vieworder);
           holder.btnWaitingConfirm = view.findViewById(R.id.btn_waitingconfirm);
           holder.btnDelivering = view.findViewById(R.id.btn_delivering);
           holder.btnDelivered = view.findViewById(R.id.btn_delivered);
           holder.btnCanceled = view.findViewById(R.id.btn_canceled);
           holder.rcvCategoryRecyclerView = view.findViewById(R.id.rcv_categoryRecyclerview);
           holder.linearLayoutViewedProduct = view.findViewById(R.id.ll_viewed_product);
           holder.linearLayoutMyRating = view.findViewById(R.id.ll_myrating);
           holder.linearLayoutSettingProfile = view.findViewById(R.id.ll_settingprofile);
           holder.linearLayoutHelpCenter = view.findViewById(R.id.ll_helpcenter);
           holder.linearLayoutLogOut = view.findViewById(R.id.ll_log_out);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        return view;
    }
    public static class ViewHolder {
        ImageView imageButtonEditProfile;
        LinearLayout linearLayoutViewOrder, linearLayoutViewedProduct, linearLayoutMyRating,
        linearLayoutSettingProfile, linearLayoutHelpCenter, linearLayoutLogOut;
        Button btnWaitingConfirm, btnDelivering, btnDelivered, btnCanceled;
        RecyclerView rcvCategoryRecyclerView;

    }
}
