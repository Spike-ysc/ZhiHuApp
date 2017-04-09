package com.example.yan.zhihuapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

public class AnswerActivity extends AppCompatActivity {
    private BottomNavigationBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
//        bar = (BottomNavigationBar) findViewById(R.id.answer_navigation);
//        bar.setMode(BottomNavigationBar.MODE_FIXED)
//                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_DEFAULT);
//        bar.setAutoHideEnabled(true);
//        bar.addItem(new BottomNavigationItem(R.drawable.mytime,"赞").setActiveColor(R.color.blue))
//                .addItem(new BottomNavigationItem(R.drawable.mytime,"没有帮助").setInActiveColorResource(R.color.blue))
//                .addItem(new BottomNavigationItem(R.drawable.mytime,"感谢").setInActiveColorResource(R.color.blue))
//                .addItem(new BottomNavigationItem(R.drawable.mytime,"收藏").setInActiveColorResource(R.color.blue))
//                .addItem(new BottomNavigationItem(R.drawable.mytime,"21").setInActiveColorResource(R.color.blue))
//                .initialise();
    }
}
