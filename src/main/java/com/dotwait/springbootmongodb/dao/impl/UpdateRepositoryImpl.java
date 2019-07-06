package com.dotwait.springbootmongodb.dao.impl;

import com.dotwait.springbootmongodb.dao.UpdateRepository;
import com.dotwait.springbootmongodb.entity.Student;
import com.dotwait.springbootmongodb.entity.Teacher;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UpdateRepositoryImpl implements UpdateRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public long pushTeachersToStudent(String name, List<Teacher> teachers) {
        Query query = Query.query(Criteria.where("name").is(name));
        Update update = new Update().set("teachers", teachers);
        UpdateResult updateResult = mongoTemplate.updateMulti(query, update, Student.class);
        return updateResult.getModifiedCount();
    }
}
