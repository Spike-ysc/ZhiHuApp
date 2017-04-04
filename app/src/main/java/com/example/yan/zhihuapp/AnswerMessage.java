package com.example.yan.zhihuapp;

/**
 * Created by yan on 2017/4/4.
 */

public class AnswerMessage {
    private int imageId;
    private String name;
    private String text;
    private String agree;
    private String comment;
    private String time;
    public AnswerMessage(int imageId,String name, String text, String agree, String comment, String time){
        this.imageId = imageId;
        this.name = name;
        this.text = text;
        this.agree = agree;
        this.comment = comment;
        this.time = time;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public String getAgree() {
        return agree;
    }

    public String getComment() {
        return comment;
    }

    public String getTime() {
        return time;
    }
}
