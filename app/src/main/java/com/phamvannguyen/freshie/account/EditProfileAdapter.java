package com.phamvannguyen.freshie.account;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.phamvannguyen.freshie.MainActivity;
import com.phamvannguyen.freshie.R;

import java.util.List;

public class EditProfileAdapter extends BaseAdapter {
    EditProfile activity;
    int item_layout;
    List<EditProfileModel> editProfileModelList;
    ;

    public EditProfileAdapter(EditProfile activity, int item_layout, List<EditProfileModel> editProfileModelList) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.editProfileModelList = editProfileModelList;
    }

    @Override
    public int getCount() {
        return editProfileModelList.size();
    }

    @Override
    public Object getItem(int i) {
        return editProfileModelList.get(i);
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
            holder.txtUserName = view.findViewById(R.id.txt_userName);
            holder.txtUserEmail = view.findViewById(R.id.txt_userEmail);
            holder.txtUserPhone = view.findViewById(R.id.txt_userPhone);
            holder.txtUserGender = view.findViewById(R.id.txt_userGender);
            holder.txtUserAddress = view.findViewById(R.id.txt_userAddress);
            view.setTag(holder);
            return null;
        } else {
            holder = (ViewHolder) view.getTag();
        }
        EditProfileModel editProfileModel = editProfileModelList.get(i);
        holder.txtUserName.setText(editProfileModel.getUserName());
        holder.txtUserEmail.setText(editProfileModel.getUserEmail());
        holder.txtUserPhone.setText(editProfileModel.getUserPhone());
        holder.txtUserGender.setText(editProfileModel.getUserGender());
        holder.txtUserAddress.setText(editProfileModel.getUserAddress());
        holder.imvEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.openEditDialog(editProfileModel);
            }
        });
        return view;
    }



    public static class ViewHolder{
        TextView txtUserName, txtUserEmail, txtUserPhone, txtUserGender, txtUserAddress ;
        ImageView imvEdit;


    }
}
