package com.phamvannguyen.freshie.flashsale;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.phamvannguyen.freshie.DataBaseHelper;
import com.phamvannguyen.freshie.MainActivity;
import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.adapter.FlashSaleAdapter;
import com.phamvannguyen.freshie.databinding.ActivityFlashSaleBinding;
import com.phamvannguyen.freshie.models.FlashSales;
import com.phamvannguyen.freshie.models.Product;
import com.phamvannguyen.freshie.payment.Checkout;

import java.io.ByteArrayOutputStream;
import java.text.BreakIterator;
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

        lvFlashSale = findViewById(R.id.lv_flashsale);
        loadData();
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
        lvFlashSale.setAdapter(flashSaleAdapter);
    }
    public void buyNow(FlashSales flashSales){
        Intent intent = new Intent(this, Checkout.class);
        startActivity(intent);
    }
}