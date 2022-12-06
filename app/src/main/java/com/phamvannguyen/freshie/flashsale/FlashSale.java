package com.phamvannguyen.freshie.flashsale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.CountDownTimer;
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