package com.example.yan.zhihuapp.MessageAndAdapter;

/**
 * Created by yan on 2017/4/4.
 */

public class CommentMessage {
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
