// 
// 
// 

package pers.hdh.service.impl;

import pers.hdh.utils.MailUtils;
import java.util.List;
import pers.hdh.beans.PageBean;
import java.sql.SQLException;
import pers.hdh.utils.BeanFactory;
import pers.hdh.dao.UserDao;
import pers.hdh.beans.User;
import pers.hdh.service.UserService;

public class UserServiceImpl implements UserService
{
    @Override
    public void add(final User user) throws SQLException {
        final UserDao dao = (UserDao)BeanFactory.getBean("UserDao");
        dao.add(user);
    }
    
    @Override
    public User getByStuidAndPWD(final String stuid, final String password) throws SQLException {
        final UserDao dao = (UserDao)BeanFactory.getBean("UserDao");
        return dao.getByStuidAndPWD(stuid, password);
    }
    
    @Override
    public void update(final User user) throws SQLException {
        final UserDao dao = (UserDao)BeanFactory.getBean("UserDao");
        dao.update(user);
    }
    
    @Override
    public PageBean<User> getUsers(final String stuid, final String name, final String category, final int currPage, final int pageSize) throws SQLException {
        final UserDao dao = (UserDao)BeanFactory.getBean("UserDao");
        final List<User> list = dao.getUsers(stuid, name, category, currPage, pageSize);
        final Long totalCount = dao.getTotalCount(stuid, name, category);
        return new PageBean<User>(list, currPage, pageSize, totalCount.intValue());
    }
    
    @Override
    public User getByUid(final String uid) throws SQLException {
        final UserDao dao = (UserDao)BeanFactory.getBean("UserDao");
        return dao.getByUid(uid);
    }
    
    @Override
    public void delete(final String uid) throws SQLException {
        final UserDao dao = (UserDao)BeanFactory.getBean("UserDao");
        dao.delete(uid);
    }
    
    @Override
    public void delete(final String[] uids) throws SQLException {
        final UserDao dao = (UserDao)BeanFactory.getBean("UserDao");
        for (final String uid : uids) {
            dao.delete(uid);
        }
    }
    
    @Override
    public User getByStuidAndEmail(final String stuid, final String email) throws Exception {
        final UserDao dao = (UserDao)BeanFactory.getBean("UserDao");
        final User user = dao.getByStuidAndEmail(stuid, email);
        if (user != null) {
            MailUtils.sendMail(user.getEmail(), user.getUid());
        }
        return user;
    }
}
