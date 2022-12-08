package com.phamvannguyen.freshie.order;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class AdapterTablayoutOrder extends FragmentStateAdapter {
    public AdapterTablayoutOrder(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new wait_confirm();
            case 1:
                return new delivering();
            case 2:
                return new delivered();
            case 3:
                return new cancelled();
            default:
                return new wait_confirm();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

}
