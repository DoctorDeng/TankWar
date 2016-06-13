package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import dao.CommanCURDDao;
import util.SqlUtil;
import util.impl.DBCPUtil;
/**
 * 通用的数据库CURD操作的实现类
 * @author Doctor邓
 *
 */
public class CommenCURDDaoImpl implements CommanCURDDao{
	
	private Connection conn;
	private PreparedStatement ps;
	private SqlUtil sqlUtil;
	
	public CommenCURDDaoImpl() {
		sqlUtil = new DBCPUtil();
		conn = sqlUtil.getConn();
	}
	
	@Override
	public boolean insert(String sql, List<String> str) {
		try {
			ps = conn.prepareStatement(sql);
			for (int i=0; i<str.size(); i++) {
				ps.setString(i + 1, str.get(i));
			}
			
			int j = ps.executeUpdate();
			if (j==0) return false;
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(String sql, List<String> str) {
		try {
			ps = conn.prepareStatement(sql);
			for (int i=0; i<str.size(); i++) {
				ps.setString(i + 1, str.get(i));
			}
			int j = ps.executeUpdate();
			if (j==0) return false;
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(String sql, List<String> str) {
		try {
			ps = conn.prepareStatement(sql);
			for (int i=0; i<str.size(); i++) {
				ps.setString(i + 1, str.get(i));
			}
			int j = ps.executeUpdate();
			if (j==0) return false;
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public Vector<String[]> select(String sql, List<String> str) {
		Vector<String[]> vector = new Vector<String[]>();
		try {
			ps = conn.prepareStatement(sql);
			for (int i=0; i<str.size(); i++) {
				ps.setString(i + 1, str.get(i));
			}
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			
			while(rs.next()) {
				String[] dataStr = new String[metaData.getColumnCount()];
				for (int i=0; i<dataStr.length; i++) {
					dataStr[i] = rs.getString(i+1);
				}
				vector.add(dataStr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			return vector;
		}
	}
}
