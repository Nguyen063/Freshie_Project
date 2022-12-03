package com.phamvannguyen.freshie.login;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.phamvannguyen.freshie.rating.new_rating;
import com.phamvannguyen.freshie.rating.old_rating;

public class AdapterTablayoutLogin extends FragmentStateAdapter {
    public AdapterTablayoutLogin(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0:
                return new login();
            case 1:
                return new sign_up();
            default:
                return new login();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
