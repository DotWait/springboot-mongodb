package com.dotwait.springbootmongodb.temp;

import java.util.List;

public class NewLocal {
    private String id;
    private String pid;
    private String name;
    private List<Object> sub;
    @Override
    public String toString() {
        return "NewLocal{" +
                "id='" + id + '\'' +
                ", pid='" + pid + '\'' +
                ", name='" + name + '\'' +
                ", sub=" + sub +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Object> getSub() {
        return sub;
    }

    public void setSub(List<Object> sub) {
        this.sub = sub;
    }
}
