package com.dotwait.springbootmongodb.temp;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class PicRecord {
    @Id
    private String id;
    private String picUrl;
    private String storagePath;
    private List<String> screenIds;
    private long lastUpdateTime;

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

    public String getStoragePath() {
        return storagePath;
    }

    public void setStoragePath(String storagePath) {
        this.storagePath = storagePath;
    }

    public List<String> getScreenIds() {
        return screenIds;
    }

    public void setScreenIds(List<String> screenIds) {
        this.screenIds = screenIds;
    }

    public long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Override
    public String toString() {
        return "PicRecord{" +
                "id='" + id + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", storagePath='" + storagePath + '\'' +
                ", screenIds=" + screenIds +
                ", lastUpdateTime=" + lastUpdateTime +
                '}';
    }
}
