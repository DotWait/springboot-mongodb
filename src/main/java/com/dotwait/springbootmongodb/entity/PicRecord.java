package com.dotwait.springbootmongodb.entity;

import java.util.List;

public class PicRecord {
    private String id;
    private String picUrl;
    private List<String> screenIds;

    public PicRecord(String picUrl, List<String> screenIds) {
        this.picUrl = picUrl;
        this.screenIds = screenIds;
    }

    public List<String> getScreenIds() {
        return screenIds;
    }

    public void setScreenIds(List<String> screenIds) {
        this.screenIds = screenIds;
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

    @Override
    public String toString() {
        return "PicRecord{" +
                "id='" + id + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", screenIds=" + screenIds +
                '}';
    }
}
