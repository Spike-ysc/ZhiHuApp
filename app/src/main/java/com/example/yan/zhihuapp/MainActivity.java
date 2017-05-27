package com.example.yan.zhihuapp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.yan.zhihuapp.MessageAndAdapter.CommentMessage;
import com.example.yan.zhihuapp.MessageAndAdapter.ListMessage;
import com.example.yan.zhihuapp.adapter.MyAppliction;
import com.example.yan.zhihuapp.adapter.Theme;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobObject;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

import static com.example.yan.zhihuapp.R.drawable.th_1;
import static com.example.yan.zhihuapp.R.drawable.topic;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener{
    private BottomNavigationBar bar;
    private Fragment currentFragment = null;
    private Item1Fragment mFragment1 = new Item1Fragment();
    private Item2Fragment mFragment2 = new Item2Fragment();
    private Item3Fragment mFragment3 = new Item3Fragment();
    private Item4Fragment mFragment4 = new Item4Fragment();
    private Item5Fragment mFragment5 = new Item5Fragment();
    private MainFragment mFragment6 = new MainFragment();
    private Item6Fragment mFragment7 = new Item6Fragment();
    private AppBarLayout mAppBarLayout;
    private FloatingActionButton mFloatingActionButton;
    private CoordinatorLayout mCoor;
    private TextView hide;
    private RelativeLayout hideRelative;
    private boolean isOpen = false;
    private LinearLayout toSelect;

    private ViewGroup mViewGroup;
    private ImageView mImageView;

    private MainFragment mMainFragment;

    private final long ANIMTION_TIME = 1000;

    private Button mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTheme(MyAppliction.getThemeResources());
        setContentView(R.layout.activity_main);

        //bmob初始化
        Bmob.initialize(this,"513ed4499b5b55835ea7e56b1f9ae014");
;

//        QuestionMessage qm = new QuestionMessage();
//        qm.setqTopic1("Android开发");
//        qm.setqTopic2("Android开发");
//        qm.setqTopic3("Android开发");
//        qm.setQuestion("Android有几种不同的键盘布局？");
//        qm.setqSee(21);
//        qm.setqAttention(false);
//        qm.setgTopic(0);
//        qm.setqMsg("iOS现在有11种不同类型的键盘，详见问题iOS有几种不同的键盘布局？ - iOS 开发中，@苏打肥 的回答，那安卓有多少种类型的键盘呢，在产品设计过程中安卓的键盘有哪些要注意的");
//        qm.save(new SaveListener<String>() {
//            @Override
//            public void done(String s, BmobException e) {
//                if (e==null){
//                    Toast.makeText(MainActivity.this, "yes",Toast.LENGTH_SHORT).show();
//                }else {
//
//                }
//            }
//        });


//
//        new BmobObject().insertBatch(this, persons, new SaveListener() {
//            @Override
//            public void onSuccess() {
//                toast("批量添加成功");
//            }
//            @Override
//            public void onFailure(int code, String msg) {
//                toast("批量添加失败:"+msg);
//            }
//        });

        mAppBarLayout = (AppBarLayout) findViewById(R.id.my_appbar);
        mCoor = (CoordinatorLayout) findViewById(R.id.coor);

        hideRelative = (RelativeLayout) findViewById(R.id.hide_relative);
        hide = (TextView) findViewById(R.id.hide);

        mFloatingActionButton = (FloatingActionButton)findViewById(R.id.main_fab);
        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isOpen){
                    turnLeft(v);
                }
                else {
                    turnRight(v);
                }
            }
        });
        hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnRight(mFloatingActionButton);
            }
        });
        bar = (BottomNavigationBar) findViewById(R.id.main_bar);
//        bar.setFab(mFloatingActionButton);
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

        toSelect = (LinearLayout) findViewById(R.id.to_select_layout);
        toSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SelectActivity.class);
                startActivity(intent);
            }
        });
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
                hidetab();
                // FourthFragment fragment4 = new FourthFragment();
                // getSupportFragmentManager().beginTransaction().replace(R.id.allFrame, fragment4).commit();
                break;
            case 2:
                switchFragment(mFragment3);
                hidetab();
                break;
            case 3:
                switchFragment(mFragment4);
                hidetab();
                break;
            case 4:
                switchFragment(mFragment5);
                hidetab();
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
    private void hidetab(){
        if (isOpen == true){
            turnRight(mFloatingActionButton);
        }
        if (mAppBarLayout.getVisibility() == View.VISIBLE){

            mAppBarLayout.setVisibility(View.GONE);
        }
        if (mFloatingActionButton.getVisibility() == View.VISIBLE){

            mFloatingActionButton.setVisibility(View.GONE);
        }

        mAppBarLayout.setVisibility(View.GONE);
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
    private void turnLeft(View v){
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(v,"rotation", 0, -155,-135);
        objectAnimator.setDuration(300)
                .setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimator.start();
        hideRelative.setVisibility(View.VISIBLE);
        hide.setVisibility(View.VISIBLE);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1f);
        alphaAnimation.setDuration(300);
        alphaAnimation.setFillAfter(true);
        hideRelative.startAnimation(alphaAnimation);
        hide.startAnimation(alphaAnimation);
        hide.setClickable(true);
        isOpen = true;

        mFloatingActionButton.setImageResource(R.drawable.ic_clear_black_24dp);
    }

    //回到原来位置
    public void turnRight(View v){
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(v, "rotation", -135,20, 0);
        objectAnimator.setDuration(300);
        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimator.start();
        hideRelative.setVisibility(View.GONE);
        hide.setVisibility(View.GONE);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1f, 0);
        alphaAnimation.setDuration(300);
        alphaAnimation.setFillAfter(true);
        hideRelative.startAnimation(alphaAnimation);
        hide.startAnimation(alphaAnimation);
        hide.setClickable(false);
        isOpen = false;
        mFloatingActionButton.setImageResource(R.drawable.pen);
    }



}