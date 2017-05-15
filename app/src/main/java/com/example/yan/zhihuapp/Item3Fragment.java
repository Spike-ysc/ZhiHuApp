package com.example.yan.zhihuapp;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Item3Fragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabFragmentAdapter adapter;
    private List<Fragment> list;
    private TextView nameText;

    public Item3Fragment() {
        // Required empty public constructor
    }


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


        // Inflate the layout for this fragment
        return view;
    }

}
