package com.example.yan.zhihuapp;

import cn.bmob.v3.BmobObject;

/**
 * Created by yan on 2017/5/27.
 */

public class AnswerMessage extends BmobObject {

    private String qestion;
    private String name;
    private String ansewer;
    private int imageId;
    private int agreeNum;
    private boolean help;
    private boolean shank;
    private boolean collect;
    private int comment;
    private boolean attention;

    public String getQestion() {
        return qestion;
    }

    public void setQestion(String qestion) {
        this.qestion = qestion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnsewer() {
        return ansewer;
    }

    public void setAnsewer(String ansewer) {
        this.ansewer = ansewer;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getAgreeNum() {
        return agreeNum;
    }

    public void setAgreeNum(int agreeNum) {
        this.agreeNum = agreeNum;
    }

    public boolean isHelp() {
        return help;
    }

    public void setHelp(boolean help) {
        this.help = help;
    }

    public boolean isShank() {
        return shank;
    }

    public void setShank(boolean shank) {
        this.shank = shank;
    }

    public boolean isCollect() {
        return collect;
    }

    public void setCollect(boolean collect) {
        this.collect = collect;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public boolean isAttention() {
        return attention;
    }

    public void setAttention(boolean attention) {
        this.attention = attention;
    }
}
