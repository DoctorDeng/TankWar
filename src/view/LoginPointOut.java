package view;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import view.viewUtil.ImageAdapt;
import view.viewUtil.JFrameSet;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.Font;
/**
 * 用于显示游戏分数上传过程动画和结果信息的frame
 * @author Doctor邓
 *
 */
public class LoginPointOut extends JFrame {
	private JFrameSet noBorder = new JFrameSet();
	private Image image;
	
	public LoginPointOut() {
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		setSize(400, 350);
		noBorder.setFrameCenter(this);
		this.setType(java.awt.Window.Type.UTILITY); 
		JLabel loadLabel = new JLabel("");
		Image  load =  Toolkit.getDefaultToolkit().getImage("image/load/load4.gif");
		loadLabel.setBounds(0, 0,400, 300);
		loadLabel.setIcon(new ImageIcon(load));
		getContentPane().add(loadLabel);
		
		JLabel loginLabel = new JLabel("loging, please wait...");
		loginLabel.setForeground(new Color(51, 204, 255));
		loginLabel.setFont(new Font("Segoe Script", Font.BOLD, 20));
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginLabel.setBounds(0, 300, 400, 42);
		getContentPane().add(loginLabel);
		noBorder.noBorder(this);
		noBorder.setFrameFillet(this);
		
	}
	
	public static void main(String[] args) {
		LoginPointOut  score = new LoginPointOut();
		score.setVisible(true);
	}
}
