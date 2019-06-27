package com.dotwait.springbootmongodb.dao.impl;

import com.dotwait.springbootmongodb.dao.InsertRepository;
import com.dotwait.springbootmongodb.entity.Course;
import com.dotwait.springbootmongodb.entity.Student;
import com.dotwait.springbootmongodb.entity.Teacher;
import com.dotwait.springbootmongodb.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class InsertRepositoryImpl implements InsertRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void insertOneUser(UserInfo userInfo) {
        mongoTemplate.insert(userInfo);
    }

    @Override
    public int insertUsers(List<UserInfo> userInfos) {
        Collection<UserInfo> insert = mongoTemplate.insert(userInfos, UserInfo.class);
        return insert.size();
    }

    @Override
    public void saveOneUser(UserInfo userInfo) {
        mongoTemplate.save(userInfo);
    }

    @Override
    public void insertOneStudent(Student student) {
        mongoTemplate.insert(student);
    }

    @Override
    public int bulkInsertStudents(List<Student> students) {
        BulkOperations bulkOps = mongoTemplate.bulkOps(BulkOperations.BulkMode.UNORDERED, Student.class);
        bulkOps.insert(students);
        return bulkOps.execute().getInsertedCount();
    }

    @Override
    public void insertOneTeacher(Teacher teacher) {
        mongoTemplate.insert(teacher);
    }

    @Override
    public int bulkInsertTeachers(List<Teacher> teachers) {
        BulkOperations bulkOps = mongoTemplate.bulkOps(BulkOperations.BulkMode.UNORDERED, Teacher.class);
        bulkOps.insert(teachers);
        return bulkOps.execute().getInsertedCount();
    }

    @Override
    public void insertOneCourse(Course course) {
        mongoTemplate.insert(course);
    }

    @Override
    public int bulkInsertCourses(List<Course> courses) {
        BulkOperations bulkOps = mongoTemplate.bulkOps(BulkOperations.BulkMode.UNORDERED, Course.class);
        bulkOps.insert(courses);
        return bulkOps.execute().getInsertedCount();
    }
}
