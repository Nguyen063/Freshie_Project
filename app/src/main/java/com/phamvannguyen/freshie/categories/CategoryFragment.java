package com.phamvannguyen.freshie.categories;

import static com.phamvannguyen.freshie.MainActivity.sendToProductDetail;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.phamvannguyen.freshie.DataBaseHelper;
import com.phamvannguyen.freshie.MainActivity;
import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.databinding.FragmentCategoryBinding;
import com.phamvannguyen.freshie.models.Product;
import com.phamvannguyen.freshie.product.ListProductActivity;
import com.phamvannguyen.freshie.product.ProductDetailActivity;

import java.util.ArrayList;


public class CategoryFragment extends Fragment {


   private View view;

    FragmentCategoryBinding binding;
    ArrayList<Integer> categories = new ArrayList<Integer>(){
        {
            add(R.id.txt_skincare);
            add(R.id.txt_makeup);
            add(R.id.txt_haircare);
            add(R.id.txt_perfume);
        }
    };
ArrayList<Integer> brands = new ArrayList<Integer>(){
    {
        add(R.id.txt_Anessa);
        add(R.id.txt_innisfree);
        add(R.id.txt_LaRochePosay);
        add(R.id.txt_loreal);
        add(R.id.txt_maybelline);
        add(R.id.txt_sunplay);
        add(R.id.txt_senka);
        add(R.id.txt_bbia);
        add(R.id.txt_milaganics);
        add(R.id.txt_clear);
        add(R.id.txt_dove);
        add(R.id.txt_xmen);
        add(R.id.txt_tresemme);
        add(R.id.txt_charme);
        add(R.id.txt_versace);
    }};

    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        view = inflater.inflate(R.layout.fragment_category, cntainer, false);

        binding = FragmentCategoryBinding.inflate(inflater, container, false);
        view = binding.getRoot();

        addEvents();

        return view;

    }

    private void addEvents() {
        for (int i = 0; i < categories.size(); i++) {
            TextView txt = view.findViewById(categories.get(i));
            txt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intentToProduct(ListProductActivity.INTENT_CATEGORY, txt.getText().toString());
                }
            });
        }
        for (int i = 0; i < brands.size(); i++) {
            TextView txt = view.findViewById(brands.get(i));
            txt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intentToProduct(ListProductActivity.INTENT_BRAND, txt.getText().toString());
                }
            });
        }


    }
    public void intentToProduct(String name, String value){
        Intent intent = new Intent(getActivity(), ListProductActivity.class);
        intent.putExtra(name, value);
        startActivity(intent);
    }

}