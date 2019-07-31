package com.dotwait.springbootmongodb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class BaseDao<T, ID extends Serializable> {
    private MongoTemplate mongoTemplate;
    private Class<T> entityClass;

    @Autowired
    @SuppressWarnings("unchecked")
    public void init(@Qualifier("mongoTemplate") MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
        entityClass = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public List<T> findBy(Query query){
        return mongoTemplate.find(query, entityClass);
    }
}
