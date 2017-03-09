package com.example.rog.myapplication.model;

/**
 * Created by ROG on 2017/3/4.
 */

public interface IUserBiz {
        void login(String username,String password,OnLoginListener onLoginListener);
}
