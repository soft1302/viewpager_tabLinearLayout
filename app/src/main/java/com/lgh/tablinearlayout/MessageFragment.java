/*
 * Copyright (c) 2016.
 * 用于轻量级框架应用
 * 个人开发 版权所有
 * 不经过我同意，不可用于商业应用。
 */

package com.lgh.tablinearlayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MessageFragment extends Fragment {

    private View mRootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRootView == null){
            mRootView = inflater.inflate(R.layout.message_fragment,container,false);
        }
        ViewGroup parent = (ViewGroup) mRootView.getParent();
        if (parent != null){
            parent.removeView(mRootView);
        }
        return mRootView;
    }
}
