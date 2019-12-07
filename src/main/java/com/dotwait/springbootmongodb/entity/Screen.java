package com.dotwait.springbootmongodb.entity;

public class Screen {
    private String id;
    private String name;

    public Screen(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Screen{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
