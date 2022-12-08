package com.phamvannguyen.freshie.order;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.phamvannguyen.freshie.R;

public class order extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private AdapterTablayoutOrder adapterTablayoutOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        tabLayout = findViewById(R.id.tab_layout_order);
        viewPager2 = findViewById(R.id.viewpager_order);

        adapterTablayoutOrder = new AdapterTablayoutOrder(this);
        viewPager2.setAdapter(adapterTablayoutOrder);
        back();

        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {

            switch (position) {
                case 0:
                    tab.setText("Chờ xác nhận");
                    break;
                case 1:
                    tab.setText("Đang giao");
                    break;
                case 2:
                    tab.setText("Đã giao");
                    break;
                case 3:
                    tab.setText("Đã hủy");
                    break;
            }
        }).attach();
    }

    private void back() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Đơn hàng");
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


