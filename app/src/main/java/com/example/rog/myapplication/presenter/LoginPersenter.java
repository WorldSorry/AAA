package com.example.rog.myapplication.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.example.rog.myapplication.ui.view.ILoginVIew;
import com.example.rog.myapplication.utils.Constants;
import com.example.rog.myapplication.utils.MyLog;
import com.example.rog.myapplication.utils.ToastUtils;
import com.tencent.TIMCallBack;
import com.tencent.TIMManager;
import com.tencent.TIMUser;
import com.tencent.qcloud.sdk.Constant;

import tencent.tls.platform.TLSErrInfo;
import tencent.tls.platform.TLSLoginHelper;
import tencent.tls.platform.TLSPwdLoginListener;
import tencent.tls.platform.TLSUserInfo;

/**
 * Created by ROG on 2017/3/11.
 */

public class LoginPersenter {
    ILoginVIew loginVIew;
    TLSLoginHelper loginHelper;
    PwdLoginListener pwdLoginListener;
    private final TIMManager timManager;
    MyTIMCassBack myTIMCassBack;

    public LoginPersenter(ILoginVIew loginVIew) {
        this.loginVIew = loginVIew;
        loginHelper = TLSLoginHelper.getInstance()
                .init((Context) loginVIew, 1400026501, 11217, "1.0");
        pwdLoginListener=new PwdLoginListener();
        timManager = TIMManager.getInstance();
        myTIMCassBack=new MyTIMCassBack();
    }
    public void login(){
        String password = loginVIew.password();
        String phone = loginVIew.phone();
        if(TextUtils.isEmpty(password)||TextUtils.isEmpty(phone)){
            ToastUtils.showToast("用户名或密码不能为空！");
            return;
        }
        loginHelper.TLSPwdLogin("86-"+phone, password.getBytes(), pwdLoginListener);
    }
    public class PwdLoginListener implements TLSPwdLoginListener{

        @Override
        public void OnPwdLoginSuccess(TLSUserInfo tlsUserInfo) {
            ToastUtils.showToast("登录成功！");
            loginVIew.exitActivity();
//            int accountType = tlsUserInfo.accountType;
//            String identifier = tlsUserInfo.identifier;
//            tlsUserInfo.
//            TIMUser user=new TIMUser();
//            user.parseFromString(tlsUserInfo.accountType+":"+ Constant.SDK_APPID+":"+identifier);
////            timManager.login();
//
//            timManager.login(
//                    Constants.accountType,
//                    user,
//                    "",
//                    myTIMCassBack);
            //IM登录
            MyLog.e("aaa","tlsUserInfo.identifier"+tlsUserInfo.identifier+
                    "tlsUserInfo.isGuest"+tlsUserInfo.isGuest
            +"tlsUserInfo.accountType"+tlsUserInfo.accountType
            );
        }

        @Override
        public void OnPwdLoginReaskImgcodeSuccess(byte[] bytes) {
        }

        @Override
        public void OnPwdLoginNeedImgcode(byte[] bytes, TLSErrInfo tlsErrInfo) {
            ToastUtils.showToast(tlsErrInfo.Msg);
        }

        @Override
        public void OnPwdLoginFail(TLSErrInfo tlsErrInfo) {
            ToastUtils.showToast(tlsErrInfo.Msg);
        }

        @Override
        public void OnPwdLoginTimeout(TLSErrInfo tlsErrInfo) {
            ToastUtils.showToast(tlsErrInfo.Msg);
        }
    }
    public class MyTIMCassBack implements TIMCallBack{
        @Override
        public void onError(int i, String s) {

        }

        @Override
        public void onSuccess() {

        }
    }

}
