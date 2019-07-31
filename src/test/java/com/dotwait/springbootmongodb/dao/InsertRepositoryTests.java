package com.dotwait.springbootmongodb.dao;

import com.dotwait.springbootmongodb.entity.Course;
import com.dotwait.springbootmongodb.entity.Student;
import com.dotwait.springbootmongodb.entity.Teacher;
import com.dotwait.springbootmongodb.entity.UserInfo;
import com.dotwait.springbootmongodb.utils.Citys;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InsertRepositoryTests {
    @Autowired
    private InsertRepository insertRepository;

    private static Random random = new Random();

    private UserInfo userInfo;

    private List<UserInfo> userInfos;

    private Student student;

    private List<Student> students;

    private Teacher teacher;

    private List<Teacher> teachers;

    private Course course;

    private List<Course> courses;

    @Before
    public void init() {
        initOneUser();
        initUsers(10);
        initOneStudent();
        initStudents(10);
        initOneTeacher();
        initTeachers(10);
        initOneCourse();
        initCourses(10);
    }

    private void initOneUser() {
        long currentTimeMillis = System.currentTimeMillis();
        long lastWholePoint = currentTimeMillis - currentTimeMillis % (3600 * 1000L);
        Date date = new Date(lastWholePoint);
        userInfo = new UserInfo();
        userInfo.setAge(random.nextInt(100));
        userInfo.setCity(Citys.getCity(random.nextInt(3)));
        userInfo.setUserName("Make");
        userInfo.setTime(date);
    }

    private void initUsers(int num) {
        userInfos = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setAge(random.nextInt(100));
            userInfo.setCity(Citys.getCity(random.nextInt(3)));
            userInfo.setUserName("Make" + i);
            userInfo.setTime(new Date());
            userInfos.add(userInfo);
        }
    }

    private void initOneStudent() {
        student = new Student();
        student.setName("John");
        student.setAge(random.nextInt(100));
        student.setHobby(new String[]{"read books"});
        student.setStuNum(random.nextInt(1000));
        student.setCity(Citys.getCity(random.nextInt(3)));
    }

    private void initStudents(int num) {
        students = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            Student student = new Student();
            student.setName("John" + i);
            student.setAge(random.nextInt(100));
            student.setHobby(new String[]{"read books"});
            student.setStuNum(random.nextInt(1000));
            student.setCity(Citys.getCity(random.nextInt(3)));
            students.add(student);
        }
    }

    private void initOneTeacher() {
        teacher = new Teacher();
        teacher.setName("cate");
    }

    private void initTeachers(int num) {
        teachers = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            Teacher teacher = new Teacher();
            teacher.setName("cate" + i);
            teachers.add(teacher);
        }
    }

    private void initOneCourse() {
        course = new Course();
        course.setName("Chinese");
        course.setNumofStu(0);
        course.setTeacher("cate");
    }

    private void initCourses(int num) {
        courses = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            Course course = new Course();
            course.setName("Chinese" + i);
            course.setNumofStu(0);
            course.setTeacher("cate" + i);
            courses.add(course);
        }
    }

    @Test
    public void insertOneUserTest() {
        insertRepository.insertOneUser(userInfo);
    }

    @Test
    public void insertUsersTest() {
        insertRepository.insertUsers(userInfos);
    }

    @Test
    public void saveOneUserTest() {
        insertRepository.saveOneUser(userInfo);
    }

    @Test
    public void insertOneStudentTest() {
        insertRepository.insertOneStudent(student);
    }

    @Test
    public void insertStudentsTest() {
        insertRepository.bulkInsertStudents(students);
    }

    @Test
    public void insertOneTeacherTest() {
        insertRepository.insertOneTeacher(teacher);
    }

    @Test
    public void insertTeachersTest() {
        insertRepository.bulkInsertTeachers(teachers);
    }

    @Test
    public void insertOneCourseTest() {
        insertRepository.insertOneCourse(course);
    }

    @Test
    public void insertCoursesTest() {
        insertRepository.bulkInsertCourses(courses);
    }
}
