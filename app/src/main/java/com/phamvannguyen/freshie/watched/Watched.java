package com.phamvannguyen.freshie.watched;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import com.phamvannguyen.freshie.DataBaseHelper;
import com.phamvannguyen.freshie.MainActivity;
import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.databinding.ActivityWatchedBinding;
import com.phamvannguyen.freshie.databinding.FragmentCategoryBinding;
import com.phamvannguyen.freshie.models.Product;

import java.util.ArrayList;

public class Watched extends AppCompatActivity {

    private View view;
    private GridView gridView;
    static ArrayList<Product> products;

    ActivityWatchedBinding binding;
    private DataBaseHelper db = MainActivity.db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_watched);

        binding = ActivityWatchedBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        setContentView(view);

        gridView = (GridView) view.findViewById(R.id.gv_ListProduct);
        products = new ArrayList<Product>();

        loadGridview();
    }

    private void loadGridview() {

    }
}