package com.example.ducpv.haneldemo.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import com.example.ducpv.haneldemo.R;
import com.example.ducpv.haneldemo.utils.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ducpv on 12/8/17.
 */

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.edt_user_name)
    EditText edtUserName;
    @BindView(R.id.edt_password)
    EditText edtPassword;
    @BindView(R.id.layout_user_name)
    TextInputLayout layoutUserName;
    @BindView(R.id.layout_password)
    TextInputLayout layoutPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;

    private TextWatcher userNameChangedListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (!TextUtils.isEmpty(s)) {
                layoutUserName.setError(null);
            }
        }
    };

    private TextWatcher passwordChangedListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (!TextUtils.isEmpty(s)) {
                layoutPassword.setError(null);
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        edtUserName.addTextChangedListener(userNameChangedListener);
        edtPassword.addTextChangedListener(passwordChangedListener);
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        if (checkDataValid()) {
            doLogin();
        }
    }

    private boolean checkDataValid() {
        boolean check = true;
        if (TextUtils.isEmpty(edtUserName.getText().toString())) {
            layoutUserName.setError("Vui lòng nhập tên đăng nhập");
            check = false;
        }

        if (TextUtils.isEmpty(edtPassword.getText().toString())) {
            layoutPassword.setError("Vuing lòng nhập mật khẩu");
            check = false;
        }

        return check;
    }

    private void doLogin() {
        SharedPreferences sharedPreferences = getSharedPreferences(Constant.HANEL_PREFRENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constant.USER_NAME, edtUserName.getText().toString());
        editor.putBoolean(Constant.LOGIN_FLAG, true);
        editor.commit();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
