package com.dotwait.springbootmongodb.dao;

import com.dotwait.springbootmongodb.entity.PicRecord;
import com.dotwait.springbootmongodb.entity.Screen;
import com.dotwait.springbootmongodb.temp.*;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.operation.DistinctOperation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.acl.Group;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScreenRepositoryTests {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void query(){
        UnwindOperation unwindOperation = UnwindOperation.newUnwind().path("screenIds").noArrayIndex().skipNullAndEmptyArrays();
//        LookupOperation lookupOperation = LookupOperation.newLookup().from("screen").localField("screenIds").foreignField("id").as("newScreen");
        ProjectionOperation projectionOperation = Aggregation.project("screenIds");
//        GroupOperation group = Aggregation.group("screenIds").count().as("sum");
        Aggregation aggregation = Aggregation.newAggregation(unwindOperation, projectionOperation);
        List<String> picRecord = mongoTemplate.aggregate(aggregation, "picRecord", ScreenId.class).getMappedResults()
                .stream().map(ScreenId::getScreenIds).distinct().collect(Collectors.toList());
        picRecord.forEach(System.out::println);
        System.out.println("count==>"+picRecord.size());

    }

    private static final long ONE_DAY = 24L*3600*1000;
    @Test
    public void insertMany(){
        List<PicRecord> picRecords = new ArrayList<>();
        for (int i=0;i<10;i++){
            List<String> screenIds = new ArrayList<>();
            screenIds.add("screenId"+i);
            PicRecord picRecord = new PicRecord("picUrl"+i, "storagePath"+i, screenIds, System.currentTimeMillis()-ONE_DAY);
            picRecords.add(picRecord);
        }
        mongoTemplate.insert(picRecords, PicRecord.class);
    }

    @Test
    public void findTest(){
        Query query = Query.query(Criteria.where("id").is("5deb1b7a17f4e713dc43701d"));
        List<Screen> foreigns = mongoTemplate.find(query, Screen.class);
        foreigns.forEach(System.out::println);
        System.out.println(foreigns.size());
    }

    @Test
    public void insert(){
        List<Screen> screens = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            screens.add(new Screen("name"+i));
        }
        mongoTemplate.insert(screens, Screen.class);

        Query query = new Query();
        List<Screen> screensList = mongoTemplate.find(query, Screen.class);
        List<PicRecord> picRecords = new ArrayList<>();
        int i = 0;
        for (Screen screen : screensList) {
            List<String> screenIds = new ArrayList<>();
            screenIds.add(screen.getId());
            picRecords.add(new PicRecord("picUrl" + i++, screenIds));
        }
        for (int j = 0; j < 5; j++) {
            List<String> screenIds = new ArrayList<>();
            screenIds.add("id"+j);
            picRecords.add(new PicRecord("delPicUrl"+j, screenIds));
        }
        mongoTemplate.insert(picRecords, PicRecord.class);
    }

    @Test
    public void push(){
        List<PicRecord> picRecords = mongoTemplate.find(new Query(), PicRecord.class);
        List<String> picUrls = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            picUrls.add(picRecords.get(i).getPicUrl());
        }
        Query query = Query.query(Criteria.where("picUrl").in(picUrls));
        Update update = new Update().push("screenIds", "secondId");
        UpdateResult updateResult = mongoTemplate.updateMulti(query, update, PicRecord.class);
        System.out.println("找到:"+updateResult.getMatchedCount()+"，修改："+updateResult.getModifiedCount());
    }

    @Test
    public void push2(){
        Query query = Query.query(Criteria.where("screenIds").is("secondId"));
        Update update = new Update().push("screenIds", "secondId2");
        UpdateResult updateResult = mongoTemplate.updateMulti(query, update, PicRecord.class);
        System.out.println("找到:"+updateResult.getMatchedCount()+"，修改："+updateResult.getModifiedCount());
    }

    @Test
    public void pull(){
        Update update = new Update().pull("screenIds", "secondId2");
        UpdateResult updateResult = mongoTemplate.updateMulti(new Query(), update, PicRecord.class);
        System.out.println("找到:"+updateResult.getMatchedCount()+"，修改："+updateResult.getModifiedCount());
    }

    @Test
    public void insertNull(){
        mongoTemplate.insert(new PicRecord("picUrl123", new ArrayList<>()));
        mongoTemplate.insert(new PicRecord("picUrl456", null));
    }

    @Test
    public void queryNull(){
        Criteria criteria = new Criteria().orOperator(Criteria.where("screenIds").exists(false), Criteria.where("screenIds").size(0));
        Query query = Query.query(criteria);
        List<PicRecord> picRecords = mongoTemplate.find(query, PicRecord.class);
        picRecords.forEach(System.out::println);
        System.out.println("count:"+picRecords.size());
    }

    @Test
    public void insertAll(){
        List<Foreign> foreigns = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Foreign foreign = new Foreign();
            foreign.setId(i+"");
            foreign.setName("foreign"+i);
            foreigns.add(foreign);
        }
        mongoTemplate.insert(foreigns, Foreign.class);
        List<Foreign> foreignList = mongoTemplate.find(new Query(), Foreign.class);
        List<Local> locals = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Local local = new Local();
            local.setName("local"+i);
            local.setPid(foreignList.get(i).getId());
            locals.add(local);
        }
        for (int i = 5; i < 10; i++) {
            Local local = new Local();
            local.setName("local"+i);
            locals.add(local);
        }
        mongoTemplate.insert(locals, Local.class);
    }

    @Test
    public void lookupTest(){
        LookupOperation lookupOperation = LookupOperation.newLookup().from("foreign").localField("pid").foreignField("_id").as("sub");
        Aggregation aggregation = Aggregation.newAggregation(lookupOperation);
        List<NewLocal> local = mongoTemplate.aggregate(aggregation, "local", NewLocal.class).getMappedResults();
        local.forEach(System.out::println);
        System.out.println(local.size());
    }
}
