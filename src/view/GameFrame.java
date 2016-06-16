package view;

import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;

import com.sun.awt.AWTUtilities;

import game.gameRun.GameListener;
import game.gameRun.GamePaint;
import view.viewUtil.JframeNoBorder;
/**
 * 
 * @author Doctor邓
 * 游戏主界面
 */
import view.viewUtil.SetTray;
public class GameFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3835947192949511757L;
	public static final int GameHeight = 700;
	public static final int GameWidth = 1100;
	private final String GameName = "坦克大战";
	private final int X;
	private final int Y;
	private final int ScreenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
	private final int ScreenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
	private SetTray setTray;
	
	//游戏画面
	private GamePanel gamePanel;
	private GameListener listener;
	public GameFrame(GamePaint gamePaint, GameListener listener) {
		
		X = (ScreenWidth - GameWidth)/2;
		Y = (ScreenHeight - GameHeight)/2;
		gamePanel = new GamePanel(gamePaint);
		this.listener = listener;
		setTray = new SetTray();
		viewInit();
	}
	
	/**
	 * 初始化界面
	 */
	private void viewInit() {
		setTitle(GameName);
		setSize(GameWidth, GameHeight);
		setLocation(X, Y);
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(gamePanel);
		addKeyListener(listener);
		this.setType(java.awt.Window.Type.UTILITY); 
		setTray.setTrayToFrame(this);
		
		new JframeNoBorder().noBorder(this);
		/**
		 * 设置窗体为圆角矩形
		 */
		AWTUtilities.setWindowShape(this, new RoundRectangle2D.Double(  
	            0.0D, 0.0D, this.getWidth()-6, this.getHeight()-20, 15.0D,  
	            15.0D));  
		setVisible(true);
	}
	
	public GamePanel getGamePanel() {
		return gamePanel;
	}
}
