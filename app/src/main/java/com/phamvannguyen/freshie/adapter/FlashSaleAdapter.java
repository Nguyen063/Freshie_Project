package com.phamvannguyen.freshie.adapter;

import static java.lang.String.valueOf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.phamvannguyen.freshie.MainActivity;
import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.models.Product;
import com.phamvannguyen.freshie.payment.Checkout;
import com.phamvannguyen.freshie.product.ProductDetailActivity;

import java.io.Serializable;
import java.util.List;

public class FlashSaleAdapter extends BaseAdapter {

    Activity activity;
    int item_Layout;
    List<Product> flashSaleList;

    public FlashSaleAdapter(Activity activity, int item_Layout, List<Product> flashSaleList) {
        this.activity = activity;
        this.item_Layout = item_Layout;
        this.flashSaleList = flashSaleList;
    }

    @Override
    public int getCount() {
        return flashSaleList.size();
    }

    @Override
    public Object getItem(int i) {
        return flashSaleList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(this.item_Layout,null);
            holder.productThumbnail = view.findViewById(R.id.img_productFlashSale);
            holder.productName = view.findViewById(R.id.txt_productNameFlashSale);
            holder.productPrice = view.findViewById(R.id.txt_productPriceFlashSale);
            holder.productDiscount = view.findViewById(R.id.txt_productDiscountFlashSale);
            holder.ratingValue = view.findViewById(R.id.txt_ratingValueFlashSale);
            holder.ratingCount = view.findViewById(R.id.txt_ratingCountFlashSale);
            holder.soldCount = view.findViewById(R.id.txt_soldCountFlashSale);
            holder.btnbuyNow = view.findViewById(R.id.btn_buyNow);
            holder.llFlashSale = view.findViewById(R.id.ll_flashsale);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }

        Product flashSale = flashSaleList.get(i);
        new MainActivity.FetchImage(flashSale.getThumbUrl(),holder.productThumbnail).start();
//        holder.productThumbnail.setImageBitmap(BitmapFactory.decodeByteArray(flashSale.getImage(),0,flashSale.getImage().length));
        holder.productName.setText(flashSale.getProductName());
        holder.productPrice.setText(toString().valueOf(flashSale.getFormattedPrice()));
        holder.productDiscount.setText( flashSale.getFormattedDiscount());
        holder.ratingValue.setText(toString().valueOf(flashSale.getRatingAverage()));
        holder.ratingCount.setText("(" + flashSale.getRatingCount() + ")");
        holder.soldCount.setText(flashSale.getSold() + " đã bán");

        holder.btnbuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b = new Bundle();
                b.putParcelable(Checkout.INTENT_PRODUCT, flashSale);
                Intent intent = new Intent(activity, Checkout.class);
                intent.putExtras(b);
                activity.startActivity(intent);
            }
        });

        holder.llFlashSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b = new Bundle();
                b.putParcelable(ProductDetailActivity.INTENT_PRODUCT, flashSale);
                Intent intent = new Intent();
                intent.setClass(activity, ProductDetailActivity.class);
                intent.putExtras(b);
                activity.startActivity(intent);
            }
        });

        return view;
    }

    public static class ViewHolder {
        ImageView productThumbnail;
        TextView productName, productPrice, productDiscount, ratingValue, ratingCount, soldCount;
        Button btnbuyNow;
        LinearLayout llFlashSale;
    }
}
