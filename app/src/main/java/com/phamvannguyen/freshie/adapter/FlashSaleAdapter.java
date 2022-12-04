package com.phamvannguyen.freshie.adapter;

import static java.lang.String.valueOf;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.models.FlashSales;

import java.util.List;

public class FlashSaleAdapter extends BaseAdapter {

    Activity activity;
    int item_Layout;
    List<FlashSales> flashSaleList;

    public FlashSaleAdapter(Activity activity, int item_Layout, List<FlashSales> flashSaleList) {
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
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }

        FlashSales flashSale = flashSaleList.get(i);
        holder.productThumbnail.setImageResource(flashSale.getProductThumbnail());
        holder.productName.setText(flashSale.getProductName());
        holder.productPrice.setText(toString().valueOf(flashSale.getProductPrice()));
        holder.productDiscount.setText("-" + flashSale.getProductDiscount() + "%");
        holder.ratingValue.setText(toString().valueOf(flashSale.getRatingValue()));
        holder.ratingCount.setText("(" + flashSale.getRatingCount() + ")");
        holder.soldCount.setText(flashSale.getSoldCount() + " đã bán");

        return view;
    }

    public static class ViewHolder {
        ImageView productThumbnail;
        TextView productName, productPrice, productDiscount, ratingValue, ratingCount, soldCount;
    }
}
