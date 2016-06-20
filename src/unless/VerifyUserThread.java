package unless;

/**
 * 后台验证用户名和密码是否正确的线程类
 * @author Doctor邓
 *
 */
public class VerifyUserThread extends Thread {

	private String user_account;
	private String user_pwd;
	private VerifyUserAction verifyUser;
	/**
	 * 登陆成功与否的标识<p>
	 * 默认为 0    即登陆验证还未完成<p>
	 * 1                为登陆成功<p>
	 * 2                为登陆失败<p>
	 */
	private int login = 0;
	
	public VerifyUserThread(String user_account, String user_pwd) {
		this.user_account = user_account;
		this.user_pwd = user_pwd;
		verifyUser = new VerifyUserAction();
	}
	
	@Override
	public void run() {
		boolean loginInfor = verifyUser.verify(user_account, user_pwd);
		if (loginInfor) {
			login = 1;
		} else {
			login = 2;
		}
	}

	public int getLogin() {
		return login;
	}

}
