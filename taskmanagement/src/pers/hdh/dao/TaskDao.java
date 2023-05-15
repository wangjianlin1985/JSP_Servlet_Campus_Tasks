// 
// 
// 

package pers.hdh.dao;

import pers.hdh.beans.Task;
import java.util.List;
import java.sql.SQLException;
import pers.hdh.beans.User;

public interface TaskDao
{
    long getTotalCount(User p0, String p1, String p2, String p3) throws SQLException;
    
    long getTotalCount(String p0, String p1) throws SQLException;
    
    List<Task> getTasks(User p0, String p1, String p2, String p3, int p4, int p5) throws SQLException;
    
    List<Task> getTasks(String p0, String p1, int p2, int p3) throws SQLException;
    
    Task getByTid(String p0) throws SQLException;
    
    void update(Task p0) throws SQLException;
    
    void add(Task p0) throws SQLException;
    
    void delete(String p0) throws SQLException;
}
