package com.phamvannguyen.freshie.categories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.phamvannguyen.freshie.R;

public class Categories extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private CategoriesAdapter categoriesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        tabLayout = findViewById(R.id.tab_layout_categories);
        viewPager2 = findViewById(R.id.categories_viewpager);

        categoriesAdapter = new CategoriesAdapter(this);
        viewPager2.setAdapter(categoriesAdapter);

        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {

            switch (position) {
                case 0:
                    tab.setText("HOT DEAL");
                    break;
                case 1:
                    tab.setText("SKIN CARE");
                    break;
                case 2:
                    tab.setText("HAIR CARE");
                    break;
                case 3:
                    tab.setText("MAKE UP");
                    break;
            }
        }).attach();
    }
}