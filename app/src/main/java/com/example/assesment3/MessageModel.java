package com.example.assesment3;

public class MessageModel {

    private String message;
    private int avatar;
    private String time;

    public MessageModel(String message, int avatar, String time) {
        this.message = message;
        this.avatar = avatar;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public int getAvatar() {
        return avatar;
    }

    public String getTime() {
        return time;
    }
}
