package com.example.yan.zhihuapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.yan.zhihuapp.MessageAndAdapter.AnswerAdapter;
import com.example.yan.zhihuapp.MessageAndAdapter.AnswerMessage;

import java.util.ArrayList;
import java.util.List;

public class QuestionActivity extends AppCompatActivity {
    private List<AnswerMessage> messageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

//        使页面打开后是最上面
        TextView myQuestion = (TextView) findViewById(R.id.myQuestion);
        myQuestion.setFocusable(true);
        myQuestion.setFocusableInTouchMode(true);
        myQuestion.requestFocus();
//        ListView listView = (ListView) view.findViewById(R.id.main_ltem);
//
//
//        initMessage();
//        ListAdapter adapter = new ListAdapter(getActivity(), R.layout.layout_list, messagesList);
//        listView.setAdapter(adapter);
        initMessage();
        ListView listView = (ListView) findViewById(R.id.question_list);
        AnswerAdapter adapter = new AnswerAdapter(QuestionActivity.this,R.layout.answer_list,messageList);
        listView.setAdapter(adapter);
    }

    private void initMessage(){
        AnswerMessage first = new AnswerMessage(R.drawable.head,"安卓",
                "阿加莎·玛丽·克莱丽莎·克里斯蒂女爵士(1890年9月15日－1976年1月12日），则是她写浪漫爱情小说所用的笔名。",
                "17赞","7评论","21分钟前");
        messageList.add(first);
        AnswerMessage first1 = new AnswerMessage(R.drawable.head,"安卓",
                "阿加莎·玛丽·克莱丽莎·克里斯蒂女爵士(1890年9月15日－1976年1月12日），则是她写浪漫爱情小说所用的笔名。",
                "17赞","7评论","21分钟前");
        messageList.add(first1);
        AnswerMessage first2 = new AnswerMessage(R.drawable.head,"安卓",
                "阿加莎·玛丽·克莱丽莎·克里斯蒂女爵士(1890年9月15日－1976年1月12日），则是她写浪漫爱情小说所用的笔名。",
                "17赞","7评论","21分钟前");
        messageList.add(first2);
        AnswerMessage first3 = new AnswerMessage(R.drawable.head,"安卓",
                "阿加莎·玛丽·克莱丽莎·克里斯蒂女爵士(1890年9月15日－1976年1月12日），则是她写浪漫爱情小说所用的笔名。",
                "17赞","7评论","21分钟前");
        messageList.add(first3);
        AnswerMessage first4 = new AnswerMessage(R.drawable.head,"安卓",
                "阿加莎·玛丽·克莱丽莎·克里斯蒂女爵士(1890年9月15日－1976年1月12日），则是她写浪漫爱情小说所用的笔名。",
                "17赞","7评论","21分钟前");
        messageList.add(first4);
        AnswerMessage first5 = new AnswerMessage(R.drawable.head,"安卓",
                "阿加莎·玛丽·克莱丽莎·克里斯蒂女爵士(1890年9月15日－1976年1月12日），则是她写浪漫爱情小说所用的笔名。",
                "17赞","7评论","21分钟前");
        messageList.add(first5);
        AnswerMessage first6 = new AnswerMessage(R.drawable.head,"安卓",
                "阿加莎·玛丽·克莱丽莎·克里斯蒂女爵士(1890年9月15日－1976年1月12日），则是她写浪漫爱情小说所用的笔名。",
                "17赞","7评论","21分钟前");
        messageList.add(first6);
        AnswerMessage first7 = new AnswerMessage(R.drawable.head,"安卓",
                "阿加莎·玛丽·克莱丽莎·克里斯蒂女爵士(1890年9月15日－1976年1月12日），则是她写浪漫爱情小说所用的笔名。",
                "17赞","7评论","21分钟前");
        messageList.add(first7);
    }

}
