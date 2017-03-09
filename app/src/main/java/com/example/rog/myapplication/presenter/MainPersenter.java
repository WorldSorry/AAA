package com.example.rog.myapplication.presenter;

import android.app.Fragment;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

import com.example.rog.myapplication.R;
import com.example.rog.myapplication.fragment.CircleFragment;
import com.example.rog.myapplication.fragment.Messageragment;
import com.example.rog.myapplication.fragment.MineFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ROG on 2017/3/4.
 */

public class MainPersenter {
    private Context context;
    private List<android.support.v4.app.Fragment> fragments = new ArrayList<>();
    FragmentManager supportFragmentManager;

    public MainPersenter(Context context, FragmentManager supportFragmentManager) {
        this.context = context;
        fragments.add(new CircleFragment());
        fragments.add(new Messageragment());
        fragments.add(new MineFragment());
        this.supportFragmentManager=supportFragmentManager;
    }

    public void check(int id) {
        switch (id) {
            case R.id.rb1:
                showFragment(0,"CircleFragment");
                break;
            case R.id.rb2:
               showFragment(1,"Messageragment");
                break;
            case R.id.rb3:
                showFragment(2,"MineFragment");
                break;
        }
    }
    public void showFragment(int index,String tag){
        android.support.v4.app.Fragment fragment = fragments.get(index);
       supportFragmentManager.beginTransaction().replace(R.id.container,fragment).commit();
    }
    public void ondestory(){
        supportFragmentManager=null;
        context=null;
        fragments=null;
    }
}
