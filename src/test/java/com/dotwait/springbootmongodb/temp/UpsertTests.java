package com.dotwait.springbootmongodb.temp;

import com.mongodb.client.result.UpdateResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UpsertTests {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void upsertTest(){
        String sn = "sn2";
        String hash = "12345678";
        Query query = Query.query(Criteria.where("sn").is(sn));
        Update update = new Update().set("sn", sn).set("hash", hash);
        UpdateResult upsert = mongoTemplate.upsert(query, update, Hello.class);
        System.out.println("matchCount:"+upsert.getMatchedCount()+",modifiedCount:"+upsert.getModifiedCount());
    }

    @Test
    public void insertTest(){
        Hello hello = new Hello();
        hello.setId("2222");
        hello.setSn("555");
        hello.setFather("789");
        mongoTemplate.insert(hello, "helloFather1");
    }

    @Test
    public void helloExpireTest(){
        long now = System.currentTimeMillis();
        HelloExpire helloExpire = new HelloExpire();
        helloExpire.setStoreId(1);
        helloExpire.setExpireAt(new Date(now + 60*1000));
        mongoTemplate.insert(helloExpire);
    }

    @Test
    public void expireUpdateTest(){
        long now = System.currentTimeMillis();
        Query query = Query.query(Criteria.where("storeId").is(1));
        Update update = Update.update("expireAt", new Date(now + 240*1000));
        mongoTemplate.updateMulti(query, update, HelloExpire.class);
    }

    @Test
    public void expireTimestampTest(){
        long now = System.currentTimeMillis();
        ExpireTimestamp expireTimestamp = new ExpireTimestamp();
        expireTimestamp.setStoreId(2);
        expireTimestamp.setExpireAt(now + 60*1000);
        mongoTemplate.insert(expireTimestamp);
    }
}
