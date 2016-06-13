package util.impl;

import java.sql.Connection;
import java.sql.SQLException;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import util.SqlUtil;
/**
 * @Description:     C3p0数据源配置类
 * @author Doctor邓
 * @date   2016/6/2 
 */
public class C3P0Util implements SqlUtil {
	/**
	 * 创建一个数据源
	 */
	private ComboPooledDataSource ds = new ComboPooledDataSource();
	private Connection conn = null;
	
	@SuppressWarnings("finally")
	@Override
	public Connection getConn() {
		try {
			conn = ds.getConnection();
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			return conn;
		}
	}

}
