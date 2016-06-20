package view;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import view.viewUtil.ImageAdapt;
import view.viewUtil.JFrameSet;
/**
 * 用于显示游戏分数上传过程动画和结果信息的frame
 * @author Doctor邓
 *
 */
public class ScorePointOut extends JFrame {
	JFrameSet noBorder = new JFrameSet();
	
	public ScorePointOut() {
		getContentPane().setLayout(null);
		setSize(400, 300);
		noBorder.setFrameCenter(this);
		this.setType(java.awt.Window.Type.UTILITY); 
		JLabel loadLabel = new JLabel("");
		Image  load =  Toolkit.getDefaultToolkit().getImage("image/load/load4.gif");
		loadLabel.setBounds(0, 0,400, 300);
		loadLabel.setIcon(new ImageIcon(load));
		getContentPane().add(loadLabel);
		noBorder.noBorder(this);
		noBorder.setFrameFillet(this);
		
	}
	
	public static void main(String[] args) {
		ScorePointOut  score = new ScorePointOut();
		score.setVisible(true);
	}
	
//	public void show() {
//		this.setVisible(true);
//	}
//	
//	public void hide() {
//		this.setVisible(false);
//	}
	
	
}
