package game.cartoon;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import game.dataEntity.GameHome;
import view.GamePanel;

/**
 * 老家在白墙(无法被普通子弹打穿的墙)快消失时的动画特效类
 * @author Doctor邓
 *
 */
public class WallCartoon {
	private final int  X = GamePanel.WIDTH/2 - GameHome.WIDTH;
	private final int Y = GamePanel.HEIGHT -20 - 3*GameHome.HEIGHT/2;
	private final int WIDTH = 2*GameHome.WIDTH;
	private final int HEIGHT = 3*GameHome.HEIGHT/2;
	
	/**
	 * 确定是否画普通红墙的标识
	 * <p>true：     画红墙
	 * <p>false:  不画红墙
	 */
	private boolean isWall;
	/**
	 * 确定是否画普通白墙的标识
	 * <p>true：     画白墙
	 * <p>false:  不画白墙
	 */
	private boolean isWhiteWall;
	/**
	 * 动画特效的图片集合
	 */
	private Image[] images = {
			Toolkit.getDefaultToolkit().createImage("image/specialEffects/wall.png"),
			Toolkit.getDefaultToolkit().createImage("image/specialEffects/whiteWall.png")
			};
	/**
	 * 无参构造默认:
	 * <p>isWall = false  isWhiteWall = false
	 * <p>即没有动画特效
	 */
	public WallCartoon() {
		isWall = false;
		isWhiteWall = false;
	}
	/**
	 * 动画的画图方法
	 * @param g   动画所需要的画笔
	 */
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
