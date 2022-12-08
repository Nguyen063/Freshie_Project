package com.phamvannguyen.freshie.adapter;

import static android.app.Activity.RESULT_OK;
import static androidx.activity.result.ActivityResultCallerKt.registerForActivityResult;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
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

import com.phamvannguyen.freshie.MainActivity;
import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.categories.CategoryAdapter;
import com.phamvannguyen.freshie.categories.CategoryFragment;
import com.phamvannguyen.freshie.models.Rating;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

public class RatingAdapter extends BaseAdapter {

    Activity activity;
    int item_layout;
    List<Rating> ratingList;
    public static int capture;

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
            holder.imgAddPhoto = view.findViewById(R.id.img_AddPhoto);

            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        Rating rating = ratingList.get(i);
        holder.txtName.setText(rating.getProductName());
        holder.imgProduct.setImageResource(rating.getProductThumb());
        holder.imgAddPhoto.setImageBitmap(rating.getRatingPhoto());


        holder.btnAddPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open dialog
                Intent intent_p = new Intent();
                intent_p.putExtra("position",i);

                Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.dialog_photo_rating);

                LinearLayout llOpenCamera = dialog.findViewById(R.id.ll_OpenCamera);
                LinearLayout llOpenGallery = dialog.findViewById(R.id.ll_OpenGallery);



                llOpenCamera.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        capture =0;
                        //open camera
                        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                        activity.startActivityForResult(intent, 0);
                        dialog.dismiss();

                    }


                });

                llOpenGallery.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        capture =1;
                        Intent intent = new Intent(Intent.ACTION_PICK);
                        intent.setType("image/*");
                        activity.startActivityForResult(intent, 0);
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }

        });

        holder.btnRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.dialog_rating_success);

                Button btnshopNow = dialog.findViewById(R.id.btn_shopNow);
                btnshopNow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(activity, MainActivity.class);
                        activity.startActivity(intent);
                        dialog.dismiss();
                    }
                });

                dialog.show();
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


