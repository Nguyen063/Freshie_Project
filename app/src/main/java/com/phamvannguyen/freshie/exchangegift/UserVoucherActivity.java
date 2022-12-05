package com.phamvannguyen.freshie.exchangegift;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.databinding.ActivityUserVoucherBinding;
import java.util.ArrayList;

public class UserVoucherActivity extends AppCompatActivity {

    ActivityUserVoucherBinding binding;
    ExchangeGiftAdapter adapter;
    ArrayList<ExchangeGiftModel> exchangeGiftList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  setContentView(R.layout.activity_gift_voucher);
        binding = ActivityUserVoucherBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadData();
    }

    private void loadData() {
        exchangeGiftList = new ArrayList<>();
        exchangeGiftList.add(new ExchangeGiftModel(R.drawable.vichy,"Giảm 100k",
                "Giảm tối đa 100K cho đơn từ 500K",
                "HSD: 31/12/2022"));
        exchangeGiftList.add(new ExchangeGiftModel(R.drawable.innisfree,"Giảm 30%",
                "Giảm 30% tối đa 100K cho đơn từ 600K",
                "HSD: 31/12/2022"));
        exchangeGiftList.add(new ExchangeGiftModel(R.drawable.senka,"Giảm 30k",
                "Giảm 30K cho đơn từ 500K",
                "HSD: 31/12/2022"));
        exchangeGiftList.add(new ExchangeGiftModel(R.drawable.anessa,"Giảm 100k",
                "Giảm 50K cho đơn từ 500K",
                "HSD: 31/12/2022"));
        exchangeGiftList.add(new ExchangeGiftModel(R.drawable.anessa,"Giảm 100k",
                "Giảm 50K cho đơn từ 500K",
                "HSD: 31/12/2022"));

        adapter = new ExchangeGiftAdapter(this, R.layout.item_list_voucher, exchangeGiftList);
        binding.lvVoucher.setAdapter(adapter);

    }
}