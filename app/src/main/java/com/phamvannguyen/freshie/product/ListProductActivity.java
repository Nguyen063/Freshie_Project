package com.phamvannguyen.freshie.product;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
    public static final String INTENT_SEARCH = "search";
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
    ArrayList<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_list_product);
        binding = ActivityListProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadData();
        addEvents();
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
    }

    private void loadData() {
        products = new ArrayList<>();
        for (String item : list) {
            if (getIntent().hasExtra(item)) {
                filter = getIntent().getStringExtra(item);
                products = MainActivity.getListWhere(item + " = '" + filter + "'");
                break;
            }
        }
        if (products.size() == 0) {
            binding.txtNoData.setVisibility(View.VISIBLE);
        }
        CategoryAdapter adapter = new CategoryAdapter(this,R.layout.item_category, products);
        binding.gvListProduct.setAdapter(adapter);
    }

}