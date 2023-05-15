// 
// 
// 

package pers.hdh.beans;

public class Task
{
    private String tid;
    private String category;
    private String desc;
    private Long create_at;
    private Long update_at;
    private Integer state;
    private User user;
    
    public Task() {
        this.state = 0;
    }
    
    public String getTid() {
        return this.tid;
    }
    
    public void setTid(final String tid) {
        this.tid = tid;
    }
    
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
    
    public Integer getState() {
        return this.state;
    }
    
    public void setState(final Integer state) {
        this.state = state;
    }
    
    public User getUser() {
        return this.user;
    }
    
    public void setUser(final User user) {
        this.user = user;
    }
}
