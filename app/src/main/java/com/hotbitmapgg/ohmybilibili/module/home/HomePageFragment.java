package com.hotbitmapgg.ohmybilibili.module.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.HomePagerAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;

import butterknife.Bind;

/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * 首页模块主界面
 */
public class HomePageFragment extends RxLazyFragment
{

    @Bind(R.id.view_pager)
    ViewPager mViewPager;

    @Bind(R.id.sliding_tabs)
    SlidingTabLayout mSlidingTab;

    private HomePagerAdapter mHomeAdapter;

    public static HomePageFragment newInstance()
    {

        return new HomePageFragment();
    }


    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_home_sprout;
    }

    @SuppressLint({"NewApi", "ClickableViewAccessibility"})
    @Override
    public void finishCreateView(Bundle state)
    {

        mHomeAdapter = new HomePagerAdapter(getChildFragmentManager(), getApplicationContext());
        mViewPager.setOffscreenPageLimit(4);
        mViewPager.setAdapter(mHomeAdapter);
        mSlidingTab.setViewPager(mViewPager);
    }
}
