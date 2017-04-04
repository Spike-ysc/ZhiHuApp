package com.example.yan.zhihuapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by yan on 2017/4/1.
 */

public class TabFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    private String tabTitles[] = new String[]{"通知","赞与感谢","关注"};
    private Context context;
    public TabFragmentAdapter(FragmentManager fm){
        super(fm);
    }
    public TabFragmentAdapter(FragmentManager fm, List<Fragment> list){
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
