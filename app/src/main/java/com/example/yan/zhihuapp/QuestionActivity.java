package com.example.yan.zhihuapp;

import android.graphics.Color;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yan.zhihuapp.MessageAndAdapter.AnswerAdapter;
import com.example.yan.zhihuapp.MessageAndAdapter.AnswerMessage;
import com.example.yan.zhihuapp.MessageAndAdapter.ListMessage;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.QueryListener;

import static com.example.yan.zhihuapp.R.id.cancel_action;
import static com.example.yan.zhihuapp.R.id.guanzhu;

public class QuestionActivity extends AppCompatActivity {

    private static final int REFRESH_COMPLETE = 0x110;
    private static final int REFRESH_COMPLETE2 = 0x112;
    private TextView questionText;
    private TextView msgText;
    private TextView eyeText;
    private TextView commentText;
    private TopicAdapter adapter1;
    private String questionId;
    private ProgressBar mProgressBar;
    private SwipeRefreshLayout mRefreshLayout;
    private AnswerAdapter adapter;
    private String question;

    private List<AnswerMessage> messageList = new ArrayList<>();

    private List<TopicMessage> messageList1 = new ArrayList<>();

    private Button guanZhu;

    private Handler mHandler = new Handler(){
        public void handleMessage(android.os.Message msg){
            switch (msg.what){
                case REFRESH_COMPLETE:
                    BmobQuery<QuestionMessage> qMsg = new BmobQuery<>();
                    qMsg.getObject(questionId, new QueryListener<QuestionMessage>() {
                        @Override
                        public void done(QuestionMessage questionMessage, BmobException e) {
                            if (e == null){
//                                questionText.setText(questionMessage.getQuestion());
                                msgText.setText(questionMessage.getqMsg());
                                eyeText.setText(""+questionMessage.getqSee());
                                commentText.setText(""+questionMessage.getgTopic());
                                TopicMessage t1 = new TopicMessage(questionMessage.getqTopic1());
                                messageList1.add(t1);
                                TopicMessage t2 = new TopicMessage(questionMessage.getqTopic2());
                                messageList1.add(t2);
                                TopicMessage t3 = new TopicMessage(questionMessage.getqTopic3());
                                messageList1.add(t3);

                                mProgressBar.setVisibility(View.GONE);
                                adapter1.notifyDataSetChanged();

                            }
                        }
                    });
                    BmobQuery<com.example.yan.zhihuapp.AnswerMessage> aMsg = new BmobQuery<>();
                    aMsg.addWhereEqualTo("qestion",question);
                    aMsg.findObjects(new FindListener<com.example.yan.zhihuapp.AnswerMessage>() {
                        @Override
                        public void done(List<com.example.yan.zhihuapp.AnswerMessage> list, BmobException e) {
                            if (e == null){
                                for (com.example.yan.zhihuapp.AnswerMessage am:list){
                                    AnswerMessage first = new AnswerMessage(R.drawable.head,am.getName(),
                                           am.getAnswerTop(),
                                            am.getAgreeNum()+"赞",am.getComment()+"评论",am.getTime());
                                    first.setAnswerId(am.getObjectId());
                                    messageList.add(first);
                                }
                                adapter.notifyDataSetChanged();

                            }
                            else {
                                Toast.makeText(QuestionActivity.this, "dskfjas", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                    break;
                case REFRESH_COMPLETE2:

                    mRefreshLayout.setRefreshing(false);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        mRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.question_swipe);
        mRefreshLayout.setColorSchemeResources(
                R.color.green,R.color.blue,R.color.red,R.color.yellow);
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mHandler.sendEmptyMessageDelayed(REFRESH_COMPLETE2,2000);
            }
        });
        questionText = (TextView)findViewById(R.id.myQuestion);
        question = getIntent().getStringExtra("To_question");
        questionText.setText(question);
        questionId = getIntent().getStringExtra("To_questionId");
        Toolbar toolbar = (Toolbar) findViewById(R.id.question_toolbar);
        setSupportActionBar(toolbar);

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
        ImageView mBackImg = (ImageView) findViewById(R.id.back_icon);
        mBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mProgressBar = (ProgressBar) findViewById(R.id.question_pro);
        initMessage();
        ListView listView = (ListView) findViewById(R.id.question_list);
        adapter = new AnswerAdapter(QuestionActivity.this,R.layout.answer_list,messageList);
        listView.setAdapter(adapter);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.topic_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter1 = new TopicAdapter(messageList1);
        recyclerView.setAdapter(adapter1);
        guanZhu = (Button) findViewById(guanzhu);
        guanZhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (guanZhu.getText() == "关注"){
                    guanZhu.setText("已关注");
                    guanZhu.setBackgroundResource(R.drawable.question_button2);
                }else {
                    guanZhu.setText("关注");
                    guanZhu.setBackgroundResource(R.drawable.question_button);
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.question_menu,menu);

        return true;
    }

    private void initMessage(){

        msgText = (TextView)findViewById(R.id.msg_text);
        eyeText = (TextView)findViewById(R.id.eye_text);
        commentText = (TextView)findViewById(R.id.comment_text);

        mHandler.sendEmptyMessageDelayed(REFRESH_COMPLETE,1000);

    }

}
