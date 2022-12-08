package com.phamvannguyen.freshie.account;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.phamvannguyen.freshie.MainActivity;
import com.phamvannguyen.freshie.R;

import java.util.List;

public class EditProfileAdapter extends BaseAdapter {
    EditProfile activity;
    int item_layout;
    List<EditProfileModel> editProfileModelList;

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
        return null;
    }

    public EditProfileAdapter(EditProfile activity, int item_layout, List<EditProfileModel> editProfileModelList) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.editProfileModelList = editProfileModelList;
    }
}






