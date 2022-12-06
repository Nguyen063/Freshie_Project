package com.phamvannguyen.freshie.rating;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.adapter.RatingAdapter;
import com.phamvannguyen.freshie.models.Rating;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class RatingProduct extends AppCompatActivity {

    RatingAdapter ratingAdapter;
    ArrayList<Rating> ratings;
    ListView lvRating;

    ActivityResultLauncher<Intent> launcher;

    String capture = null;
    Bitmap bitmap = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if(result.getResultCode() == RESULT_OK && result.getData() != null){
                if(capture.equals("camera")){
                    bitmap = (Bitmap) result.getData().getExtras().get("data");
                }
                else if(capture.equals("photo")){
                    Uri uri = result.getData().getData();
                    try {
                        InputStream inputStream = getContentResolver().openInputStream(uri);
                        bitmap = BitmapFactory.decodeStream(inputStream);
//                        binding.imgPhoto.setImageBitmap(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        });




        setContentView(R.layout.activity_rating);
        lvRating = findViewById(R.id.lv_rating);

        loadData();



    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();

    }

    private void loadData() {
        ratings = new ArrayList<>();
        ratings.add(new Rating(R.drawable.product_photo, "Kem dưỡng da Vitamin Tree Water-Gel",bitmap));
        ratings.add(new Rating(R.drawable.product_photo, "Kem dưỡng da Vitamin Tree Water-Gel",bitmap));

        ratingAdapter = new RatingAdapter(RatingProduct.this, R.layout.item_rating, ratings);
        lvRating.setAdapter(ratingAdapter);
    }

    public void getBitmap(){
        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if(result.getResultCode() == RESULT_OK && result.getData() != null){
                if(capture.equals("camera")){
                    Bitmap bitmap = (Bitmap) result.getData().getExtras().get("data");
//                    binding.imgPhoto.setImageBitmap(bitmap);
                }
                else if(capture.equals("photo")){
                    Uri uri = result.getData().getData();
                    try {
                        InputStream inputStream = getContentResolver().openInputStream(uri);
                        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
//                        binding.imgPhoto.setImageBitmap(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }
}