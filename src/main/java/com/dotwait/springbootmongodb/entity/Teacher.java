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
}
