// 
// 
// 

package pers.hdh.dao.impl;

import org.apache.commons.dbutils.handlers.BeanHandler;
import pers.hdh.beans.User;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import java.util.List;
import java.util.ArrayList;
import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;
import pers.hdh.utils.DataSourceUtils;
import pers.hdh.beans.Record;
import pers.hdh.dao.RecordDao;

public class RecordDaoImpl implements RecordDao
{
    @Override
    public void add(final Record record) throws SQLException {
        final QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        final String sql = " insert into record (rid, state, uid, tid) values (?, ?, ?, ? )";
        qr.update(sql, new Object[] { record.getRid(), record.getState(), record.getUser().getUid(), record.getTask().getTid() });
    }
    
    @Override
    public int update(final Record record) throws SQLException {
        final QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update record set state=?, is_read=? where 1=1 ";
        final List<Object> paramsList = new ArrayList<Object>();
        paramsList.add(record.getState());
        paramsList.add(record.getIs_read());
        if (record.getRid() != null) {
            sql = String.valueOf(sql) + " and rid=? ";
            paramsList.add(record.getRid());
        }
        else {
            sql = String.valueOf(sql) + " and uid=? and tid=? ";
            paramsList.add(record.getUser().getUid());
            paramsList.add(record.getTask().getTid());
        }
        return qr.update(sql, paramsList.toArray());
    }
    
    @Override
    public long getTotalCount(final String category, final String desc, final String state, final String stuid) throws SQLException {
        final QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        final String sql = "SELECT COUNT(*) FROM record r, `user` u, task t WHERE r.uid=u.uid AND r.tid=t.tid  AND t.category LIKE ? AND t.`desc` LIKE ? AND r.state LIKE ? AND u.stuid LIKE ? ";
        return (long)qr.query(sql, (ResultSetHandler)new ScalarHandler(), new Object[] { "%" + category.trim() + "%", "%" + desc.trim() + "%", "%" + state + "%", "%" + stuid.trim() + "%" });
    }
    
    @Override
    public List<Record> getRecords(final String category, final String desc, final String state, final String stuid, final int currPage, final int pageSize) throws SQLException {
        final QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        final String sql = "SELECT r.rid, r.state,r.create_at, r.update_at, u.stuid, t.category, t.`desc`  FROM record r, `user` u, task t WHERE r.uid=u.uid AND r.tid=t.tid  AND t.category LIKE ? AND t.`desc` LIKE ? AND r.state LIKE ? AND u.stuid LIKE ?  ORDER BY r.update_at DESC LIMIT ?, ? ";
        return (List<Record>)qr.query(sql, (ResultSetHandler)new BeanListHandler((Class)Record.class), new Object[] { "%" + category.trim() + "%", "%" + desc.trim() + "%", "%" + state + "%", "%" + stuid.trim() + "%", (currPage - 1) * pageSize, pageSize });
    }
    
    @Override
    public long getTotalCount(final User user) throws SQLException {
        final QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        final String sql = "select count(*) from record where uid= ? and state in (3,4) ";
        return (long)qr.query(sql, (ResultSetHandler)new ScalarHandler(), new Object[] { user.getUid() });
    }
    
    @Override
    public List<Record> getRecords(final int currPage, final int pageSize, final User user) throws SQLException {
        final QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        final String sql = "select rid, state, update_at, is_read from record where uid = ? and state in (3,4)  order by update_at desc limit ?, ?";
        return (List<Record>)qr.query(sql, (ResultSetHandler)new BeanListHandler((Class)Record.class), new Object[] { user.getUid(), (currPage - 1) * pageSize, pageSize });
    }
    
    @Override
    public Record getRecord(final String rid) throws SQLException {
        final QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        final String sql = "select * from record where rid = ? limit 1";
        return (Record)qr.query(sql, (ResultSetHandler)new BeanHandler((Class)Record.class), new Object[] { rid });
    }
    
    @Override
    public List<Record> getRecords(final User user) throws SQLException {
        final QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        final String sql = "select * from record where uid = ? ";
        return (List<Record>)qr.query(sql, (ResultSetHandler)new BeanListHandler((Class)Record.class), new Object[] { user.getUid() });
    }
    
    @Override
    public long getNews(final User user) throws SQLException {
        final QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        final String sql = "select count(*) from record where uid= ? and state in (3,4) and is_read <> 1 ";
        return (long)qr.query(sql, (ResultSetHandler)new ScalarHandler(), new Object[] { user.getUid() });
    }
}
