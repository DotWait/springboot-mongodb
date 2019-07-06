package com.dotwait.springbootmongodb.dao;

import com.dotwait.springbootmongodb.entity.Teacher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UpdateRepositoryTests {
    @Autowired
    private UpdateRepository updateRepository;

    private static List<Teacher> teachers;

    private static Teacher teacher;

    @Before
    public void init(){
        initTeachers(10);
        initTeacher();
    }

    private void initTeachers(int num){
        teachers = new ArrayList<>(num);
        for (int i=0;i<num;i++){
            Teacher teacher = new Teacher();
            teacher.setName("Saily");
            List<String> courses = new ArrayList<>();
            courses.add("Chinese");
            courses.add("English");
            teacher.setTechCourses(courses);
            teachers.add(teacher);
        }
    }

    private void initTeacher(){
        teacher = new Teacher();
        teacher.setName("Saily");
        List<String> courses = new ArrayList<>();
        courses.add("Chinese");
        courses.add("English");
        teacher.setTechCourses(courses);
    }

    @Test
    public void pushTeachersToStudentTest(){
        updateRepository.pushTeachersToStudent("John0", teachers);
    }
}
