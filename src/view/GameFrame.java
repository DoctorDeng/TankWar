package view;

import java.awt.Toolkit;

import javax.swing.JFrame;

import game.gameRun.GameListener;
import game.gameRun.GamePaint;
/**
 * 
 * @author Doctor邓
 * 游戏主界面
 */
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
	
	//游戏画面
	private GamePanel gamePanel;
	private GameListener listener;
	public GameFrame(GamePaint gamePaint, GameListener listener) {
		
		X = (ScreenWidth - GameWidth)/2;
		Y = (ScreenHeight - GameHeight)/2;
		gamePanel = new GamePanel(gamePaint);
		this.listener = listener;
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
		setVisible(true);
	}
	
	public GamePanel getGamePanel() {
		return gamePanel;
	}
}
