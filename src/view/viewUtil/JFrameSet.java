package view.viewUtil;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import com.sun.awt.AWTUtilities;

/**
 * 实现一个JFrame无边框，且能够自由拖动的类
 * @author Doctor邓
 *
 */
public class JFrameSet {
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
	
	/**
	 * 设置JFrame为圆角
	 * @param frame
	 */
	public void setFrameFillet(JFrame frame) {
		AWTUtilities.setWindowShape(frame, new RoundRectangle2D.Double(  
	            0.0D, 0.0D, frame.getWidth(), frame.getHeight(), 15.0D,  
	            15.0D));  
	}
	
	/**
	 * 将frame 居中显示
	 * @param frame
	 */
	public void setFrameCenter(JFrame frame) {
		int screen_width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screen_height = Toolkit.getDefaultToolkit().getScreenSize().height;
		frame.setLocation((screen_width - frame.getWidth())/2, (screen_height - frame.getHeight())/2);
	}
	
	/**
	 * 设置fram没有任务栏图标
	 * @param frame
	 */
	public void setFrameNoIco(JFrame frame) {
		frame.setType(java.awt.Window.Type.UTILITY);
	}
}
