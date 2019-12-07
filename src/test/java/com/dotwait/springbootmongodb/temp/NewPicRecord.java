package com.dotwait.springbootmongodb.temp;

import java.util.List;

public class NewPicRecord {
    private String id;
    private String picUrl;
    private String screenIds;

    private String field;
    private NewScreen newScreen;

    @Override
    public String toString() {
        return "NewPicRecord{" +
                "id='" + id + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", screenIds='" + screenIds + '\'' +
                ", field='" + field + '\'' +
                ", newScreen=" + newScreen +
                '}';
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getScreenIds() {
        return screenIds;
    }

    public void setScreenIds(String screenIds) {
        this.screenIds = screenIds;
    }

    public NewScreen getNewScreen() {
        return newScreen;
    }

    public void setNewScreen(NewScreen newScreen) {
        this.newScreen = newScreen;
    }
}
