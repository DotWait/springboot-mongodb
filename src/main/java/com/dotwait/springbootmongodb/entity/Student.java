package com.dotwait.springbootmongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Student {
    @Id
    private String id;
    private int stuNum;
    private String name;
    private int age;
    private String[] hobby;
    private List<String> friends;
    private List<Course> courses;
    private List<Teacher> teachers;
}
