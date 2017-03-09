package com.example.rog.myapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.rog.myapplication.MainActivity;
import com.example.rog.myapplication.R;
import com.example.rog.myapplication.presenter.SplashPersenter;
import com.example.rog.myapplication.ui.view.ISplashView;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity implements ISplashView{

    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.activity_splash)
    RelativeLayout activitySplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN , WindowManager.LayoutParams. FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        SplashPersenter splashPersenter=new SplashPersenter(this);
        splashPersenter.setImage();
        splashPersenter.moveToMain();
    }

    @Override
    public void setImage(String path) {
        Picasso.with(this)
                .load(path)
                .into(image);
    }

    @Override
    public void moveToMain() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                SplashActivity.this.finish();
            }
        },3000);
    }
}
