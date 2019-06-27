package com.dotwait.springbootmongodb.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Configuration
@EnableConfigurationProperties(MongoProperties.class)
public class MongoConfig {
    @Autowired
    private MongoProperties mongoProperties;

    @Bean
    public MongoClientOptions getMongoClientOptions() {
        return MongoClientOptions.builder()
                //每个主机允许的最大连接数，这些连接在空闲时将保持在连接池中。
                // 当连接池耗尽后，任何需要连接的操作都将被阻塞并等待可用连接。
                //默认为 100，不能小于 1。
                .connectionsPerHost(8)
                //每个主机的最小连接数，这些连接在空闲时将保持在连接池中。
                //默认为 0，不能小于 0。
                .minConnectionsPerHost(1)
                //允许阻塞的连接线程数乘数。默认为 5，不能小于 1。
                //该值和maxConnectionsPerHost相乘的结果就是连接等待队列的最大值，超出的线程将立即抛出异常。
                //如该值为 5，maxConnectionsPerHost 为 10，则最多可以同时有 50 个线程等待连接。
                .threadsAllowedToBlockForConnectionMultiplier(50)
                //线程从连接池中获取可用连接的最长等待时间（毫秒）。
                //默认为 120,000（120秒），0 表示不等待，负值意味着无限期等待。
                .maxWaitTime(15000)
                //连接池中连接的最大空闲时间（毫秒）。超出空闲时间的连接将被关闭，并在必要时由新建连接替换。
                //默认为 0，表示无限制，不能小于 0。
                .maxConnectionIdleTime(300000)
                //连接池中连接的最大使用寿命（毫秒）。超出使用寿命的连接将被关闭，并在必要时由新建连接替换。
                //默认为 0，表示无限制，不能小于 0。
                .maxConnectionLifeTime(3600000)
                //连接超时时间（毫秒），仅在新建连接时使用。
                //默认为 10,000（10秒），0 表示无限制，不能小于 0。
                .connectTimeout(10000)
                //socket 超时时间（毫秒），用于 I/O 读写操作。
                .socketTimeout(600000)
                //心跳检测频率（毫秒）。该选项用于设定驱动程序每次尝试确定每个服务器当前状态的间隔时间。
                //默认为 10,000（10秒）。
                .heartbeatFrequency(5000)
                //用于心跳检测的连接超时时间（毫秒）。
                //默认为 20,000（20秒）。
                .heartbeatConnectTimeout(5000)
                //用于心跳检测的 socket 超时时间（毫秒）。
                //默认为 20,000（20秒）。
                .heartbeatSocketTimeout(5000)
                //设定当由于网络错误而写入失败时，是否进行重试。
                .retryWrites(true)
                //用于查询、Map-Reduce、聚合、计数的读取首选项。
                //MongoDB 有 5 种 ReadPreference 模式——
                //primary– 主节点，默认模式，只从 primary 节点读取，如果 primary 节点不可用，则报错或抛出异常。
                //primaryPreferred– 首选主节点，优先从 primary 节点读取，如果 primary 节点不可用（如故障转移），则从 secondary 节点读取。
                //secondary– 从节点，只从 secondary 节点读取，如果 secondary 节点不可用，则报错或抛出异常。
                //secondaryPreferred– 优先从 secondary 节点读取，如果没有可用的 secondary 节点，则从 primary 节点读取。
                //nearest– 最近节点，根据网络距离从最近的节点读取，可能是 primary 节点或 secondary 节点。
                //默认为 primary（）。
                .readPreference(ReadPreference.secondaryPreferred())
                .build();
    }

    @Bean
    public MongoClient mongoClient() {
        String userName = mongoProperties.getUserName();
        MongoClient mongoClient;
        if (StringUtils.isBlank(userName)) {
            mongoClient = new MongoClient(
                    new ServerAddress(mongoProperties.getHost()),
                    getMongoClientOptions());
        } else {
            MongoCredential credential = MongoCredential.createCredential(
                    mongoProperties.getUserName(),
                    mongoProperties.getDatabase(),
                    mongoProperties.getPassword().toCharArray());
            mongoClient = new MongoClient(
                    new ServerAddress(mongoProperties.getHost(), mongoProperties.getPort()),
                    credential,
                    getMongoClientOptions());
        }
        return mongoClient;
    }

    @Bean
    public MongoDbFactory mongoDbFactory(){
        return new SimpleMongoDbFactory(mongoClient(), mongoProperties.getDatabase());
    }

    @Bean
    public MongoTemplate mongoTemplate(){
        return new MongoTemplate(mongoDbFactory());
    }

}
