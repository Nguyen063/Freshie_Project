package com.phamvannguyen.freshie.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Comment;

import java.util.List;

public class CommentAdapter extends BaseAdapter {

    Activity activity;
    int item_comment;
    List<Comment> CommentList;

    public CommentAdapter (Activity activity, int item_comment, List<Comment> CommentList) {
        this.activity = activity;
        this.item_comment = item_comment;
        this.CommentList = CommentList;
    }

    @Override
    public int getCount() {
        return CommentList.size();
    }

    @Override
    public Object getItem(int i) {
        return CommentList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {

        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        }

        return null;
    }

    private static class ViewHolder {
        ImageView commentPhoto;
        TextView customerName;
        TextView customerComment;
    }
}
