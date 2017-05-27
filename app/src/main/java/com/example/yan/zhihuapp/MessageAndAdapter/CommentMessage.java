package com.example.yan.zhihuapp.MessageAndAdapter;

import cn.bmob.v3.BmobObject;

/**
 * Created by yan on 2017/4/4.
 */

public class CommentMessage extends BmobObject {
    private int imageId;
    private String name;
    private String message;
    private String time;
    public CommentMessage(int imageId, String name, String message, String time){
        this.imageId = imageId;
        this.name = name;
        this.message = message;
        this.time = time;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public String getTime() {
        return time;
    }
}
