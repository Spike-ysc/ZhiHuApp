package com.example.yan.zhihuapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.yan.zhihuapp.MessageAndAdapter.LetterAdapter;
import com.example.yan.zhihuapp.MessageAndAdapter.LetterMessage;

import java.util.ArrayList;
import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static com.example.yan.zhihuapp.R.layout.me;


/**
 * A simple {@link Fragment} subclass.
 */
public class Item4Fragment extends Fragment {
    private List<LetterMessage> messageList = new ArrayList<>();


    public Item4Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item4,container, false);

//        initMessage();
//        MessageAdapter adapter = new MessageAdapter(getActivity(), R.layout.layout_list, messagesList);
//        ListView listView = (ListView) view.findViewById(R.id.main_ltem);
//        listView.setAdapter(adapter);
        // Inflate the layout for this fragment
        initMessage();
        LetterAdapter adapter = new LetterAdapter(getActivity(),R.layout.letter_list,messageList);
        ListView listView = (ListView) view.findViewById(R.id.letter_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LetterMessage lm = messageList.get(position);
                Intent intent = new Intent(getContext(), TalkActivity.class);
                intent.putExtra("name", lm.getName());
                startActivity(intent);
            }
        });
        return view;
    }
    private void initMessage(){
        LetterMessage frist = new LetterMessage(R.drawable.topic, "知乎管理员",R.drawable.item1,
                "您好， 您举报的 大界AA 在问题【你知道哪些暴力的灰色产业？】","3天前");
        messageList.add(frist);
        LetterMessage frist1 = new LetterMessage(R.drawable.topic, "莫名奇妙",R.drawable.item1,
                "666","一个月前");
        messageList.add(frist1);
        LetterMessage frist2 = new LetterMessage(R.drawable.topic, "知乎管理员",R.drawable.item1,
                "您好， 您举报的 季亭 在回答 电子竞技类玩家是否对高手","3个月前");
        messageList.add(frist2);
        LetterMessage frist4 = new LetterMessage(R.drawable.topic, "知乎小管家",R.drawable.item1,
                "我在知乎安卓版的赞与感谢的页面下拉刷新，之后","一个月前");
        messageList.add(frist4);
        LetterMessage frist3 = new LetterMessage(R.drawable.topic, "知乎Live团队",R.drawable.item1,
                "信你那快乐！恭喜你获得总价值90元的新年福利券","4个月前");
        messageList.add(frist3);

    }

}
