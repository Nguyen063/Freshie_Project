package com.phamvannguyen.freshie.flashsale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
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

        //--Set raw data---
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.innisfree);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        flashSales.add(new Product(1,"Kem dưỡng da Vitamin Tree Water-Gel",1,"inisfree",10000,7000,1000,4.5,40, byteArray ));
        flashSales.add(new Product(1,"Kem dưỡng da Vitamin Tree Water-Gel",1,"inisfree",10000,7000,1000,4.5,40, byteArray ));
        flashSales.add(new Product(1,"Kem dưỡng da Vitamin Tree Water-Gel",1,"inisfree",10000,7000,1000,4.5,40, byteArray ));



        //-----------------get data from database-----------------
//        Cursor cursor = db.getData("SELECT "+ DataBaseHelper.COL_ID + " , "
//                + DataBaseHelper.COL_NAME + " , "
//                + DataBaseHelper.COL_CATEGORY + " , "
//                + DataBaseHelper.COL_BRAND + " , "
//                + DataBaseHelper.COL_ORIGINAL_PRICE + " , "
//                + DataBaseHelper.COL_PRICE + " , "
//                + DataBaseHelper.COL_SOLD + " , "
//                + DataBaseHelper.COL_RATING_AVERAGE  + " , "
//                + DataBaseHelper.COL_RATING_COUNT+ " , "
//                + DataBaseHelper.COL_IMAGE
//                + " FROM " + DataBaseHelper.TBL_PRODUCT + " WHERE " + DataBaseHelper.COL_ID + " = "+ 1);
//
//
//        while (cursor.moveToNext()){
//            flashSales.add(new Product(cursor.getInt(0), cursor.getString(1), cursor.getInt(2),
//                    cursor.getString(3), cursor.getDouble(4), cursor.getDouble(5),cursor.getInt(6),
//                    cursor.getDouble(7), cursor.getInt(8),cursor.getBlob(9)));
//        }
//        cursor.close();

        //-----------------get data from database-----------------



        flashSaleAdapter = new FlashSaleAdapter(this,R.layout.item_flashsale,flashSales);
        lvFlashSale.setAdapter(flashSaleAdapter);
    }
    public void buyNow(FlashSales flashSales){
        Intent intent = new Intent(this, Checkout.class);
        startActivity(intent);
    }
}