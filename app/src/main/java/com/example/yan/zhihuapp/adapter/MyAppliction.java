package com.example.yan.zhihuapp.adapter;

import android.app.Application;
import android.content.SharedPreferences;


public class MyAppliction extends Application {

    private static int MyTheme = 0;
    @Override
    public void onCreate() {
        super.onCreate();
        getLocalData();
    }

    private void getLocalData() {
        SharedPreferences sharedPreferences = getSharedPreferences("theme",MODE_PRIVATE);
        MyTheme = sharedPreferences.getInt("theme",0);

    }
    public static int getThemeValue(){
        return MyTheme;
    }

    public static void setThemeValue(int themeValue){
        MyTheme = themeValue;
    }

    public static int getThemeResources(){
        switch (MyTheme){
            case Theme.DAYTHEME:
                return Theme.RESOURCES_DAYTHEME;
            case Theme.NIGHTTHEME:
                return Theme.RESOURCES_NIGHTTHEME;
            default:
                return Theme.RESOURCES_DAYTHEME;
        }
    }


}
