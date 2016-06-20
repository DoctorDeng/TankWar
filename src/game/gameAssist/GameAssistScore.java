package game.gameAssist;

import javax.swing.JOptionPane;

import bussiness.UserAction;
import entity.User;
import game.control.DataAdmin;
import view.ScorePointOut;

/**
 * 后台上传分数的线程
 * @author Doctor邓
 *
 */
public class GameAssistScore extends Thread{
	
	private DataAdmin  admin;
	private User user;
	private UserAction userAction;
	
	public GameAssistScore(DataAdmin admin) {
		this.admin = admin;
		this.user = admin.getUser();
		userAction = new UserAction();
	}
	
	
	@Override
	public void run() {
		user.setUser_score(admin.getScore());
		ScorePointOut pointOut = new ScorePointOut();
		try {
			sleep(3000);
		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(userAction.addScore(user)) {
			
		} 
		else {
			
		}
	}

}
