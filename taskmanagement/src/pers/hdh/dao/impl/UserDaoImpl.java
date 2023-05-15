// 
// 
// 

package pers.hdh.dao.impl;

import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import java.util.List;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;
import pers.hdh.utils.DataSourceUtils;
import pers.hdh.beans.User;
import pers.hdh.dao.UserDao;

public class UserDaoImpl implements UserDao
{
    @Override
    public void add(final User user) throws SQLException {
        final QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        final String sql = " insert into user (uid, stuid, name, password, institute, major, grade, email, category)  values (?,?,?,?,?,?,?,?,?) ";
        qr.update(sql, new Object[] { user.getUid(), user.getStuid(), user.getName(), user.getPassword(), user.getInstitute(), user.getMajor(), user.getGrade(), user.getEmail(), user.getCategory() });
    }
    
    @Override
    public User getByStuidAndPWD(final String stuid, final String password) throws SQLException {
        final QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        final String sql = " select uid, stuid, name, password, institute, major, grade, email, category, create_at, update_at  from user where stuid=? and password=? limit 1 ";
        return (User)qr.query(sql, (ResultSetHandler)new BeanHandler((Class)User.class), new Object[] { stuid, password });
    }
    
    @Override
    public void update(final User user) throws SQLException {
        final QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        final String sql = " update user set stuid=?, name=?, password=?, institute=?, major=?, grade=?, email=?, category=?  where uid=? ";
        qr.update(sql, new Object[] { user.getStuid(), user.getName(), user.getPassword(), user.getInstitute(), user.getMajor(), user.getGrade(), user.getEmail(), user.getCategory(), user.getUid() });
    }
    
    @Override
    public List<User> getUsers(final String stuid, final String name, final String category, final int currPage, final int pageSize) throws SQLException {
        final QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        final String sql = " select uid, stuid, name, password, institute, major, grade, email, category, create_at  from user where stuid like ? and name like ? and category like ? order by create_at desc limit ?, ? ";
        return (List<User>)qr.query(sql, (ResultSetHandler)new BeanListHandler((Class)User.class), new Object[] { "%" + stuid.trim() + "%", "%" + name.trim() + "%", "%" + category.trim() + "%", (currPage - 1) * pageSize, pageSize });
    }
    
    @Override
    public long getTotalCount(final String stuid, final String name, final String category) throws SQLException {
        final QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        final String sql = " select count(*) from user where stuid like ? and name like ? and category like ? ";
        return (long)qr.query(sql, (ResultSetHandler)new ScalarHandler(), new Object[] { "%" + stuid.trim() + "%", "%" + name.trim() + "%", "%" + category.trim() + "%" });
    }
    
    @Override
    public User getByUid(final String uid) throws SQLException {
        final QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        final String sql = "  select uid, stuid, name, password, institute, major, grade, email, category, create_at  from user where uid=? ";
        return (User)qr.query(sql, (ResultSetHandler)new BeanHandler((Class)User.class), new Object[] { uid });
    }
    
    @Override
    public void delete(final String uid) throws SQLException {
        final QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        final String sql = "delete from user where uid=? ";
        qr.update(sql, (Object)uid);
    }
    
    @Override
    public User getByStuidAndEmail(final String stuid, final String email) throws SQLException {
        final QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        final String sql = " select uid, stuid, name, password, institute, major, grade, email, category, create_at  from user where stuid=? and email=? ";
        return (User)qr.query(sql, (ResultSetHandler)new BeanHandler((Class)User.class), new Object[] { stuid, email });
    }
}
