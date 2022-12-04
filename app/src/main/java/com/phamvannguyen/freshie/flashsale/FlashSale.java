package com.phamvannguyen.freshie.flashsale;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.adapter.FlashSaleAdapter;
import com.phamvannguyen.freshie.models.FlashSales;

import java.util.ArrayList;

public class FlashSale extends AppCompatActivity {

    FlashSaleAdapter flashSaleAdapter;
    ArrayList<FlashSales> flashSales = new ArrayList<>();

    ListView lvFlashSale;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_sale);

        lvFlashSale = findViewById(R.id.lv_flashsale);

        loadData();
    }

    private void loadData() {
        flashSales.add(new FlashSales(R.drawable.vitamintree,"Kem dưỡng da Vitamin Tree Water-Gel",350000,20,4.5,100,1000));
        flashSales.add(new FlashSales(R.drawable.vitamintree,"Kem dưỡng da Vitamin Tree Water-Gel",350000,20,4.5,100,1000));
        flashSales.add(new FlashSales(R.drawable.vitamintree,"Kem dưỡng da Vitamin Tree Water-Gel",350000,20,4.5,100,1000));
        flashSales.add(new FlashSales(R.drawable.vitamintree,"Kem dưỡng da Vitamin Tree Water-Gel",350000,20,4.5,100,1000));
        flashSales.add(new FlashSales(R.drawable.vitamintree,"Kem dưỡng da Vitamin Tree Water-Gel",350000,20,4.5,100,1000));
        flashSales.add(new FlashSales(R.drawable.vitamintree,"Kem dưỡng da Vitamin Tree Water-Gel",350000,20,4.5,100,1000));

        flashSaleAdapter = new FlashSaleAdapter(this,R.layout.item_flashsale,flashSales);
        lvFlashSale.setAdapter(flashSaleAdapter);
    }
}