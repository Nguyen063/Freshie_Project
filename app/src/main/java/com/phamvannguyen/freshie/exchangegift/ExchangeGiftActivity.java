package com.phamvannguyen.freshie.exchangegift;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.phamvannguyen.freshie.MainActivity;
import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.databinding.ActivityExchangeGiftBinding;
import java.util.ArrayList;

public class ExchangeGiftActivity extends AppCompatActivity {

    ActivityExchangeGiftBinding binding;
    ExchangeGiftAdapter adapter;
    ArrayList<ExchangeGiftModel> exchangeGiftList;
    ExchangeGiftModel exchangeGiftModel;
    Button button;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  setContentView(R.layout.activity_gift_voucher);

        binding = ActivityExchangeGiftBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        back();

//        @Override
//        public boolean onOptionsItemSelected(MenuItem item) {
//            switch (item.getItemId())
//            {
//                case android.R.id.home:
//                    onBackPressed();
//                    return true;
//                default:break;
//
//            }
        loadData();
        addEvent();

    }


    public void back() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Điểm của tôi");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    private void addEvent() {
        binding.btnMyVoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExchangeGiftActivity.this, UserVoucherActivity.class);
                startActivity(intent);
                finish();
            }
        });
        binding.lvVoucher.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//             Click
                int b = exchangeGiftList.get(i).getVoucherPoint();
                int totalPoint = Integer.parseInt(binding.txtTotalPoint.getText().toString());
                if (b<=totalPoint){
                    totalPoint = totalPoint - b;
                    Dialog dialog = new Dialog(ExchangeGiftActivity.this);
                    dialog.setContentView(R.layout.dialog_exvoucher_success);
                    Button btnOk = dialog.findViewById(R.id.btn_Ok_ex_voucher);
                    btnOk.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                           dialog.dismiss();
                        }
                    });
                    dialog.show();
                    binding.txtTotalPoint.setText(String.valueOf(totalPoint));
                }
                else {
                    Toast.makeText(getApplicationContext(),"Bạn không đủ điểm để đổi điểm",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }


    private void loadData() {
        exchangeGiftList = new ArrayList<>();
        exchangeGiftList.add(new ExchangeGiftModel(R.drawable.vichy,"Giảm 100k",
                "Giảm tối đa 100K cho đơn từ 500K",
                "HSD: 31/12/2022", 100));
        exchangeGiftList.add(new ExchangeGiftModel(R.drawable.innisfree,"Giảm 30%",
                "Giảm 30% tối đa 100K cho đơn từ 600K",
                "HSD: 31/12/2022", 200));
        exchangeGiftList.add(new ExchangeGiftModel(R.drawable.senka,"Giảm 30k",
                "Giảm 30K cho đơn từ 500K",
                "HSD: 31/12/2022",300));
        exchangeGiftList.add(new ExchangeGiftModel(R.drawable.anessa,"Giảm 100k",
                "Giảm 50K cho đơn từ 500K",
                "HSD: 31/12/2022", 400));
        exchangeGiftList.add(new ExchangeGiftModel(R.drawable.anessa,"Giảm 100k",
                "Giảm 50K cho đơn từ 500K",
                "HSD: 31/12/2022", 500));

        adapter = new ExchangeGiftAdapter(this, R.layout.item_list_voucher, exchangeGiftList);
        binding.lvVoucher.setAdapter(adapter);

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

}