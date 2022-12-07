package com.phamvannguyen.freshie.cart;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.phamvannguyen.freshie.MainActivity;
import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.exchangegift.ExchangeGiftAdapter;
import com.phamvannguyen.freshie.exchangegift.ExchangeGiftModel;
import com.phamvannguyen.freshie.models.Product;
import java.util.List;

public class CartAdapter extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<CartModel> cartList;
    int quantity = 0;


    public CartAdapter(Activity activity, int item_layout, List<CartModel> cartList) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.cartList = cartList;
    }

    @Override
    public int getCount() {
        return cartList.size();
    }

    @Override
    public Object getItem(int i) {
        return cartList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);
            // Link views
            holder.imvCartProduct = view.findViewById(R.id.imv_cartImage);
            holder.txtCartproductName = view.findViewById(R.id.txt_cart_productName);
            holder.txtCartproductPrice = view.findViewById(R.id.txt_cart_productPrice);
            holder.txtQuantity = view.findViewById(R.id.txt_quantity);
            holder.btnInc = view.findViewById(R.id.btn_inc);
            holder.btnDec = view.findViewById(R.id.btn_dec);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        CartModel cartModel = cartList.get(i);
        new MainActivity.FetchImage(cartModel.getThumbUrl(),holder.imvCartProduct).start();
        holder.txtCartproductName.setText(cartModel.getProductName());
        holder.txtCartproductPrice.setText(String.valueOf(cartModel.getFormattedPrice()));
        holder.txtQuantity.setText(String.valueOf(cartModel.getQuantity()));
        holder.btnInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity = Integer.parseInt(holder.txtQuantity.getText().toString());
                quantity++;
                holder.txtQuantity.setText(String.valueOf(quantity));
                cartModel.setQuantity(quantity);

            }
        });
        holder.btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               quantity = Integer.parseInt(holder.txtQuantity.getText().toString());
                if (quantity > 1) {
                    quantity--;
                    holder.txtQuantity.setText(String.valueOf(quantity));
                    cartModel.setQuantity(quantity);
                    Toast.makeText(activity, String.valueOf(cartModel.getQuantity()), Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }


    private static class ViewHolder {
        ImageView imvCartProduct;
        TextView txtCartproductName, txtCartproductPrice, txtQuantity;
        Button btnInc, btnDec;

    }


    public interface OnClickListener {
        void onIncClick(View view, int position);
        void onDecClick(View view, int position);
    }
}


