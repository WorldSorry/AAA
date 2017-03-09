package com.example.rog.myapplication.presenter;

import com.example.rog.myapplication.ui.view.IRegister2View;

import tencent.tls.platform.TLSAccountHelper;
import tencent.tls.platform.TLSErrInfo;
import tencent.tls.platform.TLSPwdRegListener;
import tencent.tls.platform.TLSUserInfo;

/**
 * Created by ROG on 2017/3/9.
 */

public class Register2Persenter {

    IRegister2View register2View;
    TLSAccountHelper accountHelper;
    PwdRegListener pwdRegListener;
    public Register2Persenter(IRegister2View register2View) {
        this.register2View = register2View;
        accountHelper = TLSAccountHelper.getInstance();
        pwdRegListener=new PwdRegListener();
    }

    public void sendCode() {
        String phoneNumber = register2View.getPhoneNumber();
        accountHelper.TLSPwdRegAskCode("86-"+phoneNumber, pwdRegListener);

    }
    public class PwdRegListener implements TLSPwdRegListener{

        @Override
        public void OnPwdRegAskCodeSuccess(int i, int i1) {

        }

        @Override
        public void OnPwdRegReaskCodeSuccess(int i, int i1) {

        }

        @Override
        public void OnPwdRegVerifyCodeSuccess() {

        }

        @Override
        public void OnPwdRegCommitSuccess(TLSUserInfo tlsUserInfo) {

        }

        @Override
        public void OnPwdRegFail(TLSErrInfo tlsErrInfo) {

        }

        @Override
        public void OnPwdRegTimeout(TLSErrInfo tlsErrInfo) {

        }
    }
}
