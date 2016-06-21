package game.dataEntity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

import game.control.GameListener;

/**
 * 
 * @author Doctor邓
 * 子弹类
 */
public class Bullet {
	private int x;
	private int y;
	private final int WIDTH = 12;
	private final int HEIGHT = 12;
	/**
	 * 子弹存活标识
	 */
	private boolean live;
	/**
	 * 子弹阵营
	 */
	private boolean camp;
	/**
	 * 子弹速度
	 */
	private int speed = 8;
	/**
	 * 子弹方向
	 */
	private Direction dir;
	/**
	 * 记录子弹是哪个坦克发出的
	 */
	private Tank ourTank;
	/**
	 * 子弹的监听器
	 */
	private GameListener listener;
	/**
	 * 普通子弹图片
	 */
	private Image bullet = Toolkit.getDefaultToolkit().getImage("image/bullet/bullet.png");
	/**
	 * 超级子弹图片
	 */
	private Image superBullet = Toolkit.getDefaultToolkit().getImage("image/bullet/superBullet.png");
	/**
	 * 中等子弹图片
	 */
	private Image mediumBullet = Toolkit.getDefaultToolkit().getImage("image/bullet/mediumBullet.png");
	/**
	 * 子弹的威力值
	 */
	private int dps;
	
	public Bullet(int x, int y, boolean camp, Direction dir, Tank ourTank, int dps) {
		this.x = x;
		this.y = y;
		this.camp = camp;
		this.live = true;
		this.dir = dir;
		this.ourTank = ourTank;
		this.dps = dps;
		speedInit(ourTank);
	}
	/**
	 * 子弹移动方法
	 */
	public void move() {
		if (live) {
			switch(dir) {
			case Up:
				setY(y - speed);
				break;
			case Right:
				setX(x + speed);
				break;
			case Down:
				setY(y + speed);
				break;
			case Left:
				setX(x - speed);
				break;
			}
		}
		
	}
	/**
	 * 根据坦克阵营来初始化子弹的速度
	 * @param tank   子弹所属坦克
	 */
	public void speedInit(Tank tank) {
		if (tank.isCamp()) {
			speed = 14;
		} 
	}
	/**
	 * 子弹画图方法
	 * @param g   所需要的画笔
	 */
	public void draw(Graphics g) {
		if (!live) return;
		if (dps == 1) {
			g.drawImage(bullet, getX(), getY(), WIDTH, HEIGHT, null);
		} else if (dps ==2){
			g.drawImage(mediumBullet, getX(), getY(), WIDTH, HEIGHT, null);
		} else if (dps == 3) {
			g.drawImage(superBullet, getX(), getY(), WIDTH, HEIGHT, null);
		}
		
		move();
		overBorder();
	}
	
	/**
	 * 判断子弹是否出界，出界则告诉监听器
	 */
	public void overBorder() {
		if (x > view.GamePanel.WIDTH | x < 0 | y < 0 | 
				y >  view.GamePanel.HEIGHT) {
			listener.bulletOverBorder(this);
			ourTank.setBulletMax(ourTank.getBulletMax() + 1);
		} 
	}
	/**
	 * 子弹爆炸,告诉监听器，且让其坦克的弹夹+1
	 */
	public void bulletBoom() {
		int boomX = x + WIDTH;
		int boomY = y + HEIGHT;
		listener.boomAction(boomX, boomY);
		ourTank.setBulletMax(ourTank.getBulletMax() + 1);
	}
	
	/**
	 * 获得子弹游戏中的所占空间
	 * @return
	 */
	public Rectangle getRect() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
	
	public void setListener(GameListener listener) {
		this.listener = listener;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public boolean isCamp() {
		return camp;
	}

	public void setCamp(boolean camp) {
		this.camp = camp;
	}

	public Direction getDir() {
		return dir;
	}

	public int getSPEED() {
		return speed;
	}

	public int getDps() {
		return dps;
	}

	public void setDps(int dps) {
		this.dps = dps;
	}

	public Tank getOurTank() {
		return ourTank;
	}
}
