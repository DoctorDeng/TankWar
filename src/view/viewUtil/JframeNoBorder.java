package view.viewUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 * 实现一个JFrame无边框，且能够自由拖动的类
 * @author Doctor邓
 *
 */
public class JframeNoBorder {
	//用于处理拖动事件，表示鼠标按下时的坐标，相对于JFrame
	private int xOld = 0;
	private int yOld = 0;
	
	public void noBorder(JFrame jframe) {
		 jframe.setLayout(null);
		 
		 //处理拖动事件
		 jframe.addMouseListener(new MouseAdapter() {
		  @Override
		  public void mousePressed(MouseEvent e) {
		  xOld = e.getX();
		  yOld = e.getY();
		  }
		 });
		 jframe.addMouseMotionListener(new MouseMotionAdapter() {
		  @Override
		  public void mouseDragged(MouseEvent e) {
		  int xOnScreen = e.getXOnScreen();
		  int yOnScreen = e.getYOnScreen();
		  int xx = xOnScreen - xOld;
		  int yy = yOnScreen - yOld;
		  jframe.setLocation(xx, yy);
		  }
		 });
		 
//		 //JLayeredPane用于添加两个图层的，一个用于背景，一个用于界面
//		 JLayeredPane layeredPane = new JLayeredPane();
//		 layeredPane.setBounds(0, 0, 200, 200);
//		 jframe.add(layeredPane);
		  
//		 //背景Panel
//		 JPanel bgPanel = new JPanel();
//		 bgPanel.setBounds(0, 0, 200, 200);
//		 layeredPane.add(bgPanel);
//		  
//		 //背景图片，添加到背景Panel里面
//		 JLabel bgLabel = new JLabel(new ImageIcon("img/bgImage.png"));
//		 bgPanel.add(bgLabel);
//		  
//		 //主界面，也就是背景上面的一层Panel
//		 JPanel mainPanel = new JPanel();
//		 mainPanel.setBounds(0, 0, 200, 200);
//		 mainPanel.setLayout(null);
//		 layeredPane.add(mainPanel);
		 
//		 //关闭按钮
//		 JButton closeButton = new JButton();
//		 closeButton.setIcon(new ImageIcon("img/closeButton.png"));
//		 closeButton.setBounds(170, 0, 30, 30);
//		 closeButton.addActionListener(new ActionListener() {
//		  @Override
//		  public void actionPerformed(ActionEvent e) {
//		  System.exit(0);
//		  }
//		 });
//		 mainPanel.add(closeButton);
		  
//		 jframe.setBounds(50,50,200,200);
		 jframe.setUndecorated(true);

	}
}
