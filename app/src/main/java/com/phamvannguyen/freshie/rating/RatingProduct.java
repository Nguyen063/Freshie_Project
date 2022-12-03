package com.phamvannguyen.freshie.rating;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.adapter.RatingAdapter;
import com.phamvannguyen.freshie.models.Rating;

import java.util.ArrayList;

public class RatingProduct extends AppCompatActivity {

    RatingAdapter ratingAdapter;
    ArrayList<Rating> ratings;
    ListView lvRating;

    BottomSheetDialog bottomSheetDialog;
    LinearLayout llOpenCamera, llOpenGallery;

    ActivityResultLauncher<Intent> launcher;

    String capture = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        lvRating = findViewById(R.id.lv_rating);

        loadData();
    }

    private void loadData() {
        ratings = new ArrayList<>();
        ratings.add(new Rating(R.drawable.product_photo, "Kem dưỡng da Vitamin Tree Water-Gel"));
        ratings.add(new Rating(R.drawable.product_photo, "Kem dưỡng da Vitamin Tree Water-Gel"));

        ratingAdapter = new RatingAdapter(RatingProduct.this, R.layout.item_rating, ratings);
        lvRating.setAdapter(ratingAdapter);
    }
}