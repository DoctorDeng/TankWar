package view.reference;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.theme.SubstanceLightAquaTheme;

public class TestEvent extends JComponent implements ComponentListener, WindowFocusListener {
	private JFrame frame;

	private Boolean isHiding = false, isShowing = false, start = false;

	private Image background;

	private Point p;

	// 获得当前屏幕快照
	public void updateBackground() {
		try {
			Robot rbt = new Robot();
			Toolkit tk = Toolkit.getDefaultToolkit();
			Dimension dim = tk.getScreenSize();
			background = rbt.createScreenCapture(new Rectangle(0, 0, (int) dim.getWidth(), (int) dim.getHeight()));
		} catch (Exception ex) {
		}
	}

	// 将窗口掉离出屏幕以获得纯粹的背景图象
	public void refresh() {
		if (start == true) {
			this.updateBackground();
			frame.setLocation(p);
			if (p.x < 0 || p.y < 0)
				frame.setLocation(0, 0);
			this.repaint();
		}
	}

	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Hidden");
	}

	// 窗口移动时
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("moved");
		this.repaint();
	}

	// 窗口改变大小时
	public void componentResized(ComponentEvent e) {
//		 TODO Auto-generated method stub
		System.out.println("resized");
		this.repaint();
	}

	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("shown");
	}

	// 窗口得到焦点后,用refresh()方法更新界面
	public void windowGainedFocus(WindowEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("gainedFocus");
		refresh();
		start = false;
	}

	// 窗口失去焦点后,将其移出屏幕
	public void windowLostFocus(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("lostFocus");
		if (frame.isShowing() == true) {
			System.out.println("visible");
		} else {
			System.out.println("invisible");
		}
		start = true;
		p = frame.getLocation();
		frame.setLocation(-2000, -2000);
	}

	public TestEvent(JFrame frame) {
		super();
		this.frame = frame;
		updateBackground();
		this.setSize(200, 120);
		this.setVisible(true);
		frame.addComponentListener(this);
		frame.addWindowFocusListener(this);

		// TODO Auto-generated constructor stub
	}

	// 绘制外观,注意,其中 pos,offset 是为了将特定部分的图象贴到窗口上
	public void paintComponent(Graphics g) {
		Point pos = this.getLocationOnScreen();
		Point offset = new Point(-pos.x, -pos.y);
		g.drawImage(background, offset.x, offset.y, null);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new SubstanceLookAndFeel());
			UIManager.put("swing.boldMetal", false);
			if (System.getProperty("substancelaf.useDecorations") == null) {
				JFrame.setDefaultLookAndFeelDecorated(true);
			}
			System.setProperty("sun.awt.noerasebackground", "true");
			SubstanceLookAndFeel.setCurrentTheme(new SubstanceLightAquaTheme());
		} catch (Exception e) {
			System.err.println("Oops!  Something went wrong!");
		}

		JFrame frame = new JFrame("Transparent Window");
		((JPanel) frame.getContentPane()).setOpaque(true);
		TestEvent t = new TestEvent(frame);
		t.setLayout(new BorderLayout());
		JButton button = new JButton("This is a button");
		t.add("North", button);
		JLabel label = new JLabel("This is a label");
		t.add("South", label);
		frame.getContentPane().add("Center", t);
		frame.pack();
		frame.setSize(150, 100);
		frame.show();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
