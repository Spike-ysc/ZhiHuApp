package com.example.yan.zhihuapp;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class HomePageActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabFragmentAdapter adapter;
    private List<Fragment> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.home_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tabLayout = (TabLayout) findViewById(R.id.topic_Tab_layout);
        viewPager = (ViewPager) findViewById(R.id.topic_View_page);
        viewPager.setOffscreenPageLimit(2);
        list = new ArrayList<>();
        list.add(new Tab1Fragment());
        list.add(new Tab2Fragment());
        list.add(new Tab3Fragment());
        adapter = new TabFragmentAdapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
        tabLayout.setupWithViewPager(viewPager);
    }
}
