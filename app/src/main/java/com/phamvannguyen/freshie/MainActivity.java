package com.phamvannguyen.freshie;

import static com.phamvannguyen.freshie.DataBaseHelper.TBL_PRODUCT;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SearchView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.phamvannguyen.freshie.account.AccountActivity;
import com.phamvannguyen.freshie.categories.CategoryAdapter;
import com.phamvannguyen.freshie.categories.CategoryFragment;
import com.phamvannguyen.freshie.databinding.ActivityMainBinding;
import com.phamvannguyen.freshie.home.HomeAdapter;
import com.phamvannguyen.freshie.home.HomeFragment;
import com.phamvannguyen.freshie.models.Product;
import com.phamvannguyen.freshie.product.ListProductActivity;
import com.phamvannguyen.freshie.product.ProductDetailActivity;


import java.net.URL;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements HomeFragment.SendMessage  {

    ActivityMainBinding binding;
    public static ViewPager viewPager;
    public static ViewPager2 viewPager2;
    private BottomNavigationView bottomNavigationView;
    public static DataBaseHelper db;
    TabLayout tabLayout;

    static Handler mainHandler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        db = new DataBaseHelper(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater li = LayoutInflater.from(this);
        View customView = li.inflate(R.layout.actionbar, null);
        actionBar.setCustomView(customView);
        actionBar.setDisplayShowCustomEnabled(true);

        ImageButton btnBackHome = (ImageButton) customView.findViewById(R.id.Back_Home);
        btnBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ImageButton btnProfile = (ImageButton) customView.findViewById(R.id.imv_setting_profile);
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AccountActivity.class);
                startActivity(intent);
            }
        });

        createNavigation();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        searchProduct();
        receiveIntent();

    }

    private void receiveIntent() {
        String intent = getIntent().getStringExtra("to cart");
        if (intent != null) {
            if (intent.equals("cart")) {
                viewPager.setCurrentItem(3);
            }
        }
    }

    private void searchProduct() {

        SearchView searchView = findViewById(R.id.text_search);
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchView.onActionViewExpanded();
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Intent intent = new Intent(MainActivity.this, ListProductActivity.class);
                intent.putExtra(ListProductActivity.INTENT_SEARCH, s);
                startActivity(intent);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

    }


    private void createNavigation() {
        viewPager = findViewById(R.id.main_viewpager);
        bottomNavigationView = findViewById(R.id.nav_view);


        HomeAdapter homeAdapter = new HomeAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter((homeAdapter));
        CategoryAdapter categoryAdapter = new CategoryAdapter();



        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {

                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.navigation_home).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.navigation_notifications).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.navigation_category).setChecked(true);
                        break;
                    case 3:
                        bottomNavigationView.getMenu().findItem(R.id.navigation_cart).setChecked(true);
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
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        viewPager.setCurrentItem(0);
                        break;

                    case R.id.navigation_notifications:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.navigation_category:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.navigation_cart:
                        viewPager.setCurrentItem(3);
                        break;
                }
                return false;


            }
        });
    }


    public static Bitmap convertByteArrayToBitmap(byte[] bytes) {
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }

    @Override
    public void sendData(String message) {
        String tag = "android:switcher:" + R.id.main_viewpager + ":" + 2;
        CategoryFragment f = (CategoryFragment) getSupportFragmentManager().findFragmentByTag("tag_fragment_category");
//        f.displayReceivedData(message);
    }


    public static class FetchImage extends Thread {
        String URL;
        Bitmap bitmap;
        ImageView ImageView;

        public FetchImage(String url, ImageView imv) {
            this.URL = url;
            this.ImageView = imv;
        }


        @Override
        public void run() {
            mainHandler.post(new Runnable() {
                @Override
                public void run() {
//                    progressDialog = new ProgressDialog(MainActivity.this);
//                    progressDialog.setMessage("Getting your pic....");
//                    progressDialog.setCancelable(false);
//                    progressDialog.show();
                }
            });
            InputStream inputStream = null;
            try {
                inputStream = new URL(URL).openStream();
                bitmap = BitmapFactory.decodeStream(inputStream);

            } catch (IOException e) {
                e.printStackTrace();
            }
            mainHandler.post(new Runnable() {
                @Override
                public void run() {
                    ImageView.setImageBitmap(bitmap);

                }
            });
        }

    }
    public static Bitmap getBitmapFromURL(String URL) {
        InputStream inputStream = null;
        try {
            inputStream = new URL(URL).openStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(inputStream);
            return myBitmap;
        } catch (IOException e) {
            // Log exception
            return null;
        }
    }

    public static Product getProductFromCursor(Cursor cursor) {

        return new Product(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3),
                cursor.getDouble(4), cursor.getDouble(5), cursor.getInt(6), cursor.getDouble(7), cursor.getInt(8),
                cursor.getString(10), cursor.getString(12),
                cursor.getInt(13), cursor.getInt(14), cursor.getInt(15),
                cursor.getString(16));
    }
    public static ArrayList<Product> getListWhere(String condition) {
        ArrayList<Product> listProduct = new ArrayList<>();
        String sql = "SELECT * FROM " + DataBaseHelper.TBL_PRODUCT + " WHERE " + condition;
        Cursor cursor = db.getData(sql);
            if(cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    listProduct.add(getProductFromCursor(cursor));
                }
                };

        cursor.close();
        return listProduct;
    }
    public static Product getProductWithId(int Id){
        Product product = null;
        Cursor cursor = db.getData("SELECT * FROM " + DataBaseHelper.TBL_PRODUCT + " WHERE " + DataBaseHelper.COL_ID + " = " + Id);
        if(cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                product = getProductFromCursor(cursor);
            }
        };

        cursor.close();
        return product;
    }

    public static void sendToProductDetail(Product p, Activity activity) {
        Bundle  b = new Bundle();
        b.putParcelable(ProductDetailActivity.INTENT_PRODUCT, p);
        Intent intent = new Intent();
        intent.setClass(activity, ProductDetailActivity.class);
        intent.putExtras(b);
        activity.startActivity(intent);
    }


}


