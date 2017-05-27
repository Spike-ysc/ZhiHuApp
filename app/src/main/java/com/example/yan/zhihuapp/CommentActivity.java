package com.example.yan.zhihuapp;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.yan.zhihuapp.MessageAndAdapter.CommentAdapter;
import com.example.yan.zhihuapp.MessageAndAdapter.CommentMessage;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class CommentActivity extends AppCompatActivity {
    // private List<ListMessage> messagesList = new ArrayList<>();
    private List<CommentMessage> messageList = new ArrayList<>();
    private static final int REFRESH_COMPLETE = 0x110;
    private CommentAdapter adapter;

    private Handler mHandler = new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case REFRESH_COMPLETE:
                    BmobQuery<CommentMessage> cMsg = new BmobQuery<>();
                    cMsg.setLimit(12);
                    cMsg.findObjects(new FindListener<CommentMessage>() {
                        @Override
                        public void done(List<CommentMessage> list, BmobException e) {
                            if (e == null){
                                for (CommentMessage cm:list){
                                    CommentMessage comm = new CommentMessage(cm.getImageId(),
                                            cm.getName(), cm.getMessage(), cm.getTime());
                                    messageList.add(comm);
                                    adapter.notifyDataSetChanged();
                                }
                            }
                        }
                    });
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        Toolbar toolbar = (Toolbar) findViewById(R.id.comment_toolbar);
        setSupportActionBar(toolbar);
        ListView listView = (ListView) findViewById(R.id.comment_listView);
        initMessage();
        adapter = new CommentAdapter(CommentActivity.this, R.layout.comment_list, messageList);
        listView.setAdapter(adapter);
        ImageView mBackImg = (ImageView)findViewById(R.id.comment_back_icon);
        mBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
    private void initMessage(){
        mHandler.sendEmptyMessageDelayed(REFRESH_COMPLETE,2000);

    }

}
