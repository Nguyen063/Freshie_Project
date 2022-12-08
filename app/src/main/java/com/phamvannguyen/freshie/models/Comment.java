package com.phamvannguyen.freshie.models;

public class Comment {
    int commentPhoto;
    String customerName;
    String CommentContent;

    public Comment(int commentPhoto, String customerName, String commentContent) {
        this.commentPhoto = commentPhoto;
        this.customerName = customerName;
        CommentContent = commentContent;
    }

    public int getCommentPhoto() {
        return commentPhoto;
    }

    public void setCommentPhoto(int commentPhoto) {
        this.commentPhoto = commentPhoto;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCommentContent() {
        return CommentContent;
    }

    public void setCommentContent(String commentContent) {
        CommentContent = commentContent;
    }
}
