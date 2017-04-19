package com.example.yan.zhihuapp;

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

public class CommentActivity extends AppCompatActivity {
    // private List<ListMessage> messagesList = new ArrayList<>();
    private List<CommentMessage> messageList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        Toolbar toolbar = (Toolbar) findViewById(R.id.comment_toolbar);
        setSupportActionBar(toolbar);
        ListView listView = (ListView) findViewById(R.id.comment_listView);
        initMessage();
        CommentAdapter adapter = new CommentAdapter(CommentActivity.this, R.layout.comment_list, messageList);
        listView.setAdapter(adapter);
        ImageView mBackImg = (ImageView)findViewById(R.id.comment_back_icon);
        mBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

//        ListView listView = (ListView) view.findViewById(R.id.main_ltem);
//
//
//        initMessage();
//        adapter = new ListAdapter(getActivity(), R.layout.layout_list, messagesList);
//        listView.setAdapter(adapter);
    }
    private void initMessage(){
        CommentMessage first = new CommentMessage(R.drawable.head,"Eiron","那层纸， 可以做橡皮章","昨天20：48");
        messageList.add(first);
        CommentMessage first1 = new CommentMessage(R.drawable.head,"Eiron","那层纸， 可以做橡皮章","昨天20：48");
        messageList.add(first1);
        CommentMessage first2 = new CommentMessage(R.drawable.head,"Eiron","那层纸， 可以做橡皮章","昨天20：48");
        messageList.add(first2);
        CommentMessage first3 = new CommentMessage(R.drawable.head,"Eiron","那层纸， 可以做橡皮章","昨天20：48");
        messageList.add(first3);
        CommentMessage first4 = new CommentMessage(R.drawable.head,"Eiron","那层纸， 可以做橡皮章","昨天20：48");
        messageList.add(first4);
        CommentMessage first5 = new CommentMessage(R.drawable.head,"Eiron","那层纸， 可以做橡皮章","昨天20：48");
        messageList.add(first5);
        CommentMessage first6 = new CommentMessage(R.drawable.head,"Eiron","那层纸， 可以做橡皮章","昨天20：48");
        messageList.add(first6);
        CommentMessage first7 = new CommentMessage(R.drawable.head,"Eiron","那层纸， 可以做橡皮章","昨天20：48");
        messageList.add(first7);
        CommentMessage first31 = new CommentMessage(R.drawable.head,"Eiron","那层纸， 可以做橡皮章","昨天20：48");
        messageList.add(first31);
        CommentMessage first41 = new CommentMessage(R.drawable.head,"Eiron","那层纸， 可以做橡皮章","昨天20：48");
        messageList.add(first41);
        CommentMessage first51 = new CommentMessage(R.drawable.head,"Eiron","那层纸， 可以做橡皮章","昨天20：48");
        messageList.add(first51);
        CommentMessage first61 = new CommentMessage(R.drawable.head,"Eiron","那层纸， 可以做橡皮章","昨天20：48");
        messageList.add(first61);
        CommentMessage first71 = new CommentMessage(R.drawable.head,"Eiron","那层纸， 可以做橡皮章","昨天20：48");
        messageList.add(first71);
    }
//    private void initMessage(){
//        ListMessage frist = new ListMessage(R.drawable.topic, "来自话题",
//                "为什么机器学习的框架都偏向于python",
//
//                "阿加莎·玛丽·克莱丽莎·克里斯蒂女爵士(1890年9月15日－1976年1月12日），\n" +
//                        "则是她写浪漫爱情小说所用的笔名。"
//                , "230赞同","68评论","关注问题");
//
//        messagesList.add(frist);
}
