package com.phamvannguyen.freshie.account;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.account.categoryrecycleview.CategoryRecyclerAdapter;
import com.phamvannguyen.freshie.account.categoryrecycleview.CategoryRecyclerView;
import com.phamvannguyen.freshie.account.itemrecycleview.ItemRecycler;
import com.phamvannguyen.freshie.customerservice.CustomerService;
import com.phamvannguyen.freshie.databinding.ActivityAccountBinding;
import com.phamvannguyen.freshie.exchangegift.ExchangeGiftActivity;
import com.phamvannguyen.freshie.login.LoginActivity;
import com.phamvannguyen.freshie.order.delivered;
import com.phamvannguyen.freshie.order.delivering;
import com.phamvannguyen.freshie.order.order;
import com.phamvannguyen.freshie.order.wait_confirm;
import com.phamvannguyen.freshie.rating.RatingHistory;
import com.phamvannguyen.freshie.watched.Watched;

import java.util.ArrayList;
import java.util.List;

public class AccountActivity extends AppCompatActivity {
    ActivityAccountBinding binding;
    private RecyclerView rcvCategoryRecyclerView;
    private CategoryRecyclerAdapter categoryRecyclerAdapter;
    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_account);
        rcvCategoryRecyclerView = findViewById(R.id.rcv_categoryRecyclerview);
        categoryRecyclerAdapter = new CategoryRecyclerAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rcvCategoryRecyclerView.setLayoutManager(linearLayoutManager);
        categoryRecyclerAdapter.setData(getListCategoryRecyclerView());
        rcvCategoryRecyclerView.setAdapter(categoryRecyclerAdapter);

        binding = ActivityAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvents();


    }

    private void addEvents() {
        binding.imageButtonEditProfile.setOnClickListener(v -> {
            Intent intent = new Intent(AccountActivity.this, EditProfile.class);
            startActivity(intent);
            finish();
        });
        binding.llVieworder.setOnClickListener(v -> {
            Intent intent = new Intent(AccountActivity.this, order.class);
            startActivity(intent);
            finish();
        });
        binding.btnWaitingconfirm.setOnClickListener(v -> {
            Intent intent = new Intent(AccountActivity.this, wait_confirm.class);
            startActivity(intent);
            finish();
        });
        binding.btnDelivering.setOnClickListener(v -> {
            Intent intent = new Intent(AccountActivity.this, delivering.class);
            startActivity(intent);
            finish();
        });
        binding.btnDelivered.setOnClickListener(v -> {
            Intent intent = new Intent(AccountActivity.this, delivered.class);
            startActivity(intent);
            finish();
        });
        binding.rcvCategoryRecyclerview.setOnClickListener(v -> {
            Intent intent = new Intent(AccountActivity.this, ExchangeGiftActivity.class);
            startActivity(intent);
            finish();
        });
        binding.llViewProduct.setOnClickListener(v -> {
            Intent intent = new Intent(AccountActivity.this, Watched.class);
            startActivity(intent);
        });
        binding.llMyrating.setOnClickListener(v -> {
            Intent intent = new Intent(AccountActivity.this, RatingHistory.class);
            startActivity(intent);
        });
        binding.llSettingprofile.setOnClickListener(v -> {
            Intent intent = new Intent(AccountActivity.this, ChangePassword.class);
            startActivity(intent);
        });
        binding.llHelpcenter.setOnClickListener(v -> {
            Intent intent = new Intent(AccountActivity.this, CustomerService.class);
            startActivity(intent);
            finish();
        });
        binding.llLogOut.setOnClickListener(v -> {
            Intent intent = new Intent(AccountActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });


    }

    private List<CategoryRecyclerView> getListCategoryRecyclerView(){
        List<CategoryRecyclerView> listCategoryRecyclerView = new ArrayList<>();

        List<ItemRecycler> listItemRecycler = new ArrayList<>();
        listItemRecycler.add(new ItemRecycler(R.drawable.vichy, "Giảm 100K"));
        listItemRecycler.add(new ItemRecycler(R.drawable.innisfree, "Giảm 30%"));
        listItemRecycler.add(new ItemRecycler(R.drawable.senka, "Giảm 30K"));
        listItemRecycler.add(new ItemRecycler(R.drawable.vichy, "Giảm 100K"));

        listItemRecycler.add(new ItemRecycler(R.drawable.vichy, "Giảm 100K"));
        listItemRecycler.add(new ItemRecycler(R.drawable.innisfree, "Giảm 30%"));
        listItemRecycler.add(new ItemRecycler(R.drawable.senka, "Giảm 30K"));
        listItemRecycler.add(new ItemRecycler(R.drawable.vichy, "Giảm 100K"));


        listCategoryRecyclerView.add(new CategoryRecyclerView("Mã giảm giá", listItemRecycler));


        return listCategoryRecyclerView;
    }
}