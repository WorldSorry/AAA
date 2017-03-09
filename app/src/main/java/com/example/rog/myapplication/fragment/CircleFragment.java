package com.example.rog.myapplication.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.rog.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CircleFragment extends Fragment {

    @BindView(R.id.recycleView)
    RecyclerView recycle;


    public CircleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_circle, container, false);
        ButterKnife.bind(this, inflate);
        return inflate;
    }


}
