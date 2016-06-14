package util.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import util.SqlUtil;

/**
 * 使用数据库连接池Dbcp来获取数据库的连接
 * @Description:  DBCP 配置类
 * @author        Doctor邓
 * @date          2016/6/2
 */
public class DBCPUtil implements SqlUtil{
	/** 数据源, static */
	private static DataSource DS;
	/** 配置文件   */
	private static final String configFile = "conf/dbcp.properties";

	/**
	 * @Title: getConn
	 * @Description: TODO (获取数据库的连接)
	 * @param @return     设定文件
	 * @return Connection 返回类型
	 * @throws
	 */
	public Connection getConn() {
		Connection conn = null;
		if (DS != null) {
			try {
				conn = DS.getConnection();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
			/**
			 * 将JDBC的自动提交事务设置为false
			 */
//			try {
//				conn.setAutoCommit(false);
//			} catch (SQLException e) {
//				// TODO 自动生成的 catch 块
//				e.printStackTrace();
//			}
			return conn;
		}
		return conn;
	}
	
	/**
	 * <p>Title: </p>
	 * <p>Description:</p>
	 */
	public DBCPUtil() {
		initDbcp();
	}
	
	/**
	 * 通过配置文件初始化数据源
	 */
	private static void initDbcp() {
		Properties props = new Properties();
		try {
			/**
			 * 读取配置文件
			 */
			FileInputStream fileStream = new FileInputStream(configFile);
			props.load(fileStream);
			/**
			 * 通过DBCP提供的工厂类，将配置文件信息传给工厂，并拿到一个数据源
			 */
			DS = BasicDataSourceFactory.createDataSource(props);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
