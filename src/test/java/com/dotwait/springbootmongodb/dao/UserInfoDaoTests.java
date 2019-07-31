package com.dotwait.springbootmongodb.dao;

import com.dotwait.springbootmongodb.entity.Student;
import com.dotwait.springbootmongodb.entity.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoDaoTests {
    @Autowired
    private UserInfoDaoImpl userInfoDao;

    @Test
    public void userInfoDaoFindTest(){
        List<UserInfo> userInfos = userInfoDao.findByWhere("Make");
        userInfos.forEach(userInfo -> System.out.println(userInfo));
    }
}
