// 
// 
// 

package pers.hdh.beans;

public class User
{
    private String uid;
    private String stuid;
    private String name;
    private String password;
    private String institute;
    private String major;
    private Integer grade;
    private String email;
    private String category;
    private Long create_at;
    private Long update_at;
    
    public String getUid() {
        return this.uid;
    }
    
    public void setUid(final String uid) {
        this.uid = uid;
    }
    
    public String getStuid() {
        return this.stuid;
    }
    
    public void setStuid(final String stuid) {
        this.stuid = stuid;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(final String password) {
        this.password = password;
    }
    
    public String getInstitute() {
        return this.institute;
    }
    
    public void setInstitute(final String institute) {
        this.institute = institute;
    }
    
    public String getMajor() {
        return this.major;
    }
    
    public void setMajor(final String major) {
        this.major = major;
    }
    
    public Integer getGrade() {
        return this.grade;
    }
    
    public void setGrade(final Integer grade) {
        this.grade = grade;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(final String email) {
        this.email = email;
    }
    
    public String getCategory() {
        return this.category;
    }
    
    public void setCategory(final String category) {
        this.category = category;
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
}
