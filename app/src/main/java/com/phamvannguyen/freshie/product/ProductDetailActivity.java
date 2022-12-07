package com.phamvannguyen.freshie.product;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.phamvannguyen.freshie.DataBaseHelper;
import com.phamvannguyen.freshie.MainActivity;
import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.adapter.CommentAdapter;
import com.phamvannguyen.freshie.cart.CartFragment;
import com.phamvannguyen.freshie.categories.CategoryAdapter;
import com.phamvannguyen.freshie.customerservice.CustomerService;
import com.phamvannguyen.freshie.databinding.ActivityProductDetailBinding;
import com.phamvannguyen.freshie.models.Comment;
import com.phamvannguyen.freshie.models.Product;
import com.phamvannguyen.freshie.models.ProductBase;
import com.phamvannguyen.freshie.payment.Checkout;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailActivity extends AppCompatActivity {

    public static final String INTENT_PRODUCT_DETAIL = "Products Detail";
    public static final String INTENT_BUY_WITH_VOUCHER = "BuyWithVoucher";
    public static final String INTENT_PRODUCT = "Product Parcelable";
    ProductBase bundleProduct;
    Product product;

    ActivityProductDetailBinding binding;

    List<Product> forYou_list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_product_detail);
        binding = ActivityProductDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadProductDetail();
        loadDataGridView();


    }

    private void loadProductDetail() {
        Bundle bundle = getIntent().getExtras();
        bundleProduct = bundle.getParcelable(INTENT_PRODUCT);

        product = MainActivity.getProductWithId(bundleProduct.getProductID());


        new MainActivity.FetchImage(product.getImageUrl(), binding.imgProduct).start();
        binding.txtProductName.setText(product.getProductName());
        binding.txtPrice.setText(product.getFormattedPrice());
        binding.txtDiscount.setText(product.getFormattedDiscount());
        binding.txtDescription.setText(product.getDescription());
        binding.txtSold.setText(product.getSold() + " đã bán");

    }

    private void loadDataGridView() {

        forYou_list = new ArrayList<>();
        forYou_list = MainActivity.getListWhere(DataBaseHelper.COL_IS_BEST_SELLER + " = 1");
        CategoryAdapter forYouAdapter = new CategoryAdapter(this, R.layout.item_category, forYou_list);
//        binding.gvForyou.setAdapter(forYouAdapter);



}

    }