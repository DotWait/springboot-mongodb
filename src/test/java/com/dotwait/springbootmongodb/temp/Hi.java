package com.dotwait.springbootmongodb.temp;

import java.util.List;

public class Hi {
    private String id;
    private String sn;
    private List<String> hobby;
    private Integer num;
    private String other;

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public List<String> getHobby() {
        return hobby;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Hi{" +
                "id='" + id + '\'' +
                ", sn='" + sn + '\'' +
                ", hobby=" + hobby +
                ", num=" + num +
                ", other='" + other + '\'' +
                '}';
    }
}
