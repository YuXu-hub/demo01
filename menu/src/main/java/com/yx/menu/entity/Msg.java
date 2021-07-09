package com.yx.menu.entity;
public class Msg {

    private String id;
    private String title;
    private String content;
    private String state;
    private String sendName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSendName() {
        return sendName;
    }

    public void setSendName(String sendName) {
        this.sendName = sendName;
    }

    public Msg() {
    }

    public Msg(String id, String title, String content, String state, String sendName) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.state = state;
        this.sendName = sendName;
    }
}
