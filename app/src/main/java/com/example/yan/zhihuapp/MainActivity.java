package com.example.yan.zhihuapp;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.yan.zhihuapp.MessageAndAdapter.TabMessage;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobObject;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {
    private BottomNavigationBar bar;
    private Fragment currentFragment = null;
    private Item1Fragment mFragment1 = new Item1Fragment();
    private Item2Fragment mFragment2 = new Item2Fragment();
    private Item3Fragment mFragment3 = new Item3Fragment();
    private Item4Fragment mFragment4 = new Item4Fragment();
    private Item5Fragment mFragment5 = new Item5Fragment();
    private AppBarLayout mAppBarLayout;
    private FloatingActionButton mFloatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //bmob初始化
        Bmob.initialize(this,"513ed4499b5b55835ea7e56b1f9ae014");

        mAppBarLayout = (AppBarLayout) findViewById(R.id.my_appbar);
        mFloatingActionButton = (FloatingActionButton)findViewById(R.id.main_fab);
        bar = (BottomNavigationBar) findViewById(R.id.main_bar);
        bar.setFab(mFloatingActionButton);
        bar.setMode(BottomNavigationBar.MODE_FIXED)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_DEFAULT);
        bar.setAutoHideEnabled(true);
        bar.addItem(new BottomNavigationItem(R.drawable.item1).setActiveColorResource(R.color.blue))
                .addItem(new BottomNavigationItem(R.drawable.item2).setActiveColorResource(R.color.blue))
                .addItem(new BottomNavigationItem(R.drawable.item3).setActiveColorResource(R.color.blue))
                .addItem(new BottomNavigationItem(R.drawable.item4).setActiveColorResource(R.color.blue))
                .addItem(new BottomNavigationItem(R.drawable.item5).setActiveColorResource(R.color.blue))
                .setFirstSelectedPosition(0)
                .initialise();
        bar.setTabSelectedListener(this);
//        bar.setFab(floating);
    }

    public void onTabSelected(int position) {
        switch (position) {
            case 0:

                switchFragment(mFragment1);
                mAppBarLayout.setVisibility(View.VISIBLE);
                mFloatingActionButton.setVisibility(View.VISIBLE);
//
//                getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, fragment1).commit();
                //Item1Fragment fragment1 = new Item1Fragment();
                //getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, fragment1).commit();
                break;
            case 1:
                switchFragment(mFragment2);
                mAppBarLayout.setVisibility(View.GONE);
                mFloatingActionButton.setVisibility(View.GONE);
                // FourthFragment fragment4 = new FourthFragment();
                // getSupportFragmentManager().beginTransaction().replace(R.id.allFrame, fragment4).commit();
                break;
            case 2:
                switchFragment(mFragment3);
                mAppBarLayout.setVisibility(View.GONE);
                mFloatingActionButton.setVisibility(View.GONE);
                break;
            case 3:
                switchFragment(mFragment4);
                mAppBarLayout.setVisibility(View.GONE);
                break;
            case 4:
                switchFragment(mFragment5);
                mAppBarLayout.setVisibility(View.GONE);
                mFloatingActionButton.setVisibility(View.GONE);
                break;
            default:
                break;
        }
    }

    @Override
    public void onTabUnselected(int position) {
    }

    @Override
    public void onTabReselected(int position) {

    }

    private void switchFragment(Fragment targetfragment) {
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        if (!targetfragment.isAdded()) {
            if (currentFragment != null) {
                transaction.hide(currentFragment);
            }
            transaction.add(R.id.main_fragment, targetfragment)
                    .commit();
        } else {
            transaction.hide(currentFragment)
                    .show(targetfragment)
                    .commit();
        }
        currentFragment = targetfragment;
    }


}