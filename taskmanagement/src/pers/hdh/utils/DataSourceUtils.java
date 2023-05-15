// 
// 
// 

package pers.hdh.utils;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Connection;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtils
{
    private static ComboPooledDataSource ds;
    private static ThreadLocal<Connection> tl;
    
    static {
        DataSourceUtils.ds = new ComboPooledDataSource();
        DataSourceUtils.tl = new ThreadLocal<Connection>();
    }
    
    public static Connection getConnection() throws SQLException {
        Connection conn = DataSourceUtils.tl.get();
        if (conn == null) {
            conn = DataSourceUtils.ds.getConnection();
            DataSourceUtils.tl.set(conn);
        }
        return conn;
    }
    
    public static DataSource getDataSource() {
        return (DataSource)DataSourceUtils.ds;
    }
}
