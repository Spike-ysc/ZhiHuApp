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


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab3Fragment extends Fragment {
    private List<TabMessage> messageList = new ArrayList<>();

    public Tab3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab3, container, false);
        initMessage();
        TabAdapter adapter = new TabAdapter(getActivity(), R.layout.tab_list, messageList);
        ListView listView = (ListView) view.findViewById(R.id.my_tab3);
        listView.setAdapter(adapter);

        return view;
    }

    private void initMessage(){
        TabMessage tb1 = new TabMessage(R.drawable.head, "南瓜酥回答了问题","有哪些非常漂亮的比喻？");
        messageList.add(tb1);
        TabMessage tb2 = new TabMessage(R.drawable.head, "南瓜酥回答了问题","有哪些非常漂亮的比喻？");
        messageList.add(tb2);
        TabMessage tb3 = new TabMessage(R.drawable.head, "南瓜酥回答了问题","有哪些非常漂亮的比喻？");
        messageList.add(tb3);

    }
}
