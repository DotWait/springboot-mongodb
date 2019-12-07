package com.dotwait.springbootmongodb.temp;

public class NewScreen {
    private String screenIds;
    private String id;

    @Override
    public String toString() {
        return "NewScreen{" +
                "screenIds='" + screenIds + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public String getScreenIds() {
        return screenIds;
    }

    public void setScreenIds(String screenIds) {
        this.screenIds = screenIds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
