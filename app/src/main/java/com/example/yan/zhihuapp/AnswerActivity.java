package com.example.yan.zhihuapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

public class AnswerActivity extends AppCompatActivity {
    private BottomNavigationBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.answer_toolbar);
        setSupportActionBar(toolbar);
        ImageView mBackImg = (ImageView) findViewById(R.id.answer_back_icon);
        mBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.question_menu,menu);

        return true;
    }

}
