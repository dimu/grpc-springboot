package dwx.tech.res.grpc.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "project")
public class Project {

    @Id
    private long id;
    
    @Field("basepath")
    private String basepath;
    
    @Field("project_type")
    private String projectType;
    
    @Field("uid")
    private long uid;
    
    @Field("group_id")
    private long groupId;
    
    @Field("icon")
    private String icon;
    
    @Field("color")
    private String color;
    
    @Field("add_time")
    private long addTime;
    
    @Field("up_time")
    private long upTime;
    
    @Field("tag")
    private Object[] tag;
    
    @Field("is_json5")
    private boolean json;
    
    @Field("strice")
    private boolean strice;
    
    @Field("is_mock_open")
    private boolean mockOpen;
    
    @Field("env")
    private Object[] env;
    
    @Field("members")
    private Object[] members;
    
    @Field("switch_notice")
    private boolean switchNotice;
    
}
