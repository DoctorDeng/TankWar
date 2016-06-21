package entity;
/**
 * 游戏的用户实体类,含有如下信息:
 * <p>user_account :  用户账户账号
 * <p>user_pwd     :  用户账户密码
 * <p>user_socre   :  用户的游戏分数
 * @author Doctor邓
 *
 */
public class User {
	/**
	 * 用户账号
	 */
	private String user_account;
	/**
	 * 用户密码
	 */
	private String user_pwd;
	/**
	 * 用户游戏分数,默认为 : 0
	 */
	private int user_score = 0;
	
	public User() {
		
	}
	
	/**
	 * 构造方法,通过指定的用户账号和密码构造一个用户对象
	 * @param user_account    ：指定的用户账号
	 * @param user_pwd        ：指定的用户密码
	 */
	public User(String user_account, String user_pwd) {
		this.user_account = user_account;
		this.user_pwd = user_pwd;
	}

	public String getUser_account() {
		return user_account;
	}

	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public int getUser_score() {
		return user_score;
	}

	public void setUser_score(int user_score) {
		this.user_score = user_score;
	}
}
