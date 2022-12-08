package com.phamvannguyen.freshie.rating;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
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

//        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
//            if(result.getResultCode() == RESULT_OK && result.getData() != null){
//                if(capture.equals("camera")){
//                    bitmap = (Bitmap) result.getData().getExtras().get("data");
//                }
//                else if(capture.equals("photo")){
//                    Uri uri = result.getData().getData();
//                    try {
//                        InputStream inputStream = getContentResolver().openInputStream(uri);
//                        bitmap = BitmapFactory.decodeStream(inputStream);
////                        binding.imgPhoto.setImageBitmap(bitmap);
//                    } catch (FileNotFoundException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
            back();

        setContentView(R.layout.activity_rating);
        lvRating = findViewById(R.id.lv_rating);

        loadData();
        addEvents();



    }

    private void back() {

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Đánh giá sản phẩm");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void addEvents() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if( resultCode == RESULT_OK && data != null){
            if(RatingAdapter.capture == 0){
                bitmap = (Bitmap) data.getExtras().get("data");
            }
            else if(RatingAdapter.capture == 1){
                Uri uri = data.getData();
                try {
                    InputStream inputStream = getContentResolver().openInputStream(uri);
                    bitmap = BitmapFactory.decodeStream(inputStream);
//                        binding.imgPhoto.setImageBitmap(bitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();

    }

    private void loadData() {
        ratings = initialList();
//        ratings.add(new Rating(R.drawable.product_photo, "Kem dưỡng da Vitamin Tree Water-Gel",bitmap));
//        ratings.add(new Rating(R.drawable.product_photo, "Kem dưỡng da Vitamin Tree Water-Gel",bitmap));

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
    private  ArrayList<Rating> initialList(){
        ArrayList<Rating> ratings = new ArrayList<>();
        ratings.add(new Rating(R.drawable.product_photo, "Kem dưỡng da Vitamin Tree Water-Gel",bitmap));
        return ratings;
    }
}