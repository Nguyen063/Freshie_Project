package com.phamvannguyen.freshie.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.phamvannguyen.freshie.R;

public class LoginActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private AdapterTablayoutLogin adapterTablayoutLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tabLayout = findViewById(R.id.tab_layout_login);
        viewPager2 = findViewById(R.id.viewpager_login);

        adapterTablayoutLogin = new AdapterTablayoutLogin(this);
        viewPager2.setAdapter(adapterTablayoutLogin);

        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {

            switch (position) {
                case 0:
                    tab.setText("Đăng nhập");
                    break;
                case 1:
                    tab.setText("Đăng ký");
                    break;
            }
        }).attach();
    }

}