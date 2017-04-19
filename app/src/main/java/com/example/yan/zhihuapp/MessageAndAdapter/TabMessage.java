package com.example.yan.zhihuapp.MessageAndAdapter;

import cn.bmob.v3.BmobObject;

/**
 * Created by yan on 2017/4/6.
 */

public class TabMessage extends BmobObject {
    private int imageId;
    private String name;
    private String message;

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMessage(String message) {
        this.message = message;
    }

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
