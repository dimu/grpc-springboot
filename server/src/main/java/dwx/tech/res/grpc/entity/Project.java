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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBasepath() {
        return basepath;
    }

    public void setBasepath(String basepath) {
        this.basepath = basepath;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public long getAddTime() {
        return addTime;
    }

    public void setAddTime(long addTime) {
        this.addTime = addTime;
    }

    public long getUpTime() {
        return upTime;
    }

    public void setUpTime(long upTime) {
        this.upTime = upTime;
    }

    public Object[] getTag() {
        return tag;
    }

    public void setTag(Object[] tag) {
        this.tag = tag;
    }

    public boolean isJson() {
        return json;
    }

    public void setJson(boolean json) {
        this.json = json;
    }

    public boolean isStrice() {
        return strice;
    }

    public void setStrice(boolean strice) {
        this.strice = strice;
    }

    public boolean isMockOpen() {
        return mockOpen;
    }

    public void setMockOpen(boolean mockOpen) {
        this.mockOpen = mockOpen;
    }

    public Object[] getEnv() {
        return env;
    }

    public void setEnv(Object[] env) {
        this.env = env;
    }

    public Object[] getMembers() {
        return members;
    }

    public void setMembers(Object[] members) {
        this.members = members;
    }

    public boolean isSwitchNotice() {
        return switchNotice;
    }

    public void setSwitchNotice(boolean switchNotice) {
        this.switchNotice = switchNotice;
    }
    
    
    
}
