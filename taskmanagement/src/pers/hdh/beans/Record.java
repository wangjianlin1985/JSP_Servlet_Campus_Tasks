// 
// 
// 

package pers.hdh.beans;

public class Record
{
    private String rid;
    private Integer state;
    private Long create_at;
    private Long update_at;
    private User user;
    private Task task;
    private Integer is_read;
    private String category;
    private String desc;
    private String stuid;
    
    public String getCategory() {
        return this.category;
    }
    
    public void setCategory(final String category) {
        this.category = category;
    }
    
    public String getDesc() {
        return this.desc;
    }
    
    public void setDesc(final String desc) {
        this.desc = desc;
    }
    
    public String getStuid() {
        return this.stuid;
    }
    
    public void setStuid(final String stuid) {
        this.stuid = stuid;
    }
    
    public Record() {
        this.state = 0;
        this.is_read = 0;
        this.user = new User();
        this.task = new Task();
    }
    
    public String getRid() {
        return this.rid;
    }
    
    public void setRid(final String rid) {
        this.rid = rid;
    }
    
    public Integer getState() {
        return this.state;
    }
    
    public void setState(final Integer state) {
        this.state = state;
    }
    
    public Long getCreate_at() {
        return this.create_at;
    }
    
    public void setCreate_at(final Long create_at) {
        this.create_at = create_at;
    }
    
    public Long getUpdate_at() {
        return this.update_at;
    }
    
    public void setUpdate_at(final Long update_at) {
        this.update_at = update_at;
    }
    
    public User getUser() {
        return this.user;
    }
    
    public void setUser(final User user) {
        this.user = user;
    }
    
    public Task getTask() {
        return this.task;
    }
    
    public void setTask(final Task task) {
        this.task = task;
    }
    
    public Integer getIs_read() {
        return this.is_read;
    }
    
    public void setIs_read(final Integer is_read) {
        this.is_read = is_read;
    }
}
