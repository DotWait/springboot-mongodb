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

@RunWith(SpringRunner.class)
@SpringBootTest
public class PanelInfoTests {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Test
    public void upsertTest(){
        PanelInfo panelInfo = new PanelInfo();
        panelInfo.setDevSN("sn");
        panelInfo.setDevSN("deviceModelName");
        panelInfo.setUpdateTime(System.currentTimeMillis());


        Query query = new Query(Criteria.where("devSN").is("sn"));
        Update update = Update.update("devSN", "sn")
                .set("deviceModelName", "deviceModelName")
                .set("updateTime", System.currentTimeMillis());
        UpdateResult upsert = mongoTemplate.upsert(query, update, PanelInfo.class);
        System.out.println("result => " + upsert.getMatchedCount() + ":"+ upsert.getModifiedCount());
    }

    @Test
    public void insertTest(){
        PanelInfo panelInfo = new PanelInfo();
        panelInfo.setDevSN("sn");
        panelInfo.setDevSN("deviceModelName");
        panelInfo.setUpdateTime(System.currentTimeMillis());
        mongoTemplate.insert(panelInfo);
    }
}
