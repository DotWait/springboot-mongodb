package com.dotwait.springbootmongodb.index;

import com.dotwait.springbootmongodb.dao.InsertRepository;
import com.dotwait.springbootmongodb.entity.CompoundIndex;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompoundIndexTests {
    @Autowired
    private MongoTemplate mongoTemplate;

    private static Random random = new Random();

    @Autowired
    private InsertRepository insertRepository;

    @Test
    public void compoundIndexTest(){
        for(int j=0;j<10;j++){
            BulkOperations bulkOps = mongoTemplate.bulkOps(BulkOperations.BulkMode.UNORDERED, CompoundIndex.class);
            List<CompoundIndex> list = new ArrayList<>(1000000);
            for(int i=0;i<1000000;i++){
                CompoundIndex compoundIndex = new CompoundIndex();
                compoundIndex.setName("name"+i);
                compoundIndex.setLocation("loca"+i);
                compoundIndex.setCity("city"+i);
                List<String> hobbies = new ArrayList<>();
                hobbies.add("hobby"+random.nextInt(100000));
                hobbies.add("hobby"+random.nextInt(100000));
                hobbies.add("hobby"+random.nextInt(100000));
                compoundIndex.setHobbies(hobbies);
                list.add(compoundIndex);
            }
            bulkOps.insert(list);
            bulkOps.execute();
        }
    }

    @Test
    public void queryAndSort(){
        Query query = new Query();
        Criteria criteria = new Criteria().and("name").ne("am");
        query.addCriteria(criteria).with(Sort.by(Sort.Direction.ASC, "id")).limit(100);
        long start = System.currentTimeMillis();
        List<CompoundIndex> list = mongoTemplate.find(query, CompoundIndex.class);
        long end = System.currentTimeMillis();
        System.out.println("end - start = "+(end-start)+"ms,size="+list.size());
    }

}
