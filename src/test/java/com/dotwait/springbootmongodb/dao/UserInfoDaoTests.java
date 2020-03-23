package com.dotwait.springbootmongodb.dao;

import com.dotwait.springbootmongodb.entity.Student;
import com.dotwait.springbootmongodb.entity.User1;
import com.dotwait.springbootmongodb.entity.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
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

    @Test
    public void test() throws IOException {
        File file = new File("D:/test/test.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        User1 user1 = new User1();
        user1.setName("hello");
        user1.setAge(11);
        user1.setDescription("kitty");
        objectOutputStream.writeObject(user1);
        objectOutputStream.flush();
        objectOutputStream.close();
    }
}
