package com.phamvannguyen.freshie.product;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

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
import com.phamvannguyen.freshie.product.categoryproduct.CategoryProduct;
import com.phamvannguyen.freshie.product.categoryproduct.CategoryProductAdapter;
import com.phamvannguyen.freshie.product.itemproduct.ItemProduct;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailActivity extends AppCompatActivity {

    public static final String INTENT_PRODUCT_DETAIL = "Products Detail";
    public static final String INTENT_BUY_WITH_VOUCHER = "BuyWithVoucher";
    public static final String INTENT_PRODUCT = "Product Parcelable";
    ProductBase bundleProduct;
    Product product;
    Comment comment;
    CategoryAdapter adapter;

    ActivityProductDetailBinding binding;
//    private RecyclerView rcvCategoryProduct;
    private CategoryProductAdapter categoryProductAdapter;

    List<Product> forYou_list = new ArrayList<>();
    List<Comment> commentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_product_detail);
        binding = ActivityProductDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadComment();
        loadProductDetail();
        loadDataGridView();
        back();


    }

    private void loadComment() {
        List<Comment> commentList = new ArrayList<>();
        commentList.add(new Comment(R.drawable.vitamintree, "Ank Nguỹn", "comment này mang tính chất nhận xu xin đừng đọc hue hue"));
        commentList.add(new Comment(R.drawable.anhspcuakhach, "Đỗ Huỳnh Thảo Vy", "Cái sản phẩm này sử dụng keo ly quáaaa. Mình dùng mà da mặt phải gọi là mãi mận, mãi đỉnh lun ý."));

        CommentAdapter commentAdapter = new CommentAdapter(this,R.layout.item_comment,commentList);
        binding.lvComment.setAdapter(commentAdapter);
    }
    public void back() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Chi tiết sản phẩm");
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

    private List<CategoryProduct> getListCategoryProduct() {
        List<CategoryProduct> listCategoryProduct = new ArrayList<>();
        List<ItemProduct> listItemProduct = new ArrayList<>();
        listItemProduct.add(new ItemProduct(R.drawable.vitamintree, "Vitamin Tree"));
        listItemProduct.add(new ItemProduct(R.drawable.vichymineral89, "Vichy Mineral 89"));
        listItemProduct.add(new ItemProduct(R.drawable.lotionlancome, "Toner Lancome"));
        listItemProduct.add(new ItemProduct(R.drawable.serumlancome, "Tinh chất Lancome"));
        listItemProduct.add(new ItemProduct(R.drawable.tonerklairs, "Nước hoa hồng Klairs"));

        listItemProduct.add(new ItemProduct(R.drawable.vitamintree, "Vitamin Tree"));
        listItemProduct.add(new ItemProduct(R.drawable.vichymineral89, "Vichy Mineral 89"));
        listItemProduct.add(new ItemProduct(R.drawable.lotionlancome, "Toner Lancome"));
        listItemProduct.add(new ItemProduct(R.drawable.serumlancome, "Tinh chất Lancome"));
        listItemProduct.add(new ItemProduct(R.drawable.tonerklairs, "Nước hoa hồng Klairs"));

        listItemProduct.add(new ItemProduct(R.drawable.vitamintree, "Vitamin Tree"));
        listItemProduct.add(new ItemProduct(R.drawable.vichymineral89, "Vichy Mineral 89"));
        listItemProduct.add(new ItemProduct(R.drawable.lotionlancome, "Toner Lancome"));
        listItemProduct.add(new ItemProduct(R.drawable.serumlancome, "Tinh chất Lancome"));
        listItemProduct.add(new ItemProduct(R.drawable.tonerklairs, "Nước hoa hồng Klairs"));


        listItemProduct.add(new ItemProduct(R.drawable.vitamintree, "Vitamin Tree"));
        listItemProduct.add(new ItemProduct(R.drawable.vichymineral89, "Vichy Mineral 89"));
        listItemProduct.add(new ItemProduct(R.drawable.lotionlancome, "Toner Lancome"));
        listItemProduct.add(new ItemProduct(R.drawable.serumlancome, "Tinh chất Lancome"));
        listItemProduct.add(new ItemProduct(R.drawable.tonerklairs, "Nước hoa hồng Klairs"));


        listCategoryProduct.add(new CategoryProduct(listItemProduct));
        return listCategoryProduct;


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

        private void loadDataGridView () {

            categoryProductAdapter = new CategoryProductAdapter(this);

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            binding.rcvCategoryProduct.setLayoutManager(linearLayoutManager);


            forYou_list = new ArrayList<>();
            forYou_list = MainActivity.getListWhere(DataBaseHelper.COL_IS_BEST_SELLER + " = 1");

            CategoryAdapter forYouAdapter = new CategoryAdapter(this, R.layout.item_category, forYou_list);
            categoryProductAdapter.setData(getListCategoryProduct());
            binding.rcvCategoryProduct.setAdapter(categoryProductAdapter);
            binding.gvForyou.setAdapter(forYouAdapter);

//            adapter = new CategoryAdapter(this,R.layout.item_category, forYou_list);
//            binding.gvForyou.setAdapter(adapter);
//
//
            binding.gvForyou.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(ProductDetailActivity.this, ProductDetailActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable(INTENT_PRODUCT, forYou_list.get(position));
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
            binding.btnChatNow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ProductDetailActivity.this, CustomerService.class);
                    startActivity(intent);
                }
            });
            binding.btnAddToCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(ProductDetailActivity.this, "Thêm thành công", Toast.LENGTH_LONG).show();
                }
            });
            binding.btnBuy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ProductDetailActivity.this, Checkout.class);
                    startActivity(intent);
                }
            });

        }

    }
