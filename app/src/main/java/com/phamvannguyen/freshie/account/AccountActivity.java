package com.phamvannguyen.freshie.account;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.account.categoryrecycleview.CategoryRecyclerAdapter;
import com.phamvannguyen.freshie.account.categoryrecycleview.CategoryRecyclerView;
import com.phamvannguyen.freshie.account.itemrecycleview.ItemRecycler;
import com.phamvannguyen.freshie.databinding.ActivityAccountBinding;

import java.util.ArrayList;
import java.util.List;

public class AccountActivity extends AppCompatActivity {
    private RecyclerView rcvCategoryRecyclerView;
    private CategoryRecyclerAdapter categoryRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        rcvCategoryRecyclerView = findViewById(R.id.rcv_categoryRecyclerview);
        categoryRecyclerAdapter = new CategoryRecyclerAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rcvCategoryRecyclerView.setLayoutManager(linearLayoutManager);
        categoryRecyclerAdapter.setData(getListCategoryRecyclerView());
        rcvCategoryRecyclerView.setAdapter(categoryRecyclerAdapter);

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