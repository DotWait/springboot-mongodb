package com.dotwait.springbootmongodb.dao;

import com.dotwait.springbootmongodb.entity.Teacher;

import java.util.List;

public interface UpdateRepository {
    long pushTeachersToStudent(String name, List<Teacher> teachers);
}
