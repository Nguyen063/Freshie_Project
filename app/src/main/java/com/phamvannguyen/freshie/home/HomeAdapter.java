package com.phamvannguyen.freshie.home;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.phamvannguyen.freshie.cart.CartFragment;
import com.phamvannguyen.freshie.categories.CategoryFragment;
import com.phamvannguyen.freshie.notifications.NotificationsFragment;

public class HomeAdapter extends FragmentStatePagerAdapter {
    public HomeAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }
    @NonNull
    @Override
    public  Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new NotificationsFragment();
            case 2:
                return new CategoryFragment();
            case 3:
                return new CartFragment();
            default:
                return new HomeFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return super.getItemPosition(object);
    }
}
