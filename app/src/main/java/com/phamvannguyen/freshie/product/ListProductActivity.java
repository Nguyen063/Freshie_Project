package com.phamvannguyen.freshie.product;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.phamvannguyen.freshie.DataBaseHelper;
import com.phamvannguyen.freshie.MainActivity;
import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.categories.CategoryAdapter;
import com.phamvannguyen.freshie.databinding.ActivityListProductBinding;
import com.phamvannguyen.freshie.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ListProductActivity extends AppCompatActivity {

    ActivityListProductBinding binding;
    public static final String INTENT_CATEGORY = "Category";
    public static final String INTENT_BRAND = "Brand";
    public static final String INTENT_SEARCH = "ProductName";
    public static final String INTENT_IS_DEAL = "is_deal";
    public static final String INTENT_IS_NEW = "is_new";
    public static final String INTENT_IS_BEST_SELLER = "is_best_seller";
    String filter;
    ArrayList<String> list = new ArrayList<String>()
    {
        {
            add(INTENT_CATEGORY);
            add(INTENT_BRAND);
            add(INTENT_SEARCH);
            add(INTENT_IS_DEAL);
            add(INTENT_IS_NEW);
            add(INTENT_IS_BEST_SELLER);
        }
    };
    //Create list string from INTENT
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Product> filterProducts = new ArrayList<>();

    CategoryAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_list_product);
        binding = ActivityListProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadData();
        addEvents();
        back();
    }
    public void back() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Danh sách sản phẩm");
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



    private void filterBy(String feature){

        filterProducts = new ArrayList<>();
            if (feature == "Nổi bật" ) {
               filterProducts = MainActivity.getListWhere(DataBaseHelper.COL_IS_BEST_SELLER + " = 1");
            }
            else if (feature == "Mới nhất" ) {
                filterProducts = MainActivity.getListWhere(DataBaseHelper.COL_ID + " > 0 ORDER BY " + DataBaseHelper.COL_ID + " DESC");
            }
            else if (feature == "Bán chạy" ) {
                filterProducts = MainActivity.getListWhere(DataBaseHelper.COL_IS_NEW + " = 1 ORDER BY " + DataBaseHelper.COL_SOLD + " DESC");
            }
            else if (feature  ==  "Giá"){
                filterProducts = MainActivity.getListWhere(DataBaseHelper.COL_ID + " > 0 ORDER BY " + DataBaseHelper.COL_PRICE + " DESC");
            }


    }
    private void addEvents() {
        binding.gvListProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Product product = products.get(i);
                Bundle bundle = new Bundle();
                Intent intent = new Intent(ListProductActivity.this, ProductDetailActivity.class);
                bundle.putParcelable(ProductDetailActivity.INTENT_PRODUCT, product);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        binding.btnHairCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                products = MainActivity.getListWhere(DataBaseHelper.COL_CATEGORY + " = 'Chăm sóc tóc'");
                updateGridView(products);
            }
        });
        binding.btnSkincare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                products = MainActivity.getListWhere(DataBaseHelper.COL_CATEGORY + " = 'Chăm sóc da mặt'");
                updateGridView(products);
            }
        });
        binding.btnMakeup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                products = MainActivity.getListWhere(DataBaseHelper.COL_CATEGORY + " = 'Trang điểm'");
                updateGridView(products);
            }
        });
        binding.btnPerfume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                products = MainActivity.getListWhere(DataBaseHelper.COL_CATEGORY + " = 'Nước hoa'");
                updateGridView(products);
            }
        });
        if (products.size() == 0) {
            binding.txtNoData.setVisibility(View.VISIBLE);
        }
        else {
            binding.txtNoData.setVisibility(View.GONE);
        }

        binding.btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterBy("Mới nhất");
                updateGridView(filterProducts);
            }
        });
        binding.btnBestseller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterBy("Bán chạy");
                updateGridView(filterProducts);
            }
        });
        binding.btnOutstanding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterBy("Nổi bật");
                updateGridView(filterProducts);
            }
        });
        binding.btnPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterBy("Giá");
                updateGridView(filterProducts);
            }
        });
    }

    private void loadData() {
        products = new ArrayList<>();
        for (String item : list) {
            if (getIntent().hasExtra(item)) {
                if(item.equals(INTENT_SEARCH)){
                    filter = getIntent().getStringExtra(item);
                    products = MainActivity.getListWhere(item + " LIKE '%" + filter + "%'");
                    TextView txtTitle = binding.txtTitle;
                    txtTitle.setText("Kết quả tìm kiếm" + " '" + filter + "'");
                    txtTitle.setTextSize(14);
                    txtTitle.setTextColor(Color.parseColor("#000000"));
                }
                else if(item.equals(INTENT_BRAND)||item.equals(INTENT_CATEGORY)){
                    filter = getIntent().getStringExtra(item);
                    products = MainActivity.getListWhere(item + " ='" + filter + "'");
                    binding.txtTitle.setText(filter);
                }
                else{
                    filter = getIntent().getStringExtra(item);
                   products = MainActivity.getListWhere(item + " = 1");
                   binding.txtTitle.setText(filter);
                }
                break;
            }
        }

       updateGridView(products);
    }

    private void updateGridView(ArrayList<Product> products) {
        adapter = new CategoryAdapter(this,R.layout.item_category, products);
        binding.gvListProduct.setAdapter(adapter);
    }
}