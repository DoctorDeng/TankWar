package game.dataEntity;

import java.awt.Graphics;
import java.awt.Rectangle;

import game.gameRun.GameListener;
import view.GamePanel;

/**
 * 
 * @author Doctor邓
 * 坦克的抽象类
 */
public abstract  class Tank {
	//坦克的速度
	private int speed;
	//坦克的x, y轴坐标
	private int x;
	private int y;
	//坦克的宽度和高度
	public static final int WIDTH = 50;
	public static final int HEIGHT = 50;
	//坦克在碰撞墙前的坐标
	private int oldX;
	private int oldY;
	//坦克的方向 
	private Direction dir;
	//坦克的运动状态,默认为false即不可移动状态，true为可移动状态
	private boolean motionStatus;
	//坦克的 存活标识,默认为true即为存活状态，false为死亡状态
	private boolean live;
	//坦克的阵营，true为我方阵营，false为敌方阵营
	private boolean camp;
	//坦克的子弹上限，决定了游戏最多能同时存在几个坦克发出的子弹
	private int bulletMax;

	/**
	 * 坦克的dps即开抢后子弹的威力
	 */
	private int dps;
	
	//用于设置坦克具体方向的变量
//	private boolean up;
//	private boolean right;
//	private boolean down;
//	private boolean left;
	
	//坦克身上的监听器
	private GameListener gameListener;

	public Tank() {
		this.speed = 4;
		this.motionStatus = false;  
		this.live = true;
//		up = true;
		bulletMax = 1;  //默认只能同时打一发子弹
		dps = 1;        //默认坦克子弹的威力只能打穿红墙
	}
	
	/**
	 * 坦克移动的方法
	 */
	public void move() {
		// TODO 自动生成的方法存根
		setOldX(getX());
		setOldY(getY());
		
		//当坦克状态为可移动时，才能移动坦克
		if (isMotionStatus()) {
			//通过坦克方向来决定坦克的移动
			switch(getDir()) {
			case Up:
				setY(getY() - getSpeed());
				break;
			case Right:
				setX(getX() + getSpeed());
				break;
			case Down:
				setY(getY() + getSpeed());
				break;
			case Left:
				setX(getX() - getSpeed());
				break;
			}
		}
		hitWall();
	}
	
	/**
	 * 坦克开火的方法
	 */
	public void fire() {
		/**
		 * 当坦克的弹夹为空时，直接退出，无法开火
		 */
		if (bulletMax<1) return;
		int bulletX = getX() + getWIDTH()/2 -5;
		int bulletY = getY() + getHEIGHT()/2 -5;
		if (live) {
			gameListener.fireAction(bulletX, bulletY, isCamp(), getDir(), this, dps);
		}
		bulletMax--;
	}
	
	/**
	 * 坦克画自己方法
	 */
	public abstract void draw(Graphics g);
	
	/**
	 * 判断坦克是否超过游戏的边界，并对坦克超过边界后进行处理
	 */
	public void hitWall() {

		if (getX() < 0) {
			setX(0);
		}
		
		if (getX() + getWIDTH() > GamePanel.WIDTH) {
			setX(GamePanel.WIDTH - getWIDTH());
		}
		
		if (getY() < 0) {
			setY(0);
		} 
		
		if (getY() + getHEIGHT() + 20> GamePanel.HEIGHT) {
			setY(GamePanel.HEIGHT - getHEIGHT() - 20);
		}
	}
	
	/**
	 * 获得坦克在游戏中所在区域
	 * @return 坦克所占的游戏空间
	 */
	public Rectangle getRect() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}

//	//设置坦克具体的方向
//	public void setDirection () {
//	
//	}
	
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
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

	public int getOldX() {
		return oldX;
	}

	public void setOldX(int oldX) {
		this.oldX = oldX;
	}

	public int getOldY() {
		return oldY;
	}

	public void setOldY(int oldY) {
		this.oldY = oldY;
	}

	public Direction getDir() {
		return dir;
	}

	public void setDir(Direction dir) {
		this.dir = dir;
	}

	public boolean isMotionStatus() {
		return motionStatus;
	}

	public void setMotionStatus(boolean motionStatus) {
		this.motionStatus = motionStatus;
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

	public void setBulletMax(int bulletMax) {
		this.bulletMax = bulletMax;
	}

	public int getWIDTH() {
		return WIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}

	public int getBulletMax() {
		return bulletMax;
	}
	
	public GameListener getGameListener() {
		return gameListener;
	}

	public void setGameListener(GameListener gameListener) {
		this.gameListener = gameListener;
	}

	public int getDps() {
		return dps;
	}

	public void setDps(int dps) {
		this.dps = dps;
	}
}
