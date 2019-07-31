package com.dotwait.springbootmongodb.dao;

import com.dotwait.springbootmongodb.entity.UserInfo;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserInfoDaoImpl extends BaseDao<UserInfo, String> {
    public List<UserInfo> findByWhere(String userName){
        Query query = Query.query(Criteria.where("userName").is(userName));
        return findBy(query);
    }
}
