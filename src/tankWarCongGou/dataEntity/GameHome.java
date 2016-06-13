package tankWarCongGou.dataEntity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

import tankWarCongGou.view.GamePanel;

/**
 * 游戏中需要玩家保护的家
 * @author Doctor邓
 *
 */
public class GameHome {
	private int x;
	private int y;
	public static final int WIDTH = 50;
	public static final int HEIGHT = 50;
	private boolean live;
	private final Image LIVE = Toolkit.getDefaultToolkit().getImage("image/home/homeLive.png");
	private final Image DEAD = Toolkit.getDefaultToolkit().getImage("image/home/homeDead.png");
	
	public GameHome() {
		x = GamePanel.WIDTH/2 - WIDTH/2;
		y = GamePanel.HEIGHT - HEIGHT - 20;
		live = true;
	}
	
	public void draw(Graphics g) {
		if (live) {
			g.drawImage(LIVE, x, y, WIDTH, HEIGHT, null);
		}
		else {
			g.drawImage(DEAD, x, y, WIDTH, HEIGHT, null);
		}
	}
	
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
