// 
// 
// 

package pers.hdh.dao;

import pers.hdh.beans.User;
import java.util.List;
import java.sql.SQLException;
import pers.hdh.beans.Record;

public interface RecordDao
{
    void add(Record p0) throws SQLException;
    
    int update(Record p0) throws SQLException;
    
    long getTotalCount(String p0, String p1, String p2, String p3) throws SQLException;
    
    List<Record> getRecords(String p0, String p1, String p2, String p3, int p4, int p5) throws SQLException;
    
    long getTotalCount(User p0) throws SQLException;
    
    List<Record> getRecords(int p0, int p1, User p2) throws SQLException;
    
    Record getRecord(String p0) throws SQLException;
    
    List<Record> getRecords(User p0) throws SQLException;
    
    long getNews(User p0) throws SQLException;
}
