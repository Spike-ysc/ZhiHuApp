package com.example.yan.zhihuapp;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yan.zhihuapp.MessageAndAdapter.ListMessage;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Item3Fragment extends Fragment{
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabFragmentAdapter adapter;
    private List<Fragment> list;
    private TextView nameText;

    private static final int REFRESH_COMPLETE = 0x110;

    private SwipeRefreshLayout refreshLayout;

    public Item3Fragment() {
        // Required empty public constructor
    }
    private android.os.Handler mHandler = new android.os.Handler(){
        public void handleMessage(android.os.Message msg){
            switch (msg.what){
                case REFRESH_COMPLETE:
                    Toast.makeText(getActivity(), "yes", Toast.LENGTH_SHORT).show();

                    refreshLayout.setRefreshing(false);
                    break;
            }
        }

    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item3,container,false);
        tabLayout = (TabLayout) view.findViewById(R.id.myTablayout);
        viewPager = (ViewPager) view.findViewById(R.id.myViewPager);
        viewPager.setOffscreenPageLimit(2);
        list = new ArrayList<>();
        list.add(new Tab1Fragment());
        list.add(new Tab2Fragment());
        list.add(new Tab3Fragment());
        adapter = new TabFragmentAdapter(getChildFragmentManager(),list);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
        tabLayout.setupWithViewPager(viewPager);
        nameText =(TextView) view.findViewById(R.id.tab_name);
//        nameText.setTextColor(nameText.getResources().getColor(R.color.red,null));
        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_3);
        refreshLayout.setColorSchemeResources(
                R.color.green,R.color.blue,R.color.red,R.color.yellow);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mHandler.sendEmptyMessageDelayed(REFRESH_COMPLETE,2000);
            }
        });


        // Inflate the layout for this fragment
        return view;
    }
}
