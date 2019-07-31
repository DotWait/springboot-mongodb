package com.dotwait.springbootmongodb.dao;

import com.dotwait.springbootmongodb.entity.Student;
import com.dotwait.springbootmongodb.entity.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryRepositoryTests {
    @Autowired
    private QueryRepository queryRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void findOneUserTest(){
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("currentTimeMillis="+currentTimeMillis);
        long lastWholePoint = currentTimeMillis - currentTimeMillis % (3600 * 1000L);
        System.out.println("lastWholePoint="+lastWholePoint);
        Date date = new Date(lastWholePoint);
        System.out.println(date);
        Query query = Query.query(Criteria.where("time").is(date));
        UserInfo one = mongoTemplate.findOne(query, UserInfo.class);
        System.out.println(one);
    }

    @Test
    public void findTest(){
        long oneTime = 1562432400000L;
        System.out.println(new Date(oneTime));
        long zeroTime = oneTime - (oneTime + 28800000)%(24L * 3600 * 1000);
        System.out.println(zeroTime+",date:"+new Date(zeroTime));
    }

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
