package com.phamvannguyen.freshie.flashsale;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
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
import com.phamvannguyen.freshie.product.ProductDetailActivity;

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
                Intent intent = new Intent(FlashSale.this, ProductDetailActivity.class);
//                intent.setClass(FlashSale.this, ProductDetailActivity.class);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }

    private void countdown() {
        new CountDownTimer(2239000, 1000) {
            @Override
            public void onTick(long l) {
                binding.txtFlashSale.setText(l/360000%24 + " : " + l/60000%60 + " : "+ l/1000%60 +"s");
            }

            @Override
            public void onFinish() {
            }
        }.start();
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