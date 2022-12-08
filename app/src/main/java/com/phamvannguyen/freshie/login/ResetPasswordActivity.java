package com.phamvannguyen.freshie.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.phamvannguyen.freshie.R;
import com.phamvannguyen.freshie.databinding.ActivityResetPasswordBinding;

public class ResetPasswordActivity extends AppCompatActivity {

    EditText txt_one, txt_two, txt_three,txt_four, txt_five, txt_six;
    Button btn_input;
    ActivityResetPasswordBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_reset_password);
        binding = ActivityResetPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        openOTPDialog();
        resetPassword();
    }



    private void openOTPDialog() {
        Dialog dialog = new Dialog(ResetPasswordActivity.this);
        dialog.setContentView(R.layout.dialog_otp);
        txt_one = dialog.findViewById(R.id.otp_edit_box1);
        txt_two = dialog.findViewById(R.id.otp_edit_box2);
        txt_three = dialog.findViewById(R.id.otp_edit_box3);
        txt_four = dialog.findViewById(R.id.otp_edit_box4);
        txt_five = dialog.findViewById(R.id.otp_edit_box5);
        txt_six = dialog.findViewById(R.id.otp_edit_box6);
        btn_input = dialog.findViewById(R.id.btn_Verify);


        txt_one.addTextChangedListener(new GenericTextWatcher(txt_one, new EditText[]{txt_one, txt_two, txt_three, txt_four, txt_five, txt_six}));
        txt_two.addTextChangedListener(new GenericTextWatcher(txt_two, new EditText[]{txt_one, txt_two, txt_three, txt_four, txt_five, txt_six}));
        txt_three.addTextChangedListener(new GenericTextWatcher(txt_three, new EditText[]{txt_one, txt_two, txt_three, txt_four, txt_five, txt_six}));
        txt_four.addTextChangedListener(new GenericTextWatcher(txt_four, new EditText[]{txt_one, txt_two, txt_three, txt_four, txt_five, txt_six}));
        txt_five.addTextChangedListener(new GenericTextWatcher(txt_five, new EditText[]{txt_one, txt_two, txt_three, txt_four, txt_five, txt_six}));
        txt_six.addTextChangedListener(new GenericTextWatcher(txt_six, new EditText[]{txt_one, txt_two, txt_three, txt_four, txt_five, txt_six}));
        btn_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }
    private void resetPassword() {
        binding.btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = binding.edtPassword.getText().toString();
                String confirmPassword = binding.edtConfirmPassword.getText().toString();
                if (password.isEmpty()) {
                    binding.edtPassword.setError("Password is required");
                    binding.edtPassword.requestFocus();
                    return;
                }
                if (confirmPassword.isEmpty()) {
                    binding.edtConfirmPassword.setError("Confirm Password is required");
                    binding.edtConfirmPassword.requestFocus();
                    return;
                }
                if (!password.equals(confirmPassword)) {
                    binding.edtConfirmPassword.setError("Password not match");
                    binding.edtConfirmPassword.requestFocus();
                    return;
                }

                   Intent intent = new Intent(ResetPasswordActivity.this, LoginActivity.class);
                   startActivity(intent);

            }
        });

    }
}