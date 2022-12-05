package com.phamvannguyen.freshie.payment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.databinding.ActivityPaymentMethodBinding;

public class PaymentMethod extends AppCompatActivity {

    ActivityPaymentMethodBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_payment_method);
        binding = ActivityPaymentMethodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvents();
    }

    private void addEvents() {
        binding.btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String paymentMethod = null;

                if(binding.radCash.isChecked()){
                    paymentMethod = binding.radCash.getText().toString();
                }
                else if (binding.radZaloPay.isChecked()){
                    paymentMethod = binding.radZaloPay.getText().toString();
                }
                else if (binding.radMomo.isChecked()){
                    paymentMethod = binding.radMomo.getText().toString();
                }
                else if (binding.radATM.isChecked()){
                    paymentMethod = binding.radATM.getText().toString();
                }

                if(paymentMethod != null){
                    Intent intent = new Intent(PaymentMethod.this, Checkout.class);
                    intent.putExtra("paymentMethod", paymentMethod);
                    startActivity(intent);
                }
            }
        });
    }
}