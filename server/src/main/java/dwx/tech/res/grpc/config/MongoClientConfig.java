package dwx.tech.res.grpc.config;

import javax.annotation.Resource;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
public class MongoClientConfig extends AbstractMongoConfiguration{
    
    
    @Resource
    private MongoProperties mongoProperties;


    @Override
    protected String getDatabaseName() {
        return mongoProperties.getDatabase();
    }

    @Override
    public MongoClient mongoClient() {
        return new MongoClient(new MongoClientURI(mongoProperties.getUri()));
    }

    /**
     * 去除数据库中冗余的_class字段
     *
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public MappingMongoConverter mappingMongoConverter() throws Exception {
        MappingMongoConverter mappingMongoConverter = super.mappingMongoConverter();
        mappingMongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
        return mappingMongoConverter;
    }

}
