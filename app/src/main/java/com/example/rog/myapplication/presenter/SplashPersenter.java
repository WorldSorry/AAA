package com.example.rog.myapplication.presenter;

import com.example.rog.myapplication.ui.SplashActivity;
import com.example.rog.myapplication.ui.view.ISplashView;

/**
 * Created by ROG on 2017/3/9.
 */

public class SplashPersenter {
    ISplashView splashView;
    public SplashPersenter(SplashActivity splashActivity) {
        splashView=splashActivity;
    }
    public void moveToMain(){
        splashView.moveToMain();
    }
    public void setImage(){
        splashView.setImage("https://imgsa.baidu.com/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=dc541f030e2442a7ba03f5f7b02ac62e/6159252dd42a2834769e138b5ab5c9ea15cebf71.jpg");
    }
}
