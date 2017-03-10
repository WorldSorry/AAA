package com.example.rog.myapplication.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.rog.myapplication.R;
import com.example.rog.myapplication.presenter.Register2Persenter;
import com.example.rog.myapplication.ui.view.IRegister2View;
import com.example.rog.myapplication.utils.Util;
import com.tencent.qcloud.tlslibrary.customview.EditTextWithClearButton;
import com.tencent.qcloud.tlslibrary.customview.EditTextWithListPopupWindow;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Register2Activity extends AppCompatActivity implements IRegister2View {

    @BindView(R.id.returnHostLoginActivity)
    ImageButton returnHostLoginActivity;
    @BindView(R.id.selectCountryCode_hostRegister)
    EditTextWithListPopupWindow selectCountryCodeHostRegister;
    @BindView(R.id.phoneNumber_hostRegister)
    EditTextWithClearButton phoneNumberHostRegister;
    @BindView(R.id.btn_requireCheckCode_hostRegister)
    Button btnRequireCheckCodeHostRegister;
    @BindView(R.id.btn_hostRegister)
    Button btnHostRegister;
    @BindView(R.id.checkCode_hostRegister)
    EditText checkCodeHostRegister;
    private Register2Persenter persenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        ButterKnife.bind(this);
        persenter = new Register2Persenter(this);
    }


    @OnClick({R.id.returnHostLoginActivity, R.id.btn_requireCheckCode_hostRegister, R.id.btn_hostRegister})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.returnHostLoginActivity:
                break;
            case R.id.btn_requireCheckCode_hostRegister:
                //获取验证码
                persenter.sendCode();
                break;
            case R.id.btn_hostRegister:

                persenter.verifyCode();
                break;
        }
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumberHostRegister.getText().toString();
    }

    @Override
    public String getVerNum() {
        return checkCodeHostRegister.getText().toString();
    }

    @Override
    public void startTime(int i) {
        Util.startTimer(btnRequireCheckCodeHostRegister,"获取验证码","重新获取",i,1);
    }
}
