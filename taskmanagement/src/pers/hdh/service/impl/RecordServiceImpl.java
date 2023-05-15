// 
// 
// 

package pers.hdh.service.impl;

import pers.hdh.beans.User;
import java.util.List;
import pers.hdh.beans.PageBean;
import java.sql.SQLException;
import pers.hdh.utils.BeanFactory;
import pers.hdh.dao.RecordDao;
import pers.hdh.beans.Record;
import pers.hdh.service.RecordService;

public class RecordServiceImpl implements RecordService
{
    @Override
    public int update(final Record record) throws SQLException {
        final RecordDao dao = (RecordDao)BeanFactory.getBean("RecordDao");
        return dao.update(record);
    }
    
    @Override
    public void add(final Record record) throws SQLException {
        final RecordDao dao = (RecordDao)BeanFactory.getBean("RecordDao");
        dao.add(record);
    }
    
    @Override
    public PageBean<Record> getRecords(final String category, final String desc, final String state, final String stuid, final int currPage, final int pageSize) throws SQLException {
        final RecordDao dao = (RecordDao)BeanFactory.getBean("RecordDao");
        final Long totalCount = dao.getTotalCount(category, desc, state, stuid);
        final List<Record> list = dao.getRecords(category, desc, state, stuid, currPage, pageSize);
        return new PageBean<Record>(list, currPage, pageSize, totalCount.intValue());
    }
    
    @Override
    public PageBean<Record> getRecords(final int currPage, final int pageSize, final User user) throws SQLException {
        final RecordDao dao = (RecordDao)BeanFactory.getBean("RecordDao");
        final Long totalCount = dao.getTotalCount(user);
        final List<Record> list = dao.getRecords(currPage, pageSize, user);
        return new PageBean<Record>(list, currPage, pageSize, totalCount.intValue());
    }
    
    @Override
    public Record getRecord(final String rid) throws SQLException {
        final RecordDao dao = (RecordDao)BeanFactory.getBean("RecordDao");
        return dao.getRecord(rid);
    }
    
    @Override
    public List<Record> getRecords(final User user) throws SQLException {
        return ((RecordDao)BeanFactory.getBean("RecordDao")).getRecords(user);
    }
    
    @Override
    public long getNews(final User user) throws SQLException {
        return (long)((RecordDao)BeanFactory.getBean("RecordDao")).getNews(user);
    }
}
