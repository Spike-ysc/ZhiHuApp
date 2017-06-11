package com.example.yan.zhihuapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by XLy on 2017/6/9.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {

//    public static final String CREATE_TABLE = "create table users("
//            + "id integer primary key autoincreament,"
//            + "email varchar,"
//            + "pwd text,"
//            + "keyword varchar)";


    public MyDatabaseHelper(Context context){
        super(context, "userdb.db", null, 5);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "create table users(id integer primary key autoincrement, email varchar, password varchar, keyword varchar)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
