// 
// 
// 

package pers.hdh.service;

import java.sql.SQLException;
import pers.hdh.beans.Task;
import pers.hdh.beans.PageBean;
import pers.hdh.beans.User;

public interface TaskService
{
    PageBean<Task> getTasks(User p0, String p1, String p2, String p3, int p4, int p5) throws SQLException;
    
    PageBean<Task> getTasks(String p0, String p1, int p2, int p3) throws SQLException;
    
    Task getByTid(String p0) throws SQLException;
    
    void update(Task p0) throws SQLException;
    
    void add(Task p0) throws SQLException;
    
    void delete(String p0) throws SQLException;
    
    void delete(String[] p0) throws SQLException;
}
