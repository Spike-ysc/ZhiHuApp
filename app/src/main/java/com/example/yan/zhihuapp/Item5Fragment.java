package com.example.yan.zhihuapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.CompoundButtonCompat;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Item5Fragment extends Fragment implements CompoundButton.OnCheckedChangeListener {
    private List<FunctionMessage> messageList = new ArrayList<>();
    private SwitchCompat nightSwitch;


    public Item5Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item5, container, false);
        initMessage();
        ListView listView = (ListView) view.findViewById(R.id.function);
        FunctionAdapter adapter = new FunctionAdapter(getActivity(), R.layout.function_list, messageList);

        listView.setAdapter(adapter);
        nightSwitch = (SwitchCompat) view.findViewById(R.id.night_switch);
        nightSwitch.setOnCheckedChangeListener(this);
        LinearLayout mHomePage = (LinearLayout) view.findViewById(R.id.homePage_view);
        mHomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(getActivity(), HomePageActivity.class);
                startActivity(mIntent);
            }
        });

        // Inflate the layout for this fragment
        return view;

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (nightSwitch.getId()){
            case R.id.night_switch:
                if (isChecked){
                    Toast.makeText(getActivity(),"is Checked",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getActivity(),"no Checked",
                        Toast.LENGTH_SHORT).show();

                }
        }
    }

    private void initMessage(){

        FunctionMessage message1 = new FunctionMessage(R.drawable.eye,"我的关注");
        messageList.add(message1);
        FunctionMessage message2 = new FunctionMessage(R.drawable.star,"我的收藏");
        messageList.add(message2);
        FunctionMessage message3 = new FunctionMessage(R.drawable.mytext,"我的草稿");
        messageList.add(message3);
        FunctionMessage message4 = new FunctionMessage(R.drawable.mytime,"最近浏览");
        messageList.add(message4);
        FunctionMessage message5 = new FunctionMessage(R.drawable.wallet,"我的余额");
        messageList.add(message5);
        FunctionMessage message6 = new FunctionMessage(R.drawable.coupon,"我的礼券");
        messageList.add(message6);
        FunctionMessage message7 = new FunctionMessage(R.drawable.mybook,"我的书架");
        messageList.add(message7);
        FunctionMessage message8 = new FunctionMessage(R.drawable.lightning,"我的Live");
        messageList.add(message8);
        FunctionMessage message9 = new FunctionMessage(R.drawable.value,"我的值乎");
        messageList.add(message9);

    }
}
