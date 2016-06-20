package game.cartoon;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import game.dataEntity.GameHome;
import view.GamePanel;

/**
 * 老家在白墙快消失时的动画特效类
 * @author Doctor邓
 *
 */
public class WallCartoon {
	private final int  X = GamePanel.WIDTH/2 - GameHome.WIDTH;
	private final int Y = GamePanel.HEIGHT -20 - 3*GameHome.HEIGHT/2;
	private final int WIDTH = 2*GameHome.WIDTH;
	private final int HEIGHT = 3*GameHome.HEIGHT/2;
	
	private boolean isWall;
	private boolean isWhiteWall;
	
	private Image[] images = {
			Toolkit.getDefaultToolkit().createImage("image/specialEffects/wall.png"),
			Toolkit.getDefaultToolkit().createImage("image/specialEffects/whiteWall.png")
			};
	public WallCartoon() {
		isWall = false;
		isWhiteWall = false;
	}
	
	public void draw(Graphics g) {
		/**
		 * 默认是不出现动画的
		 */
		if (isWall) {
			g.drawImage(images[0], X, Y, WIDTH, HEIGHT, null);
		}
		if (isWhiteWall) {
			g.drawImage(images[1], X, Y, WIDTH, HEIGHT, null);
		}
	}

	public boolean isWall() {
		return isWall;
	}

	public void setWall(boolean isWall) {
		this.isWall = isWall;
	}

	public boolean isWhiteWall() {
		return isWhiteWall;
	}

	public void setWhiteWall(boolean isWhiteWall) {
		this.isWhiteWall = isWhiteWall;
	}
	
}
