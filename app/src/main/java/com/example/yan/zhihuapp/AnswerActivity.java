package com.example.yan.zhihuapp;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
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
    private static final int REFRESH_COMPLETE = 0x110;
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
                    aMsg.getObject("970e69aa25", new QueryListener<AnswerMessage>() {
                        @Override
                        public void done(AnswerMessage answerMessage, BmobException e) {
                            aQuestion.setText(answerMessage.getQestion());
                            aName.setText(answerMessage.getName());
                            aAnswer.setText(answerMessage.getAnsewer());
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
        initMessage();
        ImageView mBackImg = (ImageView) findViewById(R.id.answer_back_icon);
        mBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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
                .addItem(new BottomNavigationItem(R.drawable.ic_flag_black_24dp,"没有帮助").setInActiveColorResource(R.color.blue))
                .addItem(new BottomNavigationItem(R.drawable.ic_favorite_black_24dp,"感谢").setInActiveColorResource(R.color.blue))
                .addItem(new BottomNavigationItem(R.drawable.ic_star_border_black_24dp,"收藏").setInActiveColorResource(R.color.blue))
                .addItem(new BottomNavigationItem(R.drawable.ic_chat_bubble_outline_black_24dp,"24").setInActiveColorResource(R.color.blue))
                .initialise();
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
        mHandler.sendEmptyMessageDelayed(REFRESH_COMPLETE,2000);
    }

}
