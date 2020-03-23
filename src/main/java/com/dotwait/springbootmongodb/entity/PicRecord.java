package com.dotwait.springbootmongodb.entity;

import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@CompoundIndexes({
        @CompoundIndex(name = "picUrl", def = "{\"picUrl\":1}", unique = true),
        @CompoundIndex(name = "screenIds_lastUpdateTime", def = "{\"screenIds\":1,\"lastUpdateTime\":1}")
})
@Document
public class PicRecord {
    private String id;
    private String picUrl;
    private String storagePath;
    private List<String> screenIds;
    private long lastUpdateTime;

    public PicRecord(String picUrl, List<String> screenIds) {
        this.picUrl = picUrl;
        this.screenIds = screenIds;
    }

    public PicRecord(String picUrl, String storagePath, List<String> screenIds, long lastUpdateTime) {
        this.picUrl = picUrl;
        this.storagePath = storagePath;
        this.screenIds = screenIds;
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

    public String getStoragePath() {
        return storagePath;
    }

    public void setStoragePath(String storagePath) {
        this.storagePath = storagePath;
    }

    public long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
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

}
