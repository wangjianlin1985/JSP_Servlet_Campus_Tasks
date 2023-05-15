// 
// 
// 

package pers.hdh.dao.impl;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pers.hdh.beans.Task;
import java.util.List;
import java.sql.SQLException;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.dbutils.QueryRunner;
import pers.hdh.utils.DataSourceUtils;
import pers.hdh.beans.User;
import pers.hdh.dao.TaskDao;

public class TaskDaoImpl implements TaskDao
{
    @Override
    public long getTotalCount(final User user, final String category, final String desc, final String state) throws SQLException {
        final QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = " SELECT COUNT(*) FROM task t LEFT JOIN  (SELECT tid, state FROM record r WHERE uid = ?) temp  ON t.tid=temp.tid where t.category like ? and t.desc like ? ";
        if (state != null && state.trim().length() > 0) {
            sql = String.valueOf(sql) + " and IFNULL(temp.state, 0) = " + state;
        }
        return (long)qr.query(sql, (ResultSetHandler)new ScalarHandler(), new Object[] { user.getUid(), "%" + category.trim() + "%", "%" + desc.trim() + "%" });
    }
    
    @Override
    public long getTotalCount(final String category, final String desc) throws SQLException {
        final QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        final String sql = " SELECT COUNT(*) FROM task WHERE category LIKE ? AND `desc` LIKE ? ";
        return (long)qr.query(sql, (ResultSetHandler)new ScalarHandler(), new Object[] { "%" + category.trim() + "%", "%" + desc.trim() + "%" });
    }
    
    @Override
    public List<Task> getTasks(final User user, final String category, final String desc, final String state, final int currPage, final int pageSize) throws SQLException {
        final QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = " SELECT t.tid, t.category, t.desc, t.create_at, IFNULL(temp.state,0) state FROM task t LEFT JOIN  (SELECT tid, state FROM record r WHERE uid = ?) temp  ON t.tid=temp.tid where t.category like ? and t.desc like ? ";
        if (state != null && state.trim().length() > 0) {
            sql = String.valueOf(sql) + " and IFNULL(temp.state,0) = " + state;
        }
        sql = String.valueOf(sql) + " order by create_at desc limit ?, ? ";
        return (List<Task>)qr.query(sql, (ResultSetHandler)new BeanListHandler((Class)Task.class), new Object[] { user.getUid(), "%" + category.trim() + "%", "%" + desc.trim() + "%", (currPage - 1) * pageSize, pageSize });
    }
    
    @Override
    public List<Task> getTasks(final String category, final String desc, final int currPage, final int pageSize) throws SQLException {
        final QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        final String sql = " SELECT tid, category, `desc`, create_at, update_at FROM task  WHERE category LIKE ? AND `desc` LIKE ? ORDER BY create_at DESC LIMIT ?, ? ";
        return (List<Task>)qr.query(sql, (ResultSetHandler)new BeanListHandler((Class)Task.class), new Object[] { "%" + category.trim() + "%", "%" + desc.trim() + "%", (currPage - 1) * pageSize, pageSize });
    }
    
    @Override
    public Task getByTid(final String tid) throws SQLException {
        final QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        final String sql = "select tid, category, `desc`, create_at, update_at from task where tid=? ";
        return (Task)qr.query(sql, (ResultSetHandler)new BeanHandler((Class)Task.class), new Object[] { tid });
    }
    
    @Override
    public void update(final Task task) throws SQLException {
        final QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        final String sql = " update task set category=?, `desc`=? where tid=? ";
        qr.update(sql, new Object[] { task.getCategory(), task.getDesc(), task.getTid() });
    }
    
    @Override
    public void add(final Task task) throws SQLException {
        final QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        final String sql = "insert into task (tid, category, `desc`) values (?, ?, ?)";
        qr.update(sql, new Object[] { task.getTid(), task.getCategory(), task.getDesc() });
    }
    
    @Override
    public void delete(final String tid) throws SQLException {
        final QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        final String sql = "delete from task where tid=? limit 1 ";
        qr.update(sql, (Object)tid);
    }
}
