package com.example.yan.zhihuapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.yan.zhihuapp.MessageAndAdapter.TabAdapter;
import com.example.yan.zhihuapp.MessageAndAdapter.TabMessage;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab1Fragment extends Fragment {

    private List<TabMessage> messageList = new ArrayList<>();
    private TabAdapter adapter;
    private View view;
    private ListView mListView;

    public Tab1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tab1, container, false);
        initMessage();
        mListView= (ListView) view.findViewById(R.id.my_tab1);
        BmobQuery<TabMessage> tab = new BmobQuery<>();

        adapter = new TabAdapter(getActivity(), R.layout.tab_list, messageList);
        mListView.setAdapter(adapter);

        return view;
    }

    private void initMessage(){

//
        TabMessage tb1 = new TabMessage(R.drawable.head, "Python中文社区新增了文章","透过数据看Github？");
        messageList.add(tb1);
        TabMessage tb2 = new TabMessage(R.drawable.head, "知识分子新增了文章","笑的科学机理？");
        messageList.add(tb2);
        TabMessage tb3 = new TabMessage(R.drawable.head, "知识分子新增了文章","美国科学在衰退？");
        messageList.add(tb3);
        TabMessage tb4 = new TabMessage(R.drawable.head, "Python中文社区新增了文章","如何使用爬虫分析招聘情况？");
        messageList.add(tb4);
//        TabMessage tb5 = new TabMessage(R.drawable.head, "向晓回答了问题","有哪些非常漂亮的比喻？");
//        messageList.add(tb5);
//        TabMessage tb6 = new TabMessage(R.drawable.head, "蜗牛贱贱君回答了问题","你初中高中有什么有趣的故事？");
//        messageList.add(tb6);
//        TabMessage tb7 = new TabMessage(R.drawable.head, "知识分子新增了文章","2017第十八界医学奖报名截止？");
//        messageList.add(tb7);
//        TabMessage tb8 = new TabMessage(R.drawable.head, "知识分子新增了文章","五分钟看懂中国最新的量子计算机？");
//        messageList.add(tb8);
//        TabMessage tb9 = new TabMessage(R.drawable.head, "外面的世界新增了文章","仍有一份情怀？");
//        messageList.add(tb9);

    }

}
