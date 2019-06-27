package com.dotwait.springbootmongodb.dao.impl;

import com.dotwait.springbootmongodb.dao.QueryRepository;
import com.dotwait.springbootmongodb.entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueryRepositoryImpl implements QueryRepository {
    @Override
    public List<Student> findAllStudents() {
        return null;
    }

    @Override
    public Student findStudentById() {
        return null;
    }

    @Override
    public List<Student> findStudentRegex() {
        return null;
    }

    @Override
    public List<Student> findStudentTextSearch() {
        return null;
    }
}
