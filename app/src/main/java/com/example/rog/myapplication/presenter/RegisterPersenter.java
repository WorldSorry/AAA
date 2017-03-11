package com.example.rog.myapplication.presenter;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;

import com.example.rog.myapplication.App;
import com.example.rog.myapplication.ui.view.IRegisterView;
import com.example.rog.myapplication.utils.ToastUtils;
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
    PwdRegListener pwdRegListener=new PwdRegListener();

    public RegisterPersenter(IRegisterView iRegisterView) {
        this.iRegisterView = iRegisterView;
        accountHelper = TLSAccountHelper.getInstance()
                .init(App.getContext(), 1400026501, 11217, "1.0");
    }

    public void register() {
        String userName = iRegisterView.getUserName();
        String password=iRegisterView.getPassword();
        if(TextUtils.isEmpty(userName)||TextUtils.isEmpty(userName)){
            ToastUtils.showToast("请输入密码！");
            return;
        }
        if(!userName.equals(password)){
            ToastUtils.showToast("两次输入的密码不一样！");
            return;
        }
        accountHelper.TLSPwdRegCommit(password, pwdRegListener);
    }



    public class  PwdRegListener implements TLSPwdRegListener{

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
            ToastUtils.showToast("注册完成！");
            iRegisterView.exitActivity();
//            ToastUtils.showToast(tlsUserInfo.);
        }

        @Override
        public void OnPwdRegFail(TLSErrInfo tlsErrInfo) {

        }

        @Override
        public void OnPwdRegTimeout(TLSErrInfo tlsErrInfo) {

        }
    }


}
