package com.dotwait.springbootmongodb.temp;

import org.springframework.data.annotation.Id;

public class Hello extends HelloFather{
    @Id
    private String id;
    private String sn;
    private String hash;

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

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
