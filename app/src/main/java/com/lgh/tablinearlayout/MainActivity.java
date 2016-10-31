/*
 * Copyright (c) 2016.
 * 用于轻量级框架应用
 * 个人开发 版权所有
 * 不经过我同意，不可用于商业应用。
 */

package com.lgh.tablinearlayout;

import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private static final int TAB_SIZE = 4;

    private ViewPager main_pager;
    private Fragment[] tabFragments = {new HomeFragment(), new DiscoverFragment(),
            new MessageFragment(), new MineFragment()};

    private int[] tabs_id = {R.id.ll_tab1, R.id.ll_tab2, R.id.ll_tab3, R.id.ll_tab4};
    private LinearLayout[] ll_tabs = new LinearLayout[TAB_SIZE];
    private int[] images_id = {R.id.image1, R.id.image2, R.id.image3, R.id.image4};
    private ImageView[] images = new ImageView[TAB_SIZE];
    private int[] message_numbles_id = {R.id.rl_message_numble1, R.id.rl_message_numble2, R.id.rl_message_numble3, R.id.rl_message_numble4};
    private RelativeLayout[] rl_message_numbles = new RelativeLayout[TAB_SIZE];
    private int[] dots_id = {R.id.iv_dot1, R.id.iv_dot2, R.id.iv_dot3, R.id.iv_dot4};
    private ImageView[] iv_dots = new ImageView[TAB_SIZE];
    private int[] titles_id = {R.id.title1, R.id.title2, R.id.title3, R.id.title4};
    private TextView[] titles = new TextView[TAB_SIZE];

    private int[] images_normal = {R.mipmap.tab_home_normal, R.mipmap.tab_discover_normal,
            R.mipmap.tab_message_normal, R.mipmap.tab_mine_normal};
    private int[] images_pess = {R.mipmap.tab_home_press, R.mipmap.tab_discover_press,
            R.mipmap.tab_message_press, R.mipmap.tab_mine_press};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView() {
        main_pager = (ViewPager) findViewById(R.id.main_pager);
        for (int i = 0; i < TAB_SIZE; i++) {
            ll_tabs[i] = (LinearLayout) findViewById(tabs_id[i]);
            images[i] = (ImageView) findViewById(images_id[i]);
            rl_message_numbles[i] = (RelativeLayout) findViewById(message_numbles_id[i]);
            iv_dots[i] = (ImageView) findViewById(dots_id[i]);
            titles[i] = (TextView) findViewById(titles_id[i]);
        }
        main_pager.setAdapter(new MainTabFragmentAdapter(getSupportFragmentManager(), tabFragments));
        main_pager.addOnPageChangeListener(this);
        for (int i = 0; i < TAB_SIZE; i++) {
            ll_tabs[i].setOnClickListener(this);
        }
        //初始化第一个
        images[0].setImageResource(images_pess[0]);
        titles[0].setTextColor(ContextCompat.getColor(this, R.color.tabtitleColorSelected));
        main_pager.setCurrentItem(0);
    }

    /**
     * 重置tab
     *
     * @param isTabClick 是否是点击
     * @param index      点击项或者滚动项
     */
    private void resetTab(boolean isTabClick, int index) {
        for (int i = 0; i < TAB_SIZE; i++) {
            if (index == i) {
                images[i].setImageResource(images_pess[i]);
                titles[i].setTextColor(ContextCompat.getColor(this, R.color.tabtitleColorSelected));
                if (isTabClick && main_pager.getCurrentItem() % TAB_SIZE != index) { // 若不是点击当前项
                    main_pager.setCurrentItem(index, false);
                }
                if (rl_message_numbles[i].getVisibility() == View.VISIBLE) {
                    rl_message_numbles[i].setVisibility(View.GONE);
                }
                if (iv_dots[i].getVisibility() == View.VISIBLE) {
                    iv_dots[i].setVisibility(View.GONE);
                }
            } else {
                images[i].setImageResource(images_normal[i]);
                titles[i].setTextColor(ContextCompat.getColor(this, R.color.tabtitleColor));
            }
        }
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        for (int i = 0; i < TAB_SIZE; i++) {
            if (id == tabs_id[i]) {
                resetTab(true, i);
                break;
            }
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        resetTab(false, position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
