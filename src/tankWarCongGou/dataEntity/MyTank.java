package tankWarCongGou.dataEntity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class MyTank extends Tank {
	/**
	 * 坦克的血条累
	 */
	private HPbar hpBar = new HPbar();
	/**
	 * 坦克对应方向的图片
	 */
	Image up = Toolkit.getDefaultToolkit().createImage("image/myTank/myTankUp.gif");
	Image down = Toolkit.getDefaultToolkit().createImage("image/myTank/myTankDown.gif");
	Image left = Toolkit.getDefaultToolkit().createImage("image/myTank/myTankLeft.gif");
	Image right = Toolkit.getDefaultToolkit().createImage("image/myTank/myTankRight.gif");
	/**
	 * 坦克的生命值
	 */
	private int life;
	/**
	 * 坦克最大生命值
	 */
	private final int MAX_LIFE = 5;
	public MyTank(int x, int y) {
		//初始化坦克的初始位置
		setX(x);
		setY(y);
		setCamp(true);
		setDir(Direction.Up);
		life = MAX_LIFE;
	}

	@Override
	public void draw(Graphics g) {
		//当坦克不存活时，直接退出
		if (!isLive()) {
			return ;
		} 
		g.drawImage(selectImage(), getX(), getY(), null);
		hpBar.draw(g);
		move();
	}
	
	public Image selectImage() {
		switch(getDir()) {
			case Up: 
				return up;
			case Down: 
				return down;
			case Left: 
				return left;
			case Right: 
				return right;
			default:
				return up;
		}
	}

	//坦克的血条类
	private class HPbar {
		public void draw(Graphics g) {
			Color c = g.getColor();
			g.setColor(Color.RED);
			g.drawRect(getX()+5, getY()-10, getWIDTH()-10, 5);
			int width = (getWIDTH()-10) * life /MAX_LIFE;
			g.fillRect(getX()+5, getY()-10, width, 5);
			g.setColor(c);
		}
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getMAX_LIFE() {
		return MAX_LIFE;
	}
}
