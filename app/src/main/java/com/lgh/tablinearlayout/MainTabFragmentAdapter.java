/*
 * Copyright (c) 2016.
 * 用于轻量级框架应用
 * 个人开发 版权所有
 * 不经过我同意，不可用于商业应用。
 */

package com.lgh.tablinearlayout;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MainTabFragmentAdapter extends FragmentPagerAdapter {
    private Fragment[] fragments;

    public MainTabFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public MainTabFragmentAdapter(FragmentManager fm, Fragment[] fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments == null ? 0 : fragments.length;
    }
}
