package com.example.yan.zhihuapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.yan.zhihuapp.MessageAndAdapter.ListAdapter;
import com.example.yan.zhihuapp.MessageAndAdapter.ListMessage;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Item1Fragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener  {
    private static final int REFRESH_COMPLETE = 0x110;
    private ListAdapter adapter;
    private SwipeRefreshLayout refreshLayout;
   // private List<ListMessage> messagesList = new ArrayList<>();
    private List<ListMessage> messagesList = new ArrayList<>();

    public Item1Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
    }

    private android.os.Handler mHandler = new android.os.Handler(){
      public void handleMessage(android.os.Message msg){
          switch (msg.what){
              case REFRESH_COMPLETE: ListMessage addmessage = new ListMessage(R.drawable.topic, "来自话题",
                      "下拉刷新内容",

                      "阿加莎·玛丽·克莱丽莎·克里斯蒂女爵士(1890年9月15日－1976年1月12日），\n" +
                              "则是她写浪漫爱情小说所用的笔名。"
                      , "230赞同· ","68评论· ","关注问题");

//                  messagesList.addAll();
                  messagesList.add(0, addmessage);
                  adapter.notifyDataSetChanged();
                  refreshLayout.setRefreshing(false);
                  break;
          }
      }

    };



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_item1, container, false);
        Toolbar mToolbar = (Toolbar) view.findViewById(R.id.item_toobar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        setHasOptionsMenu(true);
        ListView listView = (ListView) view.findViewById(R.id.main_ltem);


        //使最上面的textview获取焦点，使界面加载时在最上边
//        来源：http://blog.csdn.net/jiaoyaning1210/article/details/51084246
        TextView otherText = (TextView) view.findViewById(R.id.other_text);
        otherText.setFocusable(true);
        otherText.setFocusableInTouchMode(true);
        otherText.requestFocus();


        initMessage();
        adapter = new ListAdapter(getActivity(), R.layout.layout_list, messagesList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), AnswerActivity.class);
                startActivity(intent);
            }
        });
        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.main_swipe);
        refreshLayout.setColorSchemeResources(
                R.color.green,R.color.blue,R.color.red,R.color.yellow);
        refreshLayout.setOnRefreshListener(this);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onRefresh() {
        mHandler.sendEmptyMessageDelayed(REFRESH_COMPLETE,2000);
    }

    private void initMessage(){
        ListMessage frist = new ListMessage(R.drawable.topic, "来自话题",
                "为什么机器学习的框架都偏向于python",

                "阿加莎·玛丽·克莱丽莎·克里斯蒂女爵士(1890年9月15日－1976年1月12日），\n" +
                        "则是她写浪漫爱情小说所用的笔名。"
                , "230赞同","68评论","关注问题");

        messagesList.add(frist);
        ListMessage second = new ListMessage(R.drawable.topic, "来自话题",
                "为什么机器学习的框架都偏向于python",

                "阿加莎·玛丽·克莱丽莎·克里斯蒂女爵士(1890年9月15日－1976年1月12日），\n" +
                        "        另外又称马洛温爵士夫人，是英国侦探小说作家。玛丽·维斯马科特则是她写浪漫爱情小说所用的笔名。"
                , "230赞同","68评论","关注问题");
        messagesList.add(second);
        ListMessage third = new ListMessage(R.drawable.topic, "来自话题",
                "为什么机器学习的框架都偏向于python",

                "阿加莎·玛丽·克莱丽莎·克里斯蒂女爵士(1890年9月15日－1976年1月12日），\n" +
                        "        另外又称马洛温爵士夫人，是英国侦探小说作家。玛丽·维斯马科特则是她写浪漫爱情小说所用的笔名。"
                , "230赞同· ","68评论· ","关注问题");
        messagesList.add(third);
        ListMessage fourth = new ListMessage(R.drawable.topic, "来自话题",
                "为什么机器学习的框架都偏向于python",

                "阿加莎·玛丽·克莱丽莎·克里斯蒂女爵士(1890年9月15日－1976年1月12日），\n" +
                        "        另外又称马洛温爵士夫人，是英国侦探小说作家。玛丽·维斯马科特则是她写浪漫爱情小说所用的笔名。"
                , "230赞同· ","68评论· ","关注问题");
        messagesList.add(fourth);
        ListMessage fiveth = new ListMessage(R.drawable.topic, "来自话题",
                "为什么机器学习的框架都偏向于python",

                "阿加莎·玛丽·克莱丽莎·克里斯蒂女爵士(1890年9月15日－1976年1月12日），\n" +
                        "        另外又称马洛温爵士夫人，是英国侦探小说作家。玛丽·维斯马科特则是她写浪漫爱情小说所用的笔名。"
                , "230赞同· ","68评论· ","关注问题");
        messagesList.add(fiveth);
        ListMessage sixth = new ListMessage(R.drawable.topic, "来自话题",
                "为什么机器学习的框架都偏向于python",

                "阿加莎·玛丽·克莱丽莎·克里斯蒂女爵士(1890年9月15日－1976年1月12日），\n" +
                        "        另外又称马洛温爵士夫人，是英国侦探小说作家。玛丽·维斯马科特则是她写浪漫爱情小说所用的笔名。"
                , "230赞同· ","68评论· ","关注问题");
        messagesList.add(sixth);
    }

}
