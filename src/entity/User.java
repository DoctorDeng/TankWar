package entity;
/**
 * 游戏的用户实体类
 * @author Doctor邓
 *
 */
public class User {
	/**
	 * 用户账号
	 */
	private String user_account;
	private String user_pwd;
	private int user_score;
	
	public User() {
		
	}
	
	public User(String user_account, String user_pwd) {
		this.user_account = user_account;
		this.user_pwd = user_pwd;
		this.user_score = 0;
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
