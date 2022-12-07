package com.phamvannguyen.freshie.exchangegift;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.phamvannguyen.freshie.R;

import java.util.List;

public class MyVoucherAdapter extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<ExchangeGiftModel> exchangeGiftList;

    public MyVoucherAdapter(Activity activity, int item_layout, List<ExchangeGiftModel> exchangeGiftList) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.exchangeGiftList = exchangeGiftList;
    }

    @Override
    public int getCount() {
        return exchangeGiftList.size();
    }

    @Override
    public Object getItem(int i) {
        return exchangeGiftList.get(i);
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
            holder.imvVoucherImage = view.findViewById(R.id.imv_voucherImage);
            holder.txtVoucherSale = view.findViewById(R.id.txt_voucherSale);
            holder.txtVoucherCondition = view.findViewById(R.id.txt_voucherCondition);
            holder.txtVoucherTime = view.findViewById(R.id.txt_voucherTime);
            holder.btnMyPoint = view.findViewById(R.id.btn_myPoint);
            holder.btnMyVoucher = view.findViewById(R.id.btn_myVoucher);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
            ExchangeGiftModel exchangeGiftModel = exchangeGiftList.get(i);
            holder.imvVoucherImage.setImageResource(exchangeGiftModel.getVoucherGift());
            holder.txtVoucherSale.setText(exchangeGiftModel.getVoucherSale());
            holder.txtVoucherCondition.setText(exchangeGiftModel.getVoucherCondition());
            holder.txtVoucherTime.setText(exchangeGiftModel.getVoucherTime());
            return view;
        }

    private static class ViewHolder {
        ImageView imvVoucherImage;
        TextView txtVoucherSale, txtVoucherCondition, txtVoucherTime;
        Button btnMyPoint, btnMyVoucher;
    }
}
