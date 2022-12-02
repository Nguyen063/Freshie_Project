package com.phamvannguyen.freshie.rating;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class RatingHistoryAdapter extends FragmentStateAdapter {
    public RatingHistoryAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0:
                return new new_rating();
            case 1:
                return new old_rating();
            default:
                return new new_rating();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
