package com.dotwait.springbootmongodb.dao;

import com.dotwait.springbootmongodb.entity.Student;

import java.util.List;

public interface QueryRepository {
    List<Student> findAllStudents();

    Student findStudentById();

    List<Student> findStudentRegex();

    List<Student> findStudentTextSearch();
}
