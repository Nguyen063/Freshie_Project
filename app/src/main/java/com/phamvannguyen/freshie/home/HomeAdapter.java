package com.phamvannguyen.freshie.home;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.phamvannguyen.freshie.account.AccountFragment;
import com.phamvannguyen.freshie.cart.CartFragment;
import com.phamvannguyen.freshie.notifications.NotificationsFragment;
import com.phamvannguyen.freshie.recommend.RecommendFragment;

public class HomeAdapter extends FragmentStatePagerAdapter {
    public HomeAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new RecommendFragment();
            case 1:
                return new HomeFragment();
            case 2:
                return new NotificationsFragment();
            case 3:
                return new CartFragment();
            case 4:
                return new AccountFragment();
            default:
                return new HomeFragment();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }

}
