package com.example.yan.zhihuapp;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.yan.zhihuapp.MessageAndAdapter.ListAdapter;
import com.example.yan.zhihuapp.MessageAndAdapter.ListMessage;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Item2Fragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private List<ListMessage> messagesList = new ArrayList<>();
    private static final int REFRESH_COMPLETE = 0x110;
    private static final int REFRESH_COMPLETE2 = 0x112;
    private ListAdapter adapter;
    private SwipeRefreshLayout refreshLayout;
//    private ProgressBar mProgressBar;

    public Item2Fragment() {
        // Required empty public constructor
    }
    private android.os.Handler mHandler = new android.os.Handler(){
        public void handleMessage(android.os.Message msg){
            switch (msg.what){
                case REFRESH_COMPLETE: ListMessage addmessage = new ListMessage(R.drawable.topic, "来自话题",
                        "下拉刷新内容",

                        "阿加莎·玛丽·克莱丽莎·克里斯蒂女爵士(1890年9月15日－1976年1月12日），\n" +
                                "则是她写浪漫爱情小说所用的笔名。"
                        , "230赞同· ","68评论· ","关注问题","");

//                  messagesList.addAll();
                    messagesList.add(0, addmessage);
                    adapter.notifyDataSetChanged();
                    refreshLayout.setRefreshing(false);
                    break;
//                case REFRESH_COMPLETE2:
//                    mProgressBar.setVisibility(View.GONE);
//                    break;
            }
        }

    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_item2, container, false);
//        mProgressBar = (ProgressBar)view.findViewById(R.id.item2_pro);

        initMessage();
        adapter = new ListAdapter(getActivity(), R.layout.layout_list, messagesList);
        ListView listView = (ListView) view.findViewById(R.id.two_list);
        listView.setAdapter(adapter);
        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_2);
        refreshLayout.setColorSchemeResources(
                R.color.green,R.color.blue,R.color.red,R.color.yellow);
        refreshLayout.setOnRefreshListener(this);
        // Inflate the layout for this fragment
        return view;
    }

    public void onRefresh() {
        mHandler.sendEmptyMessageDelayed(REFRESH_COMPLETE,2000);
    }

    private void initMessage(){
        for (int i=0; i<10; i++){
            ListMessage frist = new ListMessage(R.drawable.topic, "来自话题",
                    "为什么机器学习的框架都偏向于python",

                    "阿加莎·玛丽·克莱丽莎·克里斯蒂女爵士(1890年9月15日－1976年1月12日），\n" +
                            "则是她写浪漫爱情小说所用的笔名。"
                    , "230赞同· ","68评论· ","关注问题","");
            messagesList.add(frist);
        }

//        mHandler.sendEmptyMessageDelayed(REFRESH_COMPLETE2,2000);


    }

}
