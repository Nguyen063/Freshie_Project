package com.phamvannguyen.freshie.exchangegift;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.databinding.ActivityUserVoucherBinding;
import java.util.ArrayList;

public class UserVoucherActivity extends AppCompatActivity {

    ActivityUserVoucherBinding binding;
    MyVoucherAdapter adapter;
    ArrayList<ExchangeGiftModel> exchangeGiftList;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  setContentView(R.layout.activity_gift_voucher);

        binding = ActivityUserVoucherBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();
        addEvents();
        back();
    }
    private void back() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Voucher của tôi");
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

    private void addEvents() {
        binding.btnMyPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserVoucherActivity.this, ExchangeGiftActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void loadData() {
        exchangeGiftList = new ArrayList<>();
        exchangeGiftList.add(new ExchangeGiftModel(R.drawable.vichy,"Giảm 100k",
                "Giảm tối đa 100K cho đơn từ 500K",
                "HSD: 31/12/2022", 200));
        exchangeGiftList.add(new ExchangeGiftModel(R.drawable.innisfree,"Giảm 30%",
                "Giảm 30% tối đa 100K cho đơn từ 600K",
                "HSD: 31/12/2022", 500));
        exchangeGiftList.add(new ExchangeGiftModel(R.drawable.senka,"Giảm 30k",
                "Giảm 30K cho đơn từ 500K",
                "HSD: 31/12/2022", 300));
        exchangeGiftList.add(new ExchangeGiftModel(R.drawable.anessa,"Giảm 100k",
                "Giảm 50K cho đơn từ 500K",
                "HSD: 31/12/2022",400));
        exchangeGiftList.add(new ExchangeGiftModel(R.drawable.anessa,"Giảm 100k",
                "Giảm 50K cho đơn từ 500K",
                "HSD: 31/12/2022",200));

        adapter = new MyVoucherAdapter(this, R.layout.item_user_voucher, exchangeGiftList);
        binding.lvVoucher.setAdapter(adapter);

    }
}