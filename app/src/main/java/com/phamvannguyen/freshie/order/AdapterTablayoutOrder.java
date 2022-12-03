package com.phamvannguyen.freshie.order;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.phamvannguyen.freshie.login.login;
import com.phamvannguyen.freshie.login.sign_up;

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
                return new login();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
