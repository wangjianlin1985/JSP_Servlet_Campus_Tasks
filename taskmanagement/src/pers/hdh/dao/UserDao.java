// 
// 
// 

package pers.hdh.dao;

import java.util.List;
import java.sql.SQLException;
import pers.hdh.beans.User;

public interface UserDao
{
    void add(User p0) throws SQLException;
    
    User getByStuidAndPWD(String p0, String p1) throws SQLException;
    
    void update(User p0) throws SQLException;
    
    List<User> getUsers(String p0, String p1, String p2, int p3, int p4) throws SQLException;
    
    long getTotalCount(String p0, String p1, String p2) throws SQLException;
    
    User getByUid(String p0) throws SQLException;
    
    void delete(String p0) throws SQLException;
    
    User getByStuidAndEmail(String p0, String p1) throws SQLException;
}
