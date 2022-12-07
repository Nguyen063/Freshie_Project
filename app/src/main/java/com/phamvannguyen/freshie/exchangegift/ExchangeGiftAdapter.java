package com.phamvannguyen.freshie.exchangegift;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.phamvannguyen.freshie.R;

import java.util.List;

public class ExchangeGiftAdapter extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<ExchangeGiftModel> exchangeGiftList;

    public ExchangeGiftAdapter(Activity activity, int item_layout, List<ExchangeGiftModel> exchangeGiftList) {
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
            holder.btn_voucherPoint = view.findViewById(R.id.btn_voucherPoint);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        ExchangeGiftModel exchangeGiftModel = exchangeGiftList.get(i);
        holder.imvVoucherImage.setImageResource(exchangeGiftModel.getVoucherGift());
        holder.txtVoucherSale.setText(exchangeGiftModel.getVoucherSale());
        holder.txtVoucherCondition.setText(exchangeGiftModel.getVoucherCondition());
        holder.txtVoucherTime.setText(exchangeGiftModel.getVoucherTime());
        holder.btn_voucherPoint.setText(String.valueOf(exchangeGiftModel.getVoucherPoint()));
        return view;

//        holder.btn_voucherPoint.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String b = holder.btn_voucherPoint.getText().toString();
////                int myVoucher = Integer.parseInt(b);
//                if (myVoucher > 300) {
//                    Dialog dialog = new Dialog(activity);
//                    dialog.setContentView(R.layout.dialog_photo_rating);
//                }
//
//            }
//        });
//
    }

    private static class ViewHolder {
        ImageView imvVoucherImage;
        TextView txtVoucherSale, txtVoucherCondition, txtVoucherTime,btn_voucherPoint;
        Button btnMyPoint, btnMyVoucher;
    }

}
