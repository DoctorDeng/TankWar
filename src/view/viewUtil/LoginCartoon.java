package view.viewUtil;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

/**
 * 登陆头像变换的动画线程类
 * @author Doctor邓
 *
 */
public class LoginCartoon  {
	private JPanel jpanel;
	private final Image TOUXIANG = Toolkit.getDefaultToolkit().getImage("image/loginView/touxiang.png"); 
	public int j=0;
	private int i = 1;
	
	public LoginCartoon(JPanel jpanel) {
		this.jpanel = jpanel;
	}
	
	
	public void run() {
//		loginCartoon();
		while (i<100) {
			jpanel.getGraphics().setColor(new Color(22,154,128));
			jpanel.getGraphics().clearRect(i, 0, 1,TOUXIANG.getHeight(null));
			jpanel.getGraphics().drawImage(TOUXIANG, 1 + i, 0, null);
			jpanel.repaint();
			try {
				Thread.currentThread().sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
		}
	}
	
	/**
	 * 登陆动画
	 */
	public void loginCartoon() {
		jpanel.getGraphics().setColor(new Color(22,154,128));
		while (i<300) {
			jpanel.getGraphics().clearRect(i, 0, 1,TOUXIANG.getHeight(null));
			jpanel.getGraphics().drawImage(TOUXIANG, 1 + i, 0, null);
			jpanel.repaint();
			try {
				Thread.currentThread();
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
		}
	}
	
	/**
	 * 取消登录动画
	 */
	public void cancelLoginCartoon() {
		while (i<100) {
			jpanel.getGraphics().setColor(new Color(22,154,128));
			jpanel.getGraphics().clearRect(i + TOUXIANG.getWidth(null), 0, 1,TOUXIANG.getHeight(null));
			jpanel.getGraphics().drawImage(TOUXIANG, 1 + i, 0, null);
			jpanel.repaint();
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i--;
		}
	}
	
}
