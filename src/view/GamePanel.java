package view;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import game.gameRun.GamePaint;
import game.gameRun.GameRepaint;

public class GamePanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Panel坐标
	 */
	private final int X;
	private final int Y;
	public  static final int WIDTH = 800;
	public  static final int HEIGHT = GameFrame.GameHeight;
	private GamePaint gamePaint;
	
	public GamePanel(GamePaint gamePaint) {
		X = 0;
		Y = 0;
		this.gamePaint = gamePaint;
		init();
	}
	
	/**
	 * GamePanel初始化
	 */
	public void init() {
		setSize(WIDTH, HEIGHT);
		setLocation(X, Y);
		setBackground(Color.BLACK);
		new Thread(new GameRepaint(this)).start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
    	update(g);
	}
	
	public void update(Graphics g) {
		g.setColor(Color.black);
		gamePaint.draw(g);
	}
}
