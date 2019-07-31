package com.dotwait.springbootmongodb.dao.impl;

import com.dotwait.springbootmongodb.dao.QueryRepository;
import com.dotwait.springbootmongodb.entity.Student;
import com.mongodb.operation.AggregateOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueryRepositoryImpl implements QueryRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Student> findAllStudents() {
        return mongoTemplate.findAll(Student.class);
    }

    @Override
    public Student findStudentByName(String name) {
        Query query = Query.query(Criteria.where("name").is(name));
        return mongoTemplate.findOne(query, Student.class);
    }

    @Override
    public List<Student> findStudentRegex(Integer stuNum, String name, Integer age, String city) {
        Criteria criteria = new Criteria();
        if (stuNum != null) {
            criteria.and("stuNum").regex(String.valueOf(stuNum));
        }
        if (name != null) {
            criteria.and("name").regex(name);
        }
        if (age != null) {
            criteria.and("age").regex(String.valueOf(age));
        }
//        Query query = new Query().addCriteria(criteria);
//        return mongoTemplate.find(query, Student.class);
        AggregationOperation match = new MatchOperation(criteria);
        Aggregation aggregation = Aggregation.newAggregation(match);
        AggregationResults<Student> student = mongoTemplate.aggregate(aggregation, "student", Student.class);
        return student.getMappedResults();
    }

    @Override
    public List<Student> findStudentTextSearch(Integer stuNum, String name, Integer age, String city) {
        TextCriteria textCriteria = new TextCriteria();
        if (stuNum != null){
            textCriteria.matching(String.valueOf(stuNum));
        }
        if (name != null){
            textCriteria.matching(name);
        }
        if (age != null){
            textCriteria.matching(String.valueOf(age));
        }
        if (city != null){
            textCriteria.matching(city);
        }
        textCriteria.caseSensitive(false);
        Query query = Query.query(textCriteria);
        return mongoTemplate.find(query, Student.class);
    }

    @Override
    public long countStudents(Integer stuNum, String name, Integer age, String city) {
        Criteria criteria = new Criteria();
        if (stuNum != null) {
            criteria.and("stuNum").regex(String.valueOf(stuNum));
        }
        if (name != null) {
            criteria.and("name").regex(name);
        }
        if (age != null) {
            criteria.and("age").regex(String.valueOf(age));
        }
        Query query = new Query().addCriteria(criteria);
        return mongoTemplate.count(query, Student.class);
    }
}
