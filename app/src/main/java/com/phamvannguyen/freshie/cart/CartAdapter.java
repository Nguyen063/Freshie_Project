package com.phamvannguyen.freshie.cart;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.phamvannguyen.freshie.DataBaseHelper;
import com.phamvannguyen.freshie.MainActivity;
import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.cache.cacheCart;
import com.phamvannguyen.freshie.databinding.FragmentCartBinding;
import com.phamvannguyen.freshie.exchangegift.ExchangeGiftAdapter;
import com.phamvannguyen.freshie.exchangegift.ExchangeGiftModel;
import com.phamvannguyen.freshie.models.Product;
import java.util.List;

public class CartAdapter extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<CartModel> cartList = CartFragment.cartList;
    int quantity = 0;
    double total = 0;
    DataBaseHelper db = MainActivity.db;

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
//                quantity = Integer.parseInt(holder.txtQuantity.getText().toString());
//                quantity++;
//                holder.txtQuantity.setText(String.valueOf(quantity));
//                cartModel.setQuantity(quantity);

                //Test cacheCart: Increase quantity of product in cart at position i
                //increase quantity of cartModel
                cartModel.setQuantity(cartModel.getQuantity() + 1);
                //update quantity of cartModel in cacheCart
                cacheCart.updateCart(cartModel);
                //update totalValue of all product in cart in cacheCart
                cacheCart.updateTotalValue();
                //update quantity of cartModel on View
                holder.txtQuantity.setText(String.valueOf(cartModel.getQuantity()));
                notifyDataSetChanged();

                //update totalValue of all product in cart on View
                TextView txtCartTotalPrice = activity.findViewById(R.id.txt_cart_totalPrice);
                db.updateCart(cartModel.getProductID(), cartModel.getQuantity());
                txtCartTotalPrice.setText(String.format("%,.0f ₫",countTotal()));
            }

        });
        holder.btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//               quantity = Integer.parseInt(holder.txtQuantity.getText().toString());
//                if (quantity > 1) {
//                    quantity--;
//                    holder.txtQuantity.setText(String.valueOf(quantity));
//                    cartModel.setQuantity(quantity);
//                }

                //Test cacheCart: Decrease quantity of product in cart at position i
                if (cartModel.getQuantity() > 1){
                    //decrease quantity of cartModel
                    cartModel.setQuantity(cartModel.getQuantity() - 1);
                    //update quantity of cartModel in cacheCart
                    cacheCart.updateCart(cartModel);
                    //update totalValue of all product in cart in cacheCart
                    cacheCart.updateTotalValue();
                    //update quantity of cartModel on View
                    holder.txtQuantity.setText(String.valueOf(cartModel.getQuantity()));
                    notifyDataSetChanged();

                    //update totalValue of all product in cart on View
                    TextView txtCartTotalPrice = activity.findViewById(R.id.txt_cart_totalPrice);
                    txtCartTotalPrice.setText(String.format("%,.0f ₫", countTotal()));
                    db.updateCart(cartModel.getProductID(), cartModel.getQuantity());
                }
                else {
                   cartList.remove(i);
                   cacheCart.removeCart(cartModel);
                   cacheCart.updateTotalValue();
                   notifyDataSetChanged();
                   db.deleteCart(cartModel.getProductID());
                   TextView txtCartTotalPrice = activity.findViewById(R.id.txt_cart_totalPrice);
                   txtCartTotalPrice.setText(String.format("%,.0f ₫", countTotal()));

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
    private double countTotal() {
        total = 0;
        for (int i = 0; i < cartList.size(); i++) {
            total += cartList.get(i).getQuantity() * cartList.get(i).getPrice();
        }
        return total;
    }
}


