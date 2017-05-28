package com.example.yan.zhihuapp;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import org.w3c.dom.Text;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.QueryListener;

public class AnswerActivity extends AppCompatActivity {
    private BottomNavigationBar bar;
    private LinearLayout commentLine;
    private TextView aQuestion;
    private TextView aName;
    private TextView aAnswer;
    private TextView aAgree;
    private TextView aComment;
    private ImageView check1;
    private LinearLayout agreeLinear;
    private String answerId;
    private LinearLayout upAndDown, up, down;
    private TextView agText;
    private ImageView agImg;
    private static final int REFRESH_COMPLETE = 0x110;
    private ProgressBar mProgressBar;
//    private Handler mHandler = new Handler(){
//        public void handleMessage(android.os.Message msg){
//            switch (msg.what) {

//                case REFRESH_COMPLETE:
//                    break;
//            }
//
//        };
    private Handler mHandler = new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case REFRESH_COMPLETE:
                    BmobQuery<AnswerMessage> aMsg = new BmobQuery<>();
                    aMsg.getObject(answerId, new QueryListener<AnswerMessage>() {
                        @Override
                        public void done(AnswerMessage answerMessage, BmobException e) {
                            aQuestion.setText(answerMessage.getQestion());
                            aName.setText(answerMessage.getName());
                            aAnswer.setText(answerMessage.getAnsewer());
                            agText.setText(""+answerMessage.getAgreeNum());
                            mProgressBar.setVisibility(View.GONE);
//                            aAgree.setText(""+answerMessage.getAgreeNum());
//                            aComment.setText(""+answerMessage.getComment());
//                            if (answerMessage.isHelp()){
//                             check1.setImageResource(R.drawable.ic_add_black_24dp);
//                            }
                        }
                    });
                    break;
            }
        }
};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.answer_toolbar);
        setSupportActionBar(toolbar);
        agText = (TextView)findViewById(R.id.ag_text);
        agImg = (ImageView)findViewById(R.id.ag_img);
        agreeLinear = (LinearLayout)findViewById(R.id.answer_agree_button);
        upAndDown = (LinearLayout)findViewById(R.id.answer_up_down);
        up = (LinearLayout)findViewById(R.id.answer_up);
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upAndDown.setVisibility(View.GONE);
                bar.setVisibility(View.VISIBLE);
                agreeLinear.setBackgroundResource(R.drawable.yes_line_layout2);
                agText.setTextColor(agText.getResources().getColor(R.color.white));
                agImg.setImageResource(R.drawable.up_down_switch1);

            }
        });
        down = (LinearLayout)findViewById(R.id.answer_down);
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upAndDown.setVisibility(View.GONE);
                bar.setVisibility(View.VISIBLE);
                agreeLinear.setBackgroundResource(R.drawable.yes_line_layout2);
                agText.setTextColor(agText.getResources().getColor(R.color.white));
                agImg.setImageResource(R.drawable.up_down_switch2);
            }
        });
        mProgressBar = (ProgressBar)findViewById(R.id.answer_pro);
        initMessage();
        ImageView mBackImg = (ImageView) findViewById(R.id.answer_back_icon);
        mBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        answerId = getIntent().getStringExtra("to_answer");
        agreeLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bar.setVisibility(View.INVISIBLE);
                upAndDown.setVisibility(View.VISIBLE);
            }
        });
//        commentLine = (LinearLayout) findViewById(R.id.comment_line);
//        commentLine.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(AnswerActivity.this, CommentActivity.class);
//                startActivity(intent);
//            }
//        });

//        bar = (BottomNavigationBar) findViewById(R.id.main_bar);
////        bar.setFab(mFloatingActionButton);
//        bar.setMode(BottomNavigationBar.MODE_FIXED)
//                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_DEFAULT);
//        bar.setAutoHideEnabled(true);
        bar = (BottomNavigationBar) findViewById(R.id.answer_navigation);
        bar.setMode(BottomNavigationBar.MODE_FIXED)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_DEFAULT);

        bar.setAutoHideEnabled(true);
        bar.addItem(new BottomNavigationItem(R.drawable.nothing,"赞").setActiveColor(R.color.blue))
                .addItem(new BottomNavigationItem(R.drawable.ic_flag_black_24dp,"帮助").setActiveColorResource(R.color.blue))
                .addItem(new BottomNavigationItem(R.drawable.ic_favorite_black_24dp,"感谢").setActiveColorResource(R.color.blue))
                .addItem(new BottomNavigationItem(R.drawable.ic_star_border_black_24dp,"收藏").setActiveColorResource(R.color.blue))
                .addItem(new BottomNavigationItem(R.drawable.ic_chat_bubble_outline_black_24dp,"24").setActiveColorResource(R.color.blue))
                .initialise();
        bar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                switch (position){
                    case 4:
                        Intent intent =  new Intent(AnswerActivity.this, CommentActivity.class);
                        startActivity(intent);
                        break;
                }
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.question_menu,menu);

        return true;
    }
    private void initMessage(){
        aQuestion = (TextView) findViewById(R.id.question_text);
        aName = (TextView) findViewById(R.id.a_name);
        aAnswer = (TextView) findViewById(R.id.a_answer);
//        aAgree = (TextView) findViewById(R.id.a_agree);
//        aComment = (TextView) findViewById(R.id.a_comment);
//        check1 = (ImageView)findViewById(R.id.check_img1);
        mHandler.sendEmptyMessageDelayed(REFRESH_COMPLETE,1000);
    }

}
