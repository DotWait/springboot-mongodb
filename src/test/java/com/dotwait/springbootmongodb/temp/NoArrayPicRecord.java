package com.dotwait.springbootmongodb.temp;

public class NoArrayPicRecord {
    private String id;
    private String picUrl;
    private String screenIds;

    @Override
    public String toString() {
        return "NoArrayPicRecord{" +
                "id='" + id + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", screenIds='" + screenIds + '\'' +
                '}';
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
}
