package view;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import view.viewUtil.JFrameSet;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class ScorePointOut extends JFrame {
	private JFrameSet noBorder = new JFrameSet();
	
	public ScorePointOut() {
		getContentPane().setLayout(null);
		setSize(400, 250);
		noBorder.setFrameCenter(this);
//		this.setType(java.awt.Window.Type.UTILITY); 
		JLabel loadLabel = new JLabel("");
		Image  load =  Toolkit.getDefaultToolkit().getImage("image/load/load3.gif");
		loadLabel.setBounds(0, 0,400, 200);
		loadLabel.setIcon(new ImageIcon(load));
		getContentPane().add(loadLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 206, 255));
		panel.setBounds(0, 193, 400, 63);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblUpdateYouSocre = new JLabel("updating you socre, please wait");
		lblUpdateYouSocre.setForeground(new Color(240, 248, 255));
		lblUpdateYouSocre.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblUpdateYouSocre.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateYouSocre.setBounds(0, 0, 400, 63);
		panel.add(lblUpdateYouSocre);
		noBorder.noBorder(this);
		noBorder.setFrameFillet(this);
		
	}
	
	public static void main(String[] args) {
		ScorePointOut  score = new ScorePointOut();
		score.setVisible(true);
	}
}
