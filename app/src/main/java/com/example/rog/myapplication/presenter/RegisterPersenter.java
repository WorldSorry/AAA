package com.example.rog.myapplication.presenter;

import android.app.Activity;
import android.content.Intent;

import com.example.rog.myapplication.App;
import com.example.rog.myapplication.ui.view.IRegisterView;
import com.tencent.qcloud.tlslibrary.activity.PhonePwdLoginActivity;
import com.tencent.qcloud.tlslibrary.helper.Util;
import com.tencent.qcloud.tlslibrary.service.Constants;
import com.tencent.qcloud.tlslibrary.service.PhonePwdRegisterService;
import com.tencent.qcloud.tlslibrary.service.PhonePwdRegisterService.PwdRegListener;

import tencent.tls.platform.TLSAccountHelper;
import tencent.tls.platform.TLSErrInfo;
import tencent.tls.platform.TLSPwdRegListener;
import tencent.tls.platform.TLSUserInfo;

import static com.tencent.qalsdk.service.QalService.context;

/**
 * Created by ROG on 2017/3/9.
 */

public class RegisterPersenter {
    IRegisterView iRegisterView;
    TLSAccountHelper accountHelper;
    PwdRegListener2 pwdRegListener=new PwdRegListener2();

    public RegisterPersenter(IRegisterView iRegisterView) {
        this.iRegisterView = iRegisterView;
        accountHelper = TLSAccountHelper.getInstance()
                .init(App.getContext(), 1400026501, 11217, "1.0");
    }

    public void register() {
        String userName = iRegisterView.getUserName();
        String password=iRegisterView.getPassword();
        accountHelper.TLSPwdRegAskCode("86-"+userName, pwdRegListener);
    }



    public class  PwdRegListener2 implements TLSPwdRegListener{

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
