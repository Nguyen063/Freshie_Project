package com.phamvannguyen.freshie.rating;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.phamvannguyen.freshie.R;

public class RatingHistory extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private RatingHistoryAdapter ratingHistoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_history);

        back();

        tabLayout = findViewById(R.id.tabLayout_rating);
        viewPager2 = findViewById(R.id.viewPager_rating);

        ratingHistoryAdapter = new RatingHistoryAdapter(this);
        viewPager2.setAdapter(ratingHistoryAdapter);

        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            switch (position){
                case 0:
                    tab.setText("Chưa đánh giá");
                    break;
                case 1:
                    tab.setText("Đã đánh giá");
                    break;
            }
        }).attach();

    }

    private void back() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Lịch sử đánh giá");
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
}