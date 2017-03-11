package com.example.rog.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ROG on 2017/3/11.
 */

public class BaseActiity extends AppCompatActivity{
    public Context mContext;
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        mContext=this;
    }
    public void exitActivity(){
        finish();
    }
    public void startActivityAndFinish(Class<Activity> ActivityClass){
        Intent intent=new Intent(this,ActivityClass);
        startActivity(intent);
        exitActivity();
    }
}
