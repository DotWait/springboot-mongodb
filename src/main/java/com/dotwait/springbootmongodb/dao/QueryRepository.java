package com.dotwait.springbootmongodb.dao;

import com.dotwait.springbootmongodb.entity.Student;

import java.util.List;

public interface QueryRepository {
    List<Student> findAllStudents();

    Student findStudentByName(String name);

    List<Student> findStudentRegex(Integer stuNum, String name, Integer age, String city);

    List<Student> findStudentTextSearch(Integer stuNum, String name, Integer age, String city);

    long countStudents(Integer stuNum, String name, Integer age, String city);
}
