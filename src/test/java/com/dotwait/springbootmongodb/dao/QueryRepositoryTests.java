package com.dotwait.springbootmongodb.dao;

import com.dotwait.springbootmongodb.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryRepositoryTests {
    @Autowired
    private QueryRepository queryRepository;

    @Test
    public void findAllStudentTest() {
        List<Student> allStudents = queryRepository.findAllStudents();
        printStudents(allStudents);
    }

    @Test
    public void findStudentByNameTest() {
        Student john = queryRepository.findStudentByName("John0");
        System.out.println(john);
    }

    @Test
    public void findStudentRegexTest() {
        List<Student> studentRegex = queryRepository.findStudentRegex(null, "hn", 81, null);
        printStudents(studentRegex);
    }

    @Test
    public void findStudentTextSearchTest() {
        List<Student> studentTextSearch = queryRepository.findStudentTextSearch(null, "John", null, null);
        printStudents(studentTextSearch);
    }

    @Test
    public void countStudentsTest(){
        long count = queryRepository.countStudents(null, "John", null, null);
        System.out.println(count);
    }

    private void printStudents(List<Student> students) {
        students.forEach(System.out::println);
        System.out.println(students.size());
    }
}
