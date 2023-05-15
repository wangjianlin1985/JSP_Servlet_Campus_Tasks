// 
// 
// 

package pers.hdh.service;

import pers.hdh.beans.PageBean;
import java.sql.SQLException;
import pers.hdh.beans.User;

public interface UserService
{
    void add(User p0) throws SQLException;
    
    User getByStuidAndPWD(String p0, String p1) throws SQLException;
    
    void update(User p0) throws SQLException;
    
    PageBean<User> getUsers(String p0, String p1, String p2, int p3, int p4) throws SQLException;
    
    User getByUid(String p0) throws SQLException;
    
    void delete(String p0) throws SQLException;
    
    void delete(String[] p0) throws SQLException;
    
    User getByStuidAndEmail(String p0, String p1) throws Exception;
}
