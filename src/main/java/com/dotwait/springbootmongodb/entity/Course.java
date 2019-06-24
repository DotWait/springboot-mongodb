package com.dotwait.springbootmongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Course {
    @Id
    private String id;
    private String name;
    private String teacher;
    private int numofStu;
    private List<String> students;
}
