package com.phamvannguyen.freshie.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.phamvannguyen.freshie.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.Holder> {

    int[] images;

    public SliderAdapter() {
    }

    public SliderAdapter(int[] images) {
        this.images = images;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_photo, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder viewHolder, int position) {
        viewHolder.slidephoto.setImageResource(images[position]);
    }

    @Override
    public int getCount() {
        return images.length;
    }

    public class Holder extends ViewHolder {
        ImageButton slidephoto;

        public Holder(View itemView) {
            super(itemView);
            slidephoto = itemView.findViewById(R.id.slide_photo);
        }
    }
}
