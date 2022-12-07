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
    public static final String INTENT_CATEGORY = "CategoryProduct";
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
    ArrayList<Product> products, filterProducts;

    CategoryAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_list_product);
        binding = ActivityListProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadData();
        addEvents();
//        filterList();

    }

//    private void filterList() {
//
//        if(products.size() != 0)
//        {
//          filterBy();
//        }
//        else
//        {
//            binding.txtNoData.setVisibility(View.VISIBLE);
//        }
//
//    }

    private void filterBy(String feature){
        filterProducts = products;
        for (int i = 0; i < products.size(); i++) {
            if (feature == "Nổi bật" && products.get(i).getIsDeal() == 0) {
                filterProducts.remove(i);
            }
            else if (feature == "Mới nhất" && products.get(i).getIsNew() == 0) {
                filterProducts.remove(i);
            }
            else if (feature == "Bán chạy" && products.get(i).getIsBestSeller() == 0) {
                filterProducts.remove(i);
            }
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
                filterBy(binding.btnNew.getText().toString());
                updateGridView(filterProducts);
            }
        });
        binding.btnBestseller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterBy(binding.btnBestseller.getText().toString());
                updateGridView(filterProducts);
            }
        });
        binding.btnOutstanding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterBy(binding.btnOutstanding.getText().toString());
                updateGridView(filterProducts);
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
       updateGridView(products);
    }

    private void updateGridView(ArrayList<Product> products) {
        adapter = new CategoryAdapter(this,R.layout.item_category, products);
        binding.gvListProduct.setAdapter(adapter);
    }
}