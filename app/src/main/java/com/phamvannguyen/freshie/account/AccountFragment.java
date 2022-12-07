package com.phamvannguyen.freshie.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.phamvannguyen.freshie.cart.CartFragment;
import com.phamvannguyen.freshie.customerservice.CustomerService;
import com.phamvannguyen.freshie.databinding.FragmentAccountBinding;
import com.phamvannguyen.freshie.exchangegift.UserVoucherActivity;
import com.phamvannguyen.freshie.login.LoginActivity;
import com.phamvannguyen.freshie.order.cancelled;
import com.phamvannguyen.freshie.order.delivered;
import com.phamvannguyen.freshie.order.delivering;
import com.phamvannguyen.freshie.order.order;
import com.phamvannguyen.freshie.order.wait_confirm;
import com.phamvannguyen.freshie.rating.RatingHistory;
import com.phamvannguyen.freshie.watched.Watched;

public class AccountFragment extends Fragment {

    FragmentAccountBinding binding;

    public static final String INTENT_NAME = "AccountFragment";
    public static final String INTENT_CART = "Cart";
    public static final String INTENT_CUSTOMER_SERVICE = "CustomerService";
    public static final String INTENT_SETTING = "Setting";
    public static final String INTENT_ORDERS = "Orders";
    public static final String INTENT_WAITING_CONFIRM = "WaitingConfirm";
    public static final String INTENT_DELIVERING = "Delivering";
    public static final String INTENT_DELIVERED = "Delivered";
    public static final String INTENT_CANCELLED = "Cancelled";
    public static final String INTENT_VOUCHER = "Voucher";
    public static final String INTENT_REBUY = "Rebuy";
    public static final String INTENT_WATCHED = "Watched";
    public static final String INTENT_RATING = "Rating";
    public static final String INTENT_LOGOUT = "Logout";


    public AccountFragment(){

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAccountBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        listenEvents();
        return view;
    }

    private void listenEvents() {

        binding.btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CartFragment.class);
                intent.putExtra(INTENT_NAME, INTENT_CART);
                startActivity(intent);
            }
        });
//        binding.btnCart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), CartActivity.class);
//                intent.putExtra(INTENT_NAME, INTENT_CART);
//                startActivity(intent);
//            }
//        });

        binding.btnChatting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CustomerService.class);
                intent.putExtra(INTENT_NAME, INTENT_CUSTOMER_SERVICE);
                startActivity(intent);
            }
        });

        binding.btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EditProfile.class);
                intent.putExtra(INTENT_NAME, INTENT_SETTING);
                startActivity(intent);
            }
        });

        binding.txtVieworder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), order.class);
                intent.putExtra(INTENT_NAME, INTENT_ORDERS);
                startActivity(intent);
            }
        });

        binding.btnWaitingconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), wait_confirm.class);
                intent.putExtra(INTENT_NAME, INTENT_WAITING_CONFIRM);
                startActivity(intent);
            }
        });
        binding.btnDelivering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), delivering.class);
                intent.putExtra(INTENT_NAME, INTENT_DELIVERING);
                startActivity(intent);
            }
        });
        binding.btnDelivered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), delivered.class);
                intent.putExtra(INTENT_NAME, INTENT_DELIVERED);
                startActivity(intent);
            }
        });
        binding.btnCanceled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), cancelled.class);
                intent.putExtra(INTENT_NAME, INTENT_CANCELLED);
                startActivity(intent);
            }
        });
        binding.txtViewvoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UserVoucherActivity.class);
                intent.putExtra(INTENT_NAME, INTENT_VOUCHER);
                startActivity(intent);
            }
        });
        binding.txtViewBuyedProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), delivered.class);
                intent.putExtra(INTENT_NAME, INTENT_REBUY);
                startActivity(intent);
            }
        });
        binding.llViewedProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Watched.class);
                intent.putExtra(INTENT_NAME, INTENT_WATCHED);
                startActivity(intent);
            }
        });
        binding.llMyrating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RatingHistory.class);
                intent.putExtra(INTENT_NAME, INTENT_RATING);
                startActivity(intent);
            }
        });
        binding.llSettingprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EditProfile.class);
                intent.putExtra(INTENT_NAME, INTENT_SETTING);
                startActivity(intent);
            }
        });
        binding.llHelpcenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CustomerService.class);
                intent.putExtra(INTENT_NAME, INTENT_CUSTOMER_SERVICE);
                startActivity(intent);
            }
        });
        binding.llLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                intent.putExtra(INTENT_NAME, INTENT_LOGOUT);
                startActivity(intent);
            }
        });

    }
}