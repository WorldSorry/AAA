package com.example.rog.myapplication.ui;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.example.rog.myapplication.App;
import com.example.rog.myapplication.R;
import com.example.rog.myapplication.presenter.RegisterPersenter;
import com.example.rog.myapplication.ui.view.IRegisterView;
import com.tencent.qcloud.tlslibrary.service.PhonePwdRegisterService.PwdRegListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tencent.tls.platform.TLSAccountHelper;

public class RegisterActivity extends AppCompatActivity implements IRegisterView {

    @BindView(R.id.email)
    AutoCompleteTextView email;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.email_sign_in_button)
    Button emailSignInButton;
    private RegisterPersenter registerPersenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        registerPersenter = new RegisterPersenter(this);
    }
    @OnClick(R.id.email_sign_in_button)
    public void onClick() {
        registerPersenter.register();
    }

    @Override
    public String getUserName() {
        return email.getText().toString();
    }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }

    @Override
    public void exitActivity() {
        finish();
    }
}
