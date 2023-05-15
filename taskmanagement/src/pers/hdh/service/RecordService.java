// 
// 
// 

package pers.hdh.service;

import java.util.List;
import pers.hdh.beans.User;
import pers.hdh.beans.PageBean;
import java.sql.SQLException;
import pers.hdh.beans.Record;

public interface RecordService
{
    int update(Record p0) throws SQLException;
    
    void add(Record p0) throws SQLException;
    
    PageBean<Record> getRecords(String p0, String p1, String p2, String p3, int p4, int p5) throws SQLException;
    
    PageBean<Record> getRecords(int p0, int p1, User p2) throws SQLException;
    
    Record getRecord(String p0) throws SQLException;
    
    List<Record> getRecords(User p0) throws SQLException;
    
    long getNews(User p0) throws SQLException;
}
