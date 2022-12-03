package com.phamvannguyen.freshie.adapter;

import static android.app.Activity.RESULT_OK;
import static androidx.activity.result.ActivityResultCallerKt.registerForActivityResult;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.model.Rating;

import java.util.List;

public class RatingAdapter extends BaseAdapter {

    Activity activity;
    int item_layout;
    List<Rating> ratingList;

    public RatingAdapter(Activity activity, int item_layout, List<Rating> ratingList) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.ratingList = ratingList;
    }

    @Override
    public int getCount() {
        return ratingList.size();
    }

    @Override
    public Object getItem(int i) {
        return ratingList.get(i);
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

            holder.txtName = view.findViewById(R.id.txt_ProductName);
            holder.imgProduct = view.findViewById(R.id.img_Product);
            holder.btnAddPhoto = view.findViewById(R.id.btn_AddPhoto);
            holder.btnRating = view.findViewById(R.id.btn_Rating);
            holder.btnAddPhoto = view.findViewById(R.id.btn_AddPhoto);

            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        Rating rating = ratingList.get(i);
        holder.txtName.setText(rating.getProductName());
        holder.imgProduct.setImageResource(rating.getProductThumb());

        holder.btnAddPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }

        });

        return view;
    }

    public static class ViewHolder{
        TextView txtName;
        ImageView imgProduct, imgAddPhoto;
        Button btnAddPhoto, btnRating;
    }
}
