package com.dotwait.springbootmongodb.temp;

import com.mongodb.client.result.UpdateResult;
import org.apache.tomcat.util.net.Nio2Endpoint;
import org.apache.tomcat.util.net.NioEndpoint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UpsertTests {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void hellworldTest(){
        Random random = new Random();
        List<HelloWorld> list= new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String[] worlds = new String[]{""+i,"12", "13"};
            HelloWorld helloWorld = new HelloWorld(""+i, Arrays.asList(worlds));
            list.add(helloWorld);
        }
        mongoTemplate.insert(list, HelloWorld.class);
    }

    @Test
    public void helloTest(){
        Hello hello = new Hello();
        hello.setSn("1234");
        hello.setHash("[{\"id\":1571302979745,\"order\":0,\"description\":\"1111\",\"srcIp\":\"\",\"dstIp\":\"\",\"protocol\":1,\"srcPort\":\"\",\"dstPort\":\"\",\"timeTemplateId\":\"null\",\"action\":1,\"appCategoryId\":\"hostname\",\"appId\":\"null\",\"appCategoryName\":\"hostname\",\"appName\":\"hello.com\"}]");
        mongoTemplate.save(hello);
        Query query = Query.query(Criteria.where("sn").is("1234"));

        Hello one = mongoTemplate.findOne(query, Hello.class);
        System.out.println(one.getHash());
    }

    @Test
    public void indexTest(){
        Index index = new Index();
        index.setName("hello");
//        index.setAge(11);
//        mongoTemplate.insert(index);
        mongoTemplate.insert(index);
    }


    @Test
    public void helloWorldTest2(){
        List<String> queryList = new ArrayList<>();
        queryList.add("0");
        queryList.add("1");
        queryList.add("13");
        Query query = new Query(Criteria.where("worlds").in(queryList));
        Update update = new Update().pullAll("worlds", queryList.toArray());
        UpdateResult updateResult = mongoTemplate.updateMulti(query, update, HelloWorld.class);
//        List<String> values = new ArrayList<>();
//        values.add("qq");
//        values.add("ww");
//        Update update = new Update().push("worlds").each(values);
//        UpdateResult updateResult = mongoTemplate.updateMulti(query, update, HelloWorld.class);
        System.out.println("result ==> " + updateResult.getMatchedCount() + ":"+ updateResult.getModifiedCount());
    }

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
    public void upsertHiTest(){
        String sn = null;
        Integer num = 123;
        List<String> hobby = new ArrayList<>();
        hobby.add("music");
        hobby.add("math");
        hobby.add("sport");
        Query query = Query.query(Criteria.where("sn").is(sn).and("num").is(num));
        Update update = Update.update("other", "hahaha").set("hobby", hobby);
        UpdateResult upsert = mongoTemplate.upsert(query, update, Hi.class);
        System.out.println("matchCount:"+upsert.getMatchedCount()+",modifiedCount:"+upsert.getModifiedCount());
    }

    @Test
    public void insertHiTest(){
        Hi hi = new Hi();
        hi.setNum(2);
        hi.setSn(null);
        mongoTemplate.insert(hi);
    }

    @Test
    public void findHiTest(){
        Query query = Query.query(Criteria.where("sn").is(null).and("num").is(1));
        List<Hi> his = mongoTemplate.find(query, Hi.class);
        his.forEach(System.out::println);
    }

    @Test
    public void findHi2Test(){
        Query query = new Query();
        query.with(Sort.by(Sort.Direction.DESC, "num"));
        List<Hi> his = mongoTemplate.find(query, Hi.class);
        his.forEach(System.out::println);
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
