package com.example.yan.zhihuapp;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by yan on 2017/4/9.
 */

public class MyBottomBar extends CoordinatorLayout.Behavior<View> {
    public MyBottomBar(Context context, AttributeSet attrs){
        super(context, attrs);
    }

//    @Override
//    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
//        return dependency instanceof AppBarLayout;
//    }


    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return super.layoutDependsOn(parent, child, dependency);
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        return super.onDependentViewChanged(parent, child, dependency);
    }
    //    @Override
//    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
//        float translationY = Math.abs(dependency.getTop());
//        child.setTranslationY(translationY);
//        return true;
//    }
//http://www.jianshu.com/p/488283f74e69
}
