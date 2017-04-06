package com.example.yan.zhihuapp;

/**
 * Created by yan on 2017/4/6.
 */

public class TabMessage {
    private int imageId;
    private String name;
    private String message;
    public TabMessage(int imageId, String name, String message){
        this.imageId = imageId;
        this.name = name;
        this.message = message;
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
}
