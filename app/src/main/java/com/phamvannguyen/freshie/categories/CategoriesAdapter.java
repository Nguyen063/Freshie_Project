package com.phamvannguyen.freshie.categories;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;


public class CategoriesAdapter extends FragmentStateAdapter {

    public CategoriesAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
        @Override
        public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new hot_deal();
            case 1:
                return new skin_care();
            case 2:
                return new hair_care();
            case 3:
                return new make_up();
            default:
                return new hot_deal();
            }
        }

        @Override
        public int getItemCount() {
            return 4;
        }
    }
