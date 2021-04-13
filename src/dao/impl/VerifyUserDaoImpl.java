package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.VerifyUserDao;
import util.ConnectionManager;
import util.impl.DBCPConnectionManager;
/**
 * 验证用户名和密码
 * @author Doctor邓
 *
 */
public class VerifyUserDaoImpl implements VerifyUserDao{

	private Connection conn;
	private PreparedStatement ps;
	private ConnectionManager connectionManager;
	
	public VerifyUserDaoImpl() {
		connectionManager = new DBCPConnectionManager();
		conn = connectionManager.getConnection();
	}
	
	@Override
	public boolean verify(String account, String pwd) {
		String sql = "SELECT * FROM users WHERE user_account = ? and "
				+ "user_password = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, account);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
