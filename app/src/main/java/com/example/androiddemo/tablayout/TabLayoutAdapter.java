package com.example.androiddemo.tablayout;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabLayoutAdapter extends FragmentPagerAdapter {

    private String[] titleFragment = new String[]{"推荐", "热点", "视频", "社会", "图片", "娱乐", "科技", "汽车"};

    public TabLayoutAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        int pos = position >= titleFragment.length ? 0 : position;
        return TabLayoutFragment.newInstance(titleFragment[pos]);
    }

    @Override
    public int getCount() {
        return titleFragment.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        int pos = position >= titleFragment.length ? 0 : position;
        return titleFragment[pos];
    }
}
