package com.dotwait.springbootmongodb.temp;

import org.springframework.data.annotation.Transient;

public class HelloFather {
    @Transient
    private String father;

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }
}
