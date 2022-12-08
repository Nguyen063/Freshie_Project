package com.phamvannguyen.freshie.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.models.Comment;

import java.util.List;

public class CommentAdapter extends BaseAdapter {

    Activity activity;
    int item_comment;
    List<com.phamvannguyen.freshie.models.Comment> CommentList;

    public CommentAdapter(Activity activity, int item_comment, List<com.phamvannguyen.freshie.models.Comment> commentList) {
        this.activity = activity;
        this.item_comment = item_comment;
        CommentList = commentList;
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
            view = inflater.inflate(this.item_comment, null);
            holder.commentPhoto = view.findViewById(R.id.imv_CommentPhoto);
            holder.customerName = view.findViewById(R.id.txt_CustomerName);
            holder.customerComment = view.findViewById(R.id.txt_CustomerComment);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }
        Comment comment = CommentList.get(i);
        holder.commentPhoto.setImageResource(comment.getCommentPhoto());
        holder.customerName.setText(comment.getCustomerName());
        holder.customerComment.setText(comment.getCommentContent());

        return view;
    }

    private static class ViewHolder {
        ImageView commentPhoto;
        TextView customerName;
        TextView customerComment;
    }
}
