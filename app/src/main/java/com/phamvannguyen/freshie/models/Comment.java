package com.phamvannguyen.freshie.models;

public class Comment {
    int commentPhoto;
    String customerName;
    String customerComment;

    public Comment(int commentPhoto, String customerName, String customerComment){
        this.commentPhoto = commentPhoto;
        this.customerName = customerName;
        this.customerComment = customerComment;
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

    public String getCustomerComment() {
        return customerComment;
    }

    public void setCustomerComment(String customerComment) {
        this.customerComment = customerComment;
    }
}
