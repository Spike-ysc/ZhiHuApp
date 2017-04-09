package com.example.yan.zhihuapp.MessageAndAdapter;

/**
 * Created by yan on 2017/3/26.
 */

public class LetterMessage {
    private int imageId;
    private String name;
    private int logoImageId;
    private String message;
    private String time;

    public LetterMessage(int imageId, String name, int logoImageId, String message, String time){
        this.imageId = imageId;
        this.name = name;
        this.logoImageId = logoImageId;
        this.message = message;
        this.time = time;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public int getLogoImageId() {
        return logoImageId;
    }

    public String getMessage() {
        return message;
    }

    public String getTime() {
        return time;
    }
}
