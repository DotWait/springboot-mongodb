package com.dotwait.springbootmongodb.dao;

import com.dotwait.springbootmongodb.entity.Course;
import com.dotwait.springbootmongodb.entity.Student;
import com.dotwait.springbootmongodb.entity.Teacher;
import com.dotwait.springbootmongodb.entity.UserInfo;

import java.util.List;

public interface InsertRepository {
    /**
     * 插入一个UserInfo
     * @param userInfo 用户
     */
    void insertOneUser(UserInfo userInfo);

    /**
     * 插入多个UserInfo
     * @param userInfos 用户集合
     * @return 插入的数量
     */
    int insertUsers(List<UserInfo> userInfos);

    /**
     * id不存在则插入一个UserInfo，存在则修改
     * @param userInfo 用户
     */
    void saveOneUser(UserInfo userInfo);

    void insertOneStudent(Student student);

    int bulkInsertStudents(List<Student> students);

    void insertOneTeacher(Teacher teacher);

    int bulkInsertTeachers(List<Teacher> teachers);

    void insertOneCourse(Course course);

    int bulkInsertCourses(List<Course> courses);

}
