package dao;

/**
 * 验证用户信息与数据库的信息是否匹的接口
 * @author Doctor邓
 *
 */
public interface VerifyUserDao {
	/**
	 * 验证用户的用户名和密码是否与数据库中的匹配
	 * @param account  用户名
	 * @param pwd      用户密码
	 * @return         用户名和密码与数据库中的用户信息匹配,返回ture.不匹配，返回false
	 */
	public boolean verify(String account, String pwd);
}
