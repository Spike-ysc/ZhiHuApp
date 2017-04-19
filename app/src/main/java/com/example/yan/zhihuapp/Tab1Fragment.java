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
        //initMessage();
        mListView= (ListView) view.findViewById(R.id.my_tab1);
        BmobQuery<TabMessage> tab = new BmobQuery<>();
        tab.getObject("d532a415a5", new QueryListener<TabMessage>() {
            @Override
            public void done(TabMessage tabMessage, BmobException e) {
                Toast.makeText(getContext(), "yes", Toast.LENGTH_SHORT)
                        .show();
                messageList.add(tabMessage);
                adapter = new TabAdapter(getActivity(), R.layout.tab_list, messageList);


                mListView.setAdapter(adapter);

            }
        });

        return view;
    }

    private void initMessage(){
        BmobQuery<TabMessage> tab = new BmobQuery<>();
        tab.getObject("d532a415a5", new QueryListener<TabMessage>() {
            @Override
            public void done(TabMessage tabMessage, BmobException e) {
                Toast.makeText(getContext(), "yes", Toast.LENGTH_SHORT)
                        .show();
            }
        });

//
        TabMessage tb1 = new TabMessage(R.drawable.head, "南瓜酥回答了问题","有哪些非常漂亮的比喻？");
        messageList.add(tb1);
        TabMessage tb2 = new TabMessage(R.drawable.head, "南瓜酥回答了问题","有哪些非常漂亮的比喻？");
        messageList.add(tb2);
        TabMessage tb3 = new TabMessage(R.drawable.head, "南瓜酥回答了问题","有哪些非常漂亮的比喻？");
        messageList.add(tb3);

    }
//        ListMessage frist = new ListMessage(R.drawable.topic, "来自话题",
//                "为什么机器学习的框架都偏向于python",
//
//                "阿加莎·玛丽·克莱丽莎·克里斯蒂女爵士(1890年9月15日－1976年1月12日），\n" +
//                        "则是她写浪漫爱情小说所用的笔名。"
//                , "230赞同· ","68评论· ","关注问题");
//        messagesList.add(frist);

}
