// 
// 
// 

package pers.hdh.service.impl;

import java.sql.SQLException;
import java.util.List;
import pers.hdh.utils.BeanFactory;
import pers.hdh.dao.TaskDao;
import pers.hdh.beans.Task;
import pers.hdh.beans.PageBean;
import pers.hdh.beans.User;
import pers.hdh.service.TaskService;

public class TaskServiceImpl implements TaskService
{
    @Override
    public PageBean<Task> getTasks(final User user, final String category, final String desc, final String state, final int currPage, final int pageSize) throws SQLException {
        final TaskDao dao = (TaskDao)BeanFactory.getBean("TaskDao");
        final Long totalCount = dao.getTotalCount(user, category, desc, state);
        final List<Task> list = dao.getTasks(user, category, desc, state, currPage, pageSize);
        return new PageBean<Task>(list, currPage, pageSize, totalCount.intValue());
    }
    
    @Override
    public PageBean<Task> getTasks(final String category, final String desc, final int currPage, final int pageSize) throws SQLException {
        final TaskDao dao = (TaskDao)BeanFactory.getBean("TaskDao");
        final Long totalCount = dao.getTotalCount(category, desc);
        final List<Task> list = dao.getTasks(category, desc, currPage, pageSize);
        return new PageBean<Task>(list, currPage, pageSize, totalCount.intValue());
    }
    
    @Override
    public Task getByTid(final String tid) throws SQLException {
        final TaskDao dao = (TaskDao)BeanFactory.getBean("TaskDao");
        return dao.getByTid(tid);
    }
    
    @Override
    public void update(final Task task) throws SQLException {
        final TaskDao dao = (TaskDao)BeanFactory.getBean("TaskDao");
        dao.update(task);
    }
    
    @Override
    public void add(final Task task) throws SQLException {
        final TaskDao dao = (TaskDao)BeanFactory.getBean("TaskDao");
        dao.add(task);
    }
    
    @Override
    public void delete(final String tid) throws SQLException {
        final TaskDao dao = (TaskDao)BeanFactory.getBean("TaskDao");
        dao.delete(tid);
    }
    
    @Override
    public void delete(final String[] tids) throws SQLException {
        final TaskDao dao = (TaskDao)BeanFactory.getBean("TaskDao");
        for (final String tid : tids) {
            dao.delete(tid);
        }
    }
}
