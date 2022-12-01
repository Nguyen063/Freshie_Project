package com.phamvannguyen.freshie.rating;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.phamvannguyen.freshie.R;

public class Rating extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private RatingHistoryAdapter ratingHistoryAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        tabLayout = findViewById(R.id.tab_layout_rating_history);
        viewPager2 = findViewById(R.id.rating_history_viewpager);

        ratingHistoryAdapter = new RatingHistoryAdapter(this);
        viewPager2.setAdapter(ratingHistoryAdapter);

        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {

            switch (position) {
                case 0:
                    tab.setText("Chưa đánh giá");
                    break;
                case 1:
                    tab.setText("Đã đánh giá");
                    break;
            }
        }).attach();
    }
}