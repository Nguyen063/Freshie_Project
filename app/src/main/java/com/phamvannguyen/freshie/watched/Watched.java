package com.phamvannguyen.freshie.watched;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

import com.phamvannguyen.freshie.DataBaseHelper;
import com.phamvannguyen.freshie.MainActivity;
import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.categories.CategoryAdapter;
import com.phamvannguyen.freshie.databinding.ActivityWatchedBinding;
import com.phamvannguyen.freshie.databinding.FragmentCategoryBinding;
import com.phamvannguyen.freshie.models.Product;
import com.phamvannguyen.freshie.product.categoryproduct.CategoryProductAdapter;

import java.util.ArrayList;

public class Watched extends AppCompatActivity {

    private View view;
    private GridView gvProduct;
    static ArrayList<Product> products;

    ActivityWatchedBinding binding;
    private DataBaseHelper db = MainActivity.db;

    CategoryProductAdapter categoryProductAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_watched);

        binding = ActivityWatchedBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        setContentView(view);

        gvProduct = (GridView) view.findViewById(R.id.gv_ListProduct);
        products = new ArrayList<Product>();

        loadData();

        back();
    }

    private void loadData() {
        categoryProductAdapter = new CategoryProductAdapter(this);

        products = new ArrayList<>();
        products = MainActivity.getListWhere(DataBaseHelper.COL_IS_BEST_SELLER + " = 1");

        CategoryAdapter forYouAdapter = new CategoryAdapter(this, R.layout.item_category, products);
        binding.gvListProduct.setAdapter(forYouAdapter);
    }

    private void back() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Sản phẩm đã xem");
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