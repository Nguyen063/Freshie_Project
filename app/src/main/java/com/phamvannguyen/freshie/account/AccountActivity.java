package com.phamvannguyen.freshie.account;

import static com.phamvannguyen.freshie.MainActivity.viewPager;
import static com.phamvannguyen.freshie.MainActivity.viewPager2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.phamvannguyen.freshie.MainActivity;
import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.account.categoryrecycleview.CategoryRecyclerAdapter;
import com.phamvannguyen.freshie.account.categoryrecycleview.CategoryRecyclerView;
import com.phamvannguyen.freshie.account.itemrecycleview.ItemRecycler;
import com.phamvannguyen.freshie.cart.CartFragment;
import com.phamvannguyen.freshie.customerservice.CustomerService;
import com.phamvannguyen.freshie.databinding.ActivityAccountBinding;
import com.phamvannguyen.freshie.exchangegift.ExchangeGiftActivity;
import com.phamvannguyen.freshie.login.ChangePassword;
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

    public static final String INTENT_NAME = "AccountFragment";
    public static final String INTENT_CART = "Cart";
    public static final String INTENT_CUSTOMER_SERVICE = "CustomerService";
    public static final String INTENT_SETTING = "Setting";
    public static final String INTENT_ORDERS = "Orders";
    public static final String INTENT_WAITING_CONFIRM = "WaitingConfirm";
    public static final String INTENT_DELIVERING = "Delivering";
    public static final String INTENT_DELIVERED = "Delivered";
    public static final String INTENT_CANCELLED = "Cancelled";
    public static final String INTENT_VOUCHER = "Voucher";
    public static final String INTENT_REBUY = "Rebuy";
    public static final String INTENT_WATCHED = "Watched";
    public static final String INTENT_RATING = "Rating";
    public static final String INTENT_LOGOUT = "Logout";


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

//        rcvCategoryRecyclerView.setLayoutManager(linearLayoutManager);
//        categoryRecyclerAdapter.setData(getListCategoryRecyclerView());
//        rcvCategoryRecyclerView.setAdapter(categoryRecyclerAdapter);

        binding = ActivityAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvents();
        listenEvents();
        back();

    }

    private void listenEvents() {


    }

    private void back() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Tài khoản của bạn");
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

//        binding.btnCart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(AccountActivity.this, MainActivity.class);
//                intent.putExtra(INTENT_NAME, INTENT_CART);
//                startActivity(intent);
//            }
//        });

//        binding.btnChatting.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(AccountActivity.this, CustomerService.class);
//                intent.putExtra(INTENT_NAME, INTENT_CUSTOMER_SERVICE);
//                startActivity(intent);
//            }
//        });

        binding.imageButtonEditProfile.setOnClickListener(v -> {
            Intent intent = new Intent(AccountActivity.this, EditProfile.class);
            startActivity(intent);
        });
        binding.llVieworder.setOnClickListener(v -> {
            Intent intent = new Intent(AccountActivity.this, order.class);
            startActivity(intent);
        });
        binding.btnWaitingconfirm.setOnClickListener(v -> {
            Intent intent = new Intent(AccountActivity.this, order.class);
            intent.putExtra(INTENT_NAME, INTENT_WAITING_CONFIRM);
            startActivity(intent);
        });
        binding.btnDelivering.setOnClickListener(v -> {
            Intent intent = new Intent(AccountActivity.this, order.class);
//            intent.putExtra(INTENT_NAME, INTENT_DELIVERING);
            startActivity(intent);
        });
        binding.btnDelivered.setOnClickListener(v -> {
            Intent intent = new Intent(AccountActivity.this, order.class);
            intent.putExtra(INTENT_NAME, INTENT_DELIVERED);
            startActivity(intent);
        });
        binding.rcvCategoryRecyclerview.setOnClickListener(v -> {
            Intent intent = new Intent(AccountActivity.this, ExchangeGiftActivity.class);
            startActivity(intent);
        });
        binding.llViewedProduct.setOnClickListener(v -> {
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
        });
        binding.llLogOut.setOnClickListener(v -> {
            Intent intent = new Intent(AccountActivity.this, LoginActivity.class);
            startActivity(intent);
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