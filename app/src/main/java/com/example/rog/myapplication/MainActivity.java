package com.example.rog.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.rog.myapplication.presenter.MainPersenter;
import com.example.rog.myapplication.ui.BaseActivity;
import com.lzy.okgo.OkGo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements IMainView {
    @BindView(R.id.rb1)
    RadioButton rb1;
    @BindView(R.id.rb2)
    RadioButton rb2;
    @BindView(R.id.rb3)
    RadioButton rb3;
    private MainPersenter persenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        persenter = new MainPersenter(this,getSupportFragmentManager());
        rb1.setChecked(true);
        persenter.check(R.id.rb1);
    }
    @OnClick({R.id.rb1, R.id.rb2, R.id.rb3})
    public void onClick(View view) {
        persenter.check(view.getId());
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        OkGo.getInstance().cancelTag(this);
    }
    private long exitTime = 0;
    @Override
    public void onBackPressed() {
        long currentTime = System.currentTimeMillis();
        if ((currentTime - exitTime) >= 2000) {
            //让Toast的显示时间和等待时间相同
            Toast.makeText(this,"在按一次退出！",Toast.LENGTH_SHORT).show();
            exitTime = currentTime;
        } else {
            finish();
        }
    }
}
