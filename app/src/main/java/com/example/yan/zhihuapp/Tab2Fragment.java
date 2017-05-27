package com.example.yan.zhihuapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

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
public class Tab2Fragment extends Fragment {
    private List<TabMessage> messageList = new ArrayList<>();

    public Tab2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab2, container, false);
        initMessage();
        TabAdapter adapter = new TabAdapter(getActivity(), R.layout.tab_list, messageList);
        ListView listView = (ListView) view.findViewById(R.id.my_tab2);
        listView.setAdapter(adapter);

        return view;
    }

    private void initMessage(){
        BmobQuery<TabMessage> tab = new BmobQuery<>();
        tab.getObject("d532a415a5", new QueryListener<TabMessage>() {
            @Override
            public void done(TabMessage tabMessage, BmobException e) {
                messageList.add(tabMessage);
            }
        });
        TabMessage tb1 = new TabMessage(R.drawable.head, "葱葱不匆匆赞同了你的回答","你经历过的或者听过的最动人的爱情故事是什么样子的？");
        messageList.add(tb1);
        TabMessage tb2 = new TabMessage(R.drawable.head, "可我最爱是天然问题","为什么很多人喜欢用新垣结衣做头像？");
        messageList.add(tb2);
        TabMessage tb3 = new TabMessage(R.drawable.head, "喵哒咪赞了你在回答下的评论","有哪些图片和文字可以用来回应钓鱼提问？");
        messageList.add(tb3);

    }
}
