package com.example.rog.myapplication.presenter;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.rog.myapplication.ui.RegisterActivity;
import com.example.rog.myapplication.ui.view.IRegister2View;
import com.example.rog.myapplication.utils.ToastUtils;
import com.tencent.qcloud.tlslibrary.helper.Util;

import tencent.tls.platform.TLSAccountHelper;
import tencent.tls.platform.TLSErrInfo;
import tencent.tls.platform.TLSPwdRegListener;
import tencent.tls.platform.TLSUserInfo;

/**
 * Created by ROG on 2017/3/9.
 */

public class Register2Persenter {
    int type=0;

    IRegister2View register2View;
    TLSAccountHelper accountHelper;
    PwdRegListener pwdRegListener;
    Context context;
    public Register2Persenter(IRegister2View register2View) {
        this.register2View = register2View;
        accountHelper = TLSAccountHelper.getInstance();
        pwdRegListener=new PwdRegListener();
        context= (Context) register2View;
    }

    public void sendCode() {
        type=1;
        String phoneNumber = register2View.getPhoneNumber();
        accountHelper.TLSPwdRegAskCode("86-"+phoneNumber, pwdRegListener);
    }

    public void verifyCode() {
        type=2;
        String verNum = register2View.getVerNum();
        accountHelper.TLSPwdRegVerifyCode(verNum, pwdRegListener);
    }

    public class PwdRegListener implements TLSPwdRegListener{

        @Override
        public void OnPwdRegAskCodeSuccess(int i, int i1) {
            ToastUtils.showLongToast(context,"验证码发送成功！" + i1 / 60 + "分钟内有效");
                register2View.startTime(i);
        }

        @Override
        public void OnPwdRegReaskCodeSuccess(int i, int i1) {

        }

        @Override
        public void OnPwdRegVerifyCodeSuccess() {
            ToastUtils.showLongToast(context,"通过验证");
            Context context=(Context) register2View;
            Intent intent=new Intent(context, RegisterActivity.class);
            context.startActivity(intent);
        }

        @Override
        public void OnPwdRegCommitSuccess(TLSUserInfo tlsUserInfo) {

        }

        @Override
        public void OnPwdRegFail(TLSErrInfo tlsErrInfo) {

                ToastUtils.showLongToast(context,tlsErrInfo.Msg);

        }

        @Override
        public void OnPwdRegTimeout(TLSErrInfo tlsErrInfo) {

        }
    }
}
