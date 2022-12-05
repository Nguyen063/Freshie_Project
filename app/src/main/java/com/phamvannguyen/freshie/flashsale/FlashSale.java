package com.phamvannguyen.freshie.flashsale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ListView;

import com.phamvannguyen.freshie.DataBaseHelper;
import com.phamvannguyen.freshie.MainActivity;
import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.adapter.FlashSaleAdapter;
import com.phamvannguyen.freshie.models.FlashSales;
import com.phamvannguyen.freshie.models.Product;
import com.phamvannguyen.freshie.payment.Checkout;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class FlashSale extends AppCompatActivity {

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
//        flashSales.add(new FlashSales(R.drawable.vitamintree,"Kem dưỡng da Vitamin Tree Water-Gel",350000,20,4.5,100,1000));
//        flashSales.add(new FlashSales(R.drawable.vitamintree,"Kem dưỡng da Vitamin Tree Water-Gel",350000,20,4.5,100,1000));
//        flashSales.add(new FlashSales(R.drawable.vitamintree,"Kem dưỡng da Vitamin Tree Water-Gel",350000,20,4.5,100,1000));
//        flashSales.add(new FlashSales(R.drawable.vitamintree,"Kem dưỡng da Vitamin Tree Water-Gel",350000,20,4.5,100,1000));
//        flashSales.add(new FlashSales(R.drawable.vitamintree,"Kem dưỡng da Vitamin Tree Water-Gel",350000,20,4.5,100,1000));
//        flashSales.add(new FlashSales(R.drawable.vitamintree,"Kem dưỡng da Vitamin Tree Water-Gel",350000,20,4.5,100,1000));

//        //-----------------get data from database-----------------
//        Cursor cursor = db.getData("SELECT "+ DataBaseHelper.COL_ID +
//                 " FROM " + DataBaseHelper.TBL_PRODUCT + " WHERE " + DataBaseHelper.COL_IS_DEAL + " = "+ 1);
//
//        while (cursor.moveToNext()){
//            flashSales.add(new Product(cursor.getInt(0)));
//        }
//        cursor.close();

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