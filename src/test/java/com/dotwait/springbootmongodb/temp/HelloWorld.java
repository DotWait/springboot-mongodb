package com.dotwait.springbootmongodb.temp;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class HelloWorld {
    private String id;
    private List<String> worlds;

    public HelloWorld(String id, List<String> worlds) {
        this.id = id;
        this.worlds = worlds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getWorlds() {
        return worlds;
    }

    public void setWorlds(List<String> worlds) {
        this.worlds = worlds;
    }
}
