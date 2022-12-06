package com.phamvannguyen.freshie.cart;

import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.phamvannguyen.freshie.MainActivity;
import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.databinding.FragmentCartBinding;
import com.phamvannguyen.freshie.models.Product;
import com.phamvannguyen.freshie.payment.Checkout;

import java.util.ArrayList;

public class CartFragment extends Fragment {
    private View view;
    FragmentCartBinding binding;
    CartAdapter adapter;
    ArrayList<CartModel> cartList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        view = inflater.inflate(R.layout.fragment_category, container, false);

        binding = FragmentCartBinding.inflate(inflater, container, false);
        view = binding.getRoot();
        loadData();
        addEvents();
        return view;
    }

    private void addEvents() {
        binding.btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(.this, Checkout.class);
//                startActivity(intent);
            }
        });
    }

    private void loadData() {
        cartList = new ArrayList<>();
        cartList.add(new CartModel(R.drawable.vitamintree,
                "Kem dưỡng da Vitamin Tree Water-Gel",
                350000.0, 1));
        cartList.add(new CartModel(R.drawable.banobagi_cart,
                "Mặt nạ BNBG Whitening Stem Cell Collagen",
                180000.0, 1));
        cartList.add(new CartModel(R.drawable.vichymineral89,
                "Dưỡng chất cô đặc Vichy Mineral 89 – 75ml",
                980000.0, 1));
        cartList.add(new CartModel(R.drawable.serumlancome,
                "Tinh Chất Hỗ Trợ Dưỡng Ẩm & Trẻ Hóa Da Lancôme 100ml",
                990000.0, 1));
        cartList.add(new CartModel(R.drawable.tonerklairs,
                "Nước Hoa Hồng Klairs Không Mùi Cho Da Nhạy Cảm 180ml",
                245000.0, 1));
        cartList.add(new CartModel(R.drawable.lotionlancome,
                "Nước Hoa Hồng Lancome Tonique Confort Toner 125ml",
                570000.0, 1));
        cartList.add(new CartModel(R.drawable.esteelauder,
                "Kem Dưỡng Phục Hồi Da Vùng Mắt Estée Lauder 15ml",
                860000.0, 1));
        cartList.add(new CartModel(R.drawable.goohndoc,
                "Serum dưỡng mờ thâm GoodnDoc Hydra B5 75ml",
                680000.0, 1));
        cartList.add(new CartModel(R.drawable.pair,
                "Kem Hỗ Trợ Cải Thiện Mụn Pair Nhật Bản 14g",
                125000.0, 1));
        cartList.add(new CartModel(R.drawable.tonerkiehls,
                "Nước Cân Bằng Hoa Cúc Kiehl’s 500ml",
                880000.0, 1));

//        adapter = new CartAdapter(this, R.layout.item_list_product_cart, cartList);
        binding.lvProductCart.setAdapter(adapter);

    }
}
