package com.dotwait.springbootmongodb.temp;

import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "index1")
@CompoundIndexes({
        @CompoundIndex(name = "name_age", def = "{\"name\":1,\"age\":1}", unique = true),
})

public class Index {
    private String name;
    @Indexed(sparse = true)
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

