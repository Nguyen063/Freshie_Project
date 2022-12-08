package com.phamvannguyen.freshie.flashsale;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import android.view.View;
import android.widget.AdapterView;

import android.view.MenuItem;

import android.widget.ListView;

import com.phamvannguyen.freshie.DataBaseHelper;
import com.phamvannguyen.freshie.MainActivity;
import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.adapter.FlashSaleAdapter;
import com.phamvannguyen.freshie.databinding.ActivityFlashSaleBinding;
import com.phamvannguyen.freshie.models.Product;
import com.phamvannguyen.freshie.payment.Checkout;
import com.phamvannguyen.freshie.product.ProductDetailActivity;

import java.util.ArrayList;

public class FlashSale extends AppCompatActivity {


    ActivityFlashSaleBinding binding;
    FlashSaleAdapter flashSaleAdapter;
    ArrayList<Product> flashSales = new ArrayList<>();

    ListView lvFlashSale;
    private DataBaseHelper db = MainActivity.db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_sale);

        binding = ActivityFlashSaleBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
//        lvFlashSale = findViewById(R.id.lv_flashsale);
        loadData();

        addEvents();
//        countdown();
        setContentView(view);

    }

    private void addEvents() {

        binding.lvFlashsale.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                MainActivity.sendToProductDetail(flashSales.get(i),FlashSale.this);
                Bundle b = new Bundle();
                b.putParcelable(ProductDetailActivity.INTENT_PRODUCT, flashSales.get(i));
                Intent intent = new Intent(FlashSale.this, Checkout.class);
//                intent.setClass(FlashSale.this, ProductDetailActivity.class);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        back();
//        countdown();

    }

    public void countdown() {
        new CountDownTimer(2239000, 1000){

            @Override
            public void onTick(long l) {
                binding.txtTimeFlashSale.setText(l/360000%24 + " : " + l/60000%60 + " : "+ l/1000%60 +"s");
            }
            @Override
            public void onFinish() {

            }

        }.start();
    }

    private void back() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Flash Sale");
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

    private void loadData() {

        //-----------------get data from database-----------------

        flashSales = MainActivity.getListWhere(DataBaseHelper.COL_IS_DEAL + " = "+ 1);

        flashSaleAdapter = new FlashSaleAdapter(this,R.layout.item_flashsale,flashSales);
        binding.lvFlashsale.setAdapter(flashSaleAdapter);
    }

//    public static void sendToProductDetail(Product p, Activity activity) {
//        Bundle  b = new Bundle();
//        b.putParcelable(ProductDetailActivity.INTENT_PRODUCT, p);
//        Intent intent = new Intent();
//        intent.setClass(activity, ProductDetailActivity.class);
//        intent.putExtras(b);
//        activity.startActivity(intent);
//    }

}