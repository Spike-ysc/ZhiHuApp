package com.example.yan.zhihuapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.yan.zhihuapp.MessageAndAdapter.LetterAdapter;
import com.example.yan.zhihuapp.MessageAndAdapter.LetterMessage;

import java.util.ArrayList;
import java.util.List;


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
        return view;
    }
    private void initMessage(){
        LetterMessage frist = new LetterMessage(R.drawable.topic, "知乎小管家",R.drawable.item1,
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","一个月前");
        messageList.add(frist);
        LetterMessage frist1 = new LetterMessage(R.drawable.topic, "知乎小管家",R.drawable.item1,
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","一个月前");
        messageList.add(frist1);
        LetterMessage frist2 = new LetterMessage(R.drawable.topic, "知乎小管家",R.drawable.item1,
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","一个月前");
        messageList.add(frist2);
        LetterMessage frist3 = new LetterMessage(R.drawable.topic, "知乎小管家",R.drawable.item1,
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","一个月前");
        messageList.add(frist3);
        LetterMessage frist4 = new LetterMessage(R.drawable.topic, "知乎小管家",R.drawable.item1,
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","一个月前");
        messageList.add(frist4);
        LetterMessage frist11 = new LetterMessage(R.drawable.topic, "知乎小管家",R.drawable.item1,
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","一个月前");
        messageList.add(frist11);
        LetterMessage frist21 = new LetterMessage(R.drawable.topic, "知乎小管家",R.drawable.item1,
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","一个月前");
        messageList.add(frist21);
        LetterMessage frist31 = new LetterMessage(R.drawable.topic, "知乎小管家",R.drawable.item1,
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","一个月前");
        messageList.add(frist31);
        LetterMessage frist41 = new LetterMessage(R.drawable.topic, "知乎小管家",R.drawable.item1,
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","一个月前");
        messageList.add(frist41);
    }

}
