package com.dotwait.springbootmongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Teacher {
    @Id
    private String id;
    private String name;
    private List<String> techCourses;

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

    public List<String> getTechCourses() {
        return techCourses;
    }

    public void setTechCourses(List<String> techCourses) {
        this.techCourses = techCourses;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", techCourses=" + techCourses +
                '}';
    }
}
