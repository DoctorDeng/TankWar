package game.gameAssist;

import java.awt.EventQueue;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import bussiness.UserAction;
import entity.User;
import game.control.DataAdmin;
import game.control.TankClient;
import view.LoginPointOut;
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
	private JFrame frame;
	private ScorePointOut pointOut = new ScorePointOut();
	
	public GameAssistScore(DataAdmin admin, JFrame frame) {
		this.admin = admin;
		this.user = admin.getUser();
		userAction = new UserAction();
		this.frame = frame;
	}
	
	
	@Override
	public void run() {
		user.setUser_score(admin.getScore());
		pointOut.setVisible(true);
		frame.setVisible(false);
		
		Timer timer = new Timer();  
        timer.schedule(new TimerTask() {  
            public void run() {  
            	if(userAction.addScore(user)) {
            		JOptionPane.showMessageDialog(null, "分数上传成功！");
            	} 
            	else {
            		JOptionPane.showMessageDialog(null, "分数上传失败！");
            	}
            	pointOut.setVisible(false);
        		frame.setVisible(true);
            }  
        }, 3000);
	}

}
