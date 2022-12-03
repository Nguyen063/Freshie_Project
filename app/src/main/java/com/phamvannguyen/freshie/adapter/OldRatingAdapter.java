package com.phamvannguyen.freshie.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.models.OldRating;

import java.util.ArrayList;
import java.util.List;

public class OldRatingAdapter extends BaseAdapter {

    Activity activity;
    int item_layout;
    List<OldRating> oldRatingList;

    public OldRatingAdapter(FragmentActivity activity, int item_old_rating, ArrayList<OldRating> oldRatingList) {
        this.activity = activity;
        this.item_layout = item_old_rating;
        this.oldRatingList = oldRatingList;
    }

    @Override
    public int getCount() {
        return oldRatingList.size();
    }

    @Override
    public Object getItem(int i) {
        return oldRatingList.get(i);
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
            holder.txtReview = view.findViewById(R.id.txt_Review);
            holder.txtDate = view.findViewById(R.id.txt_date);
            holder.imgProduct = view.findViewById(R.id.img_Product);

            view.setTag(holder);
        }
        else{
            holder = (ViewHolder) view.getTag();
        }

        OldRating oldRating = oldRatingList.get(i);
        holder.txtName.setText(oldRating.getProductName());
        holder.txtReview.setText(oldRating.getReview());
        holder.txtDate.setText(oldRating.getDaterating());
        holder.imgProduct.setImageResource(oldRating.getProductThumb());

        return view;
    }

    public static class ViewHolder{
        TextView txtName, txtReview, txtDate;
        ImageView imgProduct;
    }
}
