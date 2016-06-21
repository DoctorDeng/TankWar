package game.dataEntity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

import view.GamePanel;

/**
 * 游戏中需要玩家保护的家的实体类
 * @author Doctor邓
 *
 */
public class GameHome {
	private int x;
	private int y;
	public static final int WIDTH = 50;
	public static final int HEIGHT = 50;
	/**
	 * 老家存活标识,默认存活
	 * ture为存活,false死亡
	 */
	private boolean live;
	/**
	 * 老家存活时图片
	 */
	private final Image LIVE = Toolkit.getDefaultToolkit().getImage("image/home/homeLive.png");
	/**
	 * 老家死亡时图片
	 */
	private final Image DEAD = Toolkit.getDefaultToolkit().getImage("image/home/homeDead.png");
	
	public GameHome() {
		x = GamePanel.WIDTH/2 - WIDTH/2;
		y = GamePanel.HEIGHT - HEIGHT - 20;
		live = true;
	}
	
	/**
	 * 老家画图方法
	 */
	public void draw(Graphics g) {
		if (live) {
			g.drawImage(LIVE, x, y, WIDTH, HEIGHT, null);
		}
		else {
			g.drawImage(DEAD, x, y, WIDTH, HEIGHT, null);
		}
	}
	/**
	 * 获得老家所占游戏的空间
	 * @return   
	 */
	public Rectangle getRect() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}
}
