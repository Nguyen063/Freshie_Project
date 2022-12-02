package com.phamvannguyen.freshie;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.phamvannguyen.freshie.home.HomeAdapter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        copyDB();
        createNavigation();

    }

    private void copyDB() {
        File dbPath = getDatabasePath(DataBaseHelper.DB_NAME);
        if(!dbPath.exists()){
            //Copy data
            if(copyDBFromAssets()) {
                Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Fail!", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private boolean copyDBFromAssets() {
        String dbPath = getApplicationInfo().dataDir + DataBaseHelper.DB_PATH_SUFFIX +DataBaseHelper.DB_NAME;

        try {
            InputStream inputStream = getAssets().open(DataBaseHelper.DB_NAME);
            File f = new File(getApplicationInfo().dataDir+ DataBaseHelper.DB_PATH_SUFFIX);
            if(!f.exists()){
                f.mkdir();
            }
            OutputStream outputStream = new FileOutputStream(dbPath);
            byte[] buffer = new byte[1024];
            int lenght ;
            while ((lenght= inputStream.read(buffer))>0){

                outputStream.write(buffer,0,lenght);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    private void createNavigation() {
        viewPager = findViewById(R.id.main_viewpager);
        bottomNavigationView =findViewById(R.id.nav_view);


        HomeAdapter homeAdapter = new HomeAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter((homeAdapter));


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){

                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.navigation_home).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.navigation_notifications).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.navigation_cart).setChecked(true);
                        break;
                    case 3:
                        bottomNavigationView.getMenu().findItem(R.id.navigation_account).setChecked(true);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.navigation_home:
                        viewPager.setCurrentItem(0);
                        break;

                    case R.id.navigation_notifications:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.navigation_cart:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.navigation_account:
                        viewPager.setCurrentItem(3);
                        break;
                }
                return false;
            }
        });
    }

}
