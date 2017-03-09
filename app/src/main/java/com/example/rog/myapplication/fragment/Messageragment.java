package com.example.rog.myapplication.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rog.myapplication.R;
import com.tencent.TIMConversation;
import com.tencent.TIMGroupCacheInfo;
import com.tencent.TIMMessage;
import com.tencent.qcloud.presentation.viewfeatures.ConversationView;

import java.util.List;

public class Messageragment extends Fragment implements ConversationView {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_messageragment, container, false);
    }


    @Override
    public void initView(List<TIMConversation> conversationList) {

    }

    @Override
    public void updateMessage(TIMMessage message) {

    }

    @Override
    public void updateFriendshipMessage() {

    }

    @Override
    public void removeConversation(String identify) {

    }

    @Override
    public void updateGroupInfo(TIMGroupCacheInfo info) {

    }

    @Override
    public void refresh() {

    }
}
