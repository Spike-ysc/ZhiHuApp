package com.example.yan.zhihuapp;

import java.util.List;

import cn.bmob.v3.BmobObject;

/**
 * Created by yan on 2017/5/26.
 */

public class QuestionMessage extends BmobObject {
    private String question;
    private int qSee;
    private int gTopic;
    private String qTopic1;
    private String qTopic2;
    private String qTopic3;
    private boolean qAttention;
    private String qMsg;

    public String getqMsg() {
        return qMsg;
    }

    public void setqMsg(String qMsg) {
        this.qMsg = qMsg;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getqSee() {
        return qSee;
    }

    public void setqSee(int qSee) {
        this.qSee = qSee;
    }

    public int getgTopic() {
        return gTopic;
    }

    public void setgTopic(int gTopic) {
        this.gTopic = gTopic;
    }

    public String getqTopic1() {
        return qTopic1;
    }

    public void setqTopic1(String qTopic1) {
        this.qTopic1 = qTopic1;
    }

    public String getqTopic2() {
        return qTopic2;
    }

    public void setqTopic2(String qTopic2) {
        this.qTopic2 = qTopic2;
    }

    public String getqTopic3() {
        return qTopic3;
    }

    public void setqTopic3(String qTopic3) {
        this.qTopic3 = qTopic3;
    }

    public boolean isqAttention() {
        return qAttention;
    }

    public void setqAttention(boolean qAttention) {
        this.qAttention = qAttention;
    }

}
