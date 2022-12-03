package com.phamvannguyen.freshie.rating;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class RatingHistoryAdapter extends FragmentStateAdapter {


    public RatingHistoryAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new NotRatingFragment();
            case 1:
                return new OldRatingFragment();
        default:
            return new NotRatingFragment();
        }

    }
}
