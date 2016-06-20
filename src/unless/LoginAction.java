package unless;

import java.awt.EventQueue;

import game.gameRun.TankClient;
import view.LoginView;
import view.viewUtil.LoginCartoon;

/**
 * 用于当用户点击登陆按钮时,对用户的操作做一系列处理的线程
 * @author Doctor邓
 *
 */
public class LoginAction extends Thread {
	private LoginView loginView;
	/**
	 * 记录登陆成功与否的相关信息
	 */
	private String loginInfor;
	private String user_account;
	private String user_pwd;
	
	public LoginAction(LoginView loginView) {
		this.loginView = loginView;
		user_account = loginView.getUser_account().getText().trim();
		user_pwd = loginView.getUser_pwd().getText().trim();
	}
	
	@Override
	public void run() {
		LoginCartoon loginCartoon = new LoginCartoon(loginView.getLogoPanel());
		loginCartoon.loginCartoon();
		
		if ("".equals(user_account) || "".equals(user_pwd)
				|| null == user_account || null ==user_pwd) {
			loginView.cancelLoginCartoon();
			loginView.getError_login().setText("用户名或密码为空,请重新输入");
		} 
		else {
			VerifyUserThread verifyUser = new VerifyUserThread(user_account, user_pwd);
			verifyUser.start();
			while (true) {
				if (verifyUser.getLogin() != 0) {
					if (verifyUser.getLogin() ==1 ) {
						gameStart();
						break;
					} else {
						loginView.cancelLoginCartoon();
						loginView.getError_login().setText("用户名或密码错误,请重新输入！");
						break;
					}
				}
			}
		}
	}
	
	/**
	 * 开始游戏
	 */
	private void gameStart() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TankClient tankClient = new TankClient();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		/**
		 * 登陆成功后，释放登陆窗口，并退出托盘图标
		 */
		loginView.exit();
	}
	
	
	
}
