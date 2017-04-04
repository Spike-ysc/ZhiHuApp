package com.example.yan.zhihuapp;

/**
 * Created by yan on 2017/4/2.
 */

public class FunctionMessage {
    private int imageId;
    private String name;
    public FunctionMessage(int imageId, String name){
        this.imageId = imageId;
        this.name = name;
    }

    public int getImageId() {

        return imageId;
    }

    public String getName() {
        return name;
    }

}
