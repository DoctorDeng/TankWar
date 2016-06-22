package game.dataEntity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.List;
import java.util.Random;

import game.control.DataAdmin;
import game.gameAssist.GameAssistStop;
import game.model.GameFactory;

/**
 * 游戏道具的实体类
 * @author Doctor邓
 */
public class Prop {
	
	private final int WIDTH = 30;
	private final int HEIGHT = 30;
	private int x;
	private int y;
	/**
	 * 道具的标识
	 * 说明：   0 ：恢复坦克的生命值
	 * 		 1： 给老家筑起白墙
	 *       2： 杀死所有敌方坦克
	 *       3： 停止所有敌方坦克
	 *       4： 坦克捡一个该道具，增加移速，两个增加弹夹数量，三个增强子弹的威力
	 */
	private int symbol;
	private Random random = new Random();
	private DataAdmin admin;
	/**
	 * 道具图片的集合
	 */
	private Image[] images = {
			Toolkit.getDefaultToolkit().getImage("image/prop/lifeProp.png"),
			Toolkit.getDefaultToolkit().getImage("image/prop/wallProp.png"),
			Toolkit.getDefaultToolkit().getImage("image/prop/bombProp.png"),
			Toolkit.getDefaultToolkit().getImage("image/prop/stopProp.png"),
			Toolkit.getDefaultToolkit().getImage("image/prop/startProp.png")
	};
	
	public Prop(DataAdmin admin) {
		this.admin = admin;
		x = random.nextInt(700) + 50;
		y = random.nextInt(550) + 50;
		this.symbol = random.nextInt(images.length);
//		this.symbol = 4;
	}
	/**
	 * 道具画图方法
	 * @param g   所需要的画笔
	 */
	public void draw(Graphics g) {
		g.drawImage(images[symbol], x, y, null);
	}
	/**
	 * 道具的功能方法
	 * @param myTank  捡到道具的我方坦克
	 */
	public void function(MyTank myTank) {
		switch(symbol) {
		case 0:
			lifeFunction(myTank);
			break;
		case 1:
			wallFunction();
			break;
		case 2:
			boomFunction();
			break;
		case 3:
			stopFunction();
			break;
		case 4:
			starFunction(myTank);
			break;
		}
	}
	/**
	 * 加血功能,恢复坦克的生命值
	 * @param myTank  捡到道具的我方坦克
	 */
	public void lifeFunction(MyTank myTank) {
		myTank.setLife(myTank.getMAX_LIFE());
	}
	/**
	 * 将老家的墙变为白墙的功能
	 * @param myTank  捡到道具的我方坦克
	 */
	public void wallFunction() {
		int[][] whiteHomeMap = new GameMap().getWhiteHomeMap();
		List<Wall> wallList = new GameFactory().getWalls(whiteHomeMap);
		admin.getWalls().addAll(wallList);
	}
	/**
	 * 杀死所有出现的地方坦克的功能
	 * @param myTank  捡到道具的我方坦克
	 */
	public void boomFunction() {
		/**
		 * 所有ai坦克发生爆炸
		 */
		 for(int i=0; i<admin.getAITanks().size(); i++) {
			 admin.getAITanks().get(i).boom();
			 admin.setScore(admin.getScore() +  admin.getAITanks().get(i).getTankScore());
		 }
		 /**
		  * 清空所有ai坦克
		  */
		 admin.getAITanks().clear();
	}
	/**
	 * 让所有地方坦克无法移动的功能
	 * @param myTank  捡到道具的我方坦克
	 */
	public void stopFunction() {
		GameAssistStop stopGame = new GameAssistStop(admin, 1);
		stopGame.start();
	}
	/**
	 * 强化坦克功能：
	 * <p>当坦克的移动速度为初始移动速度4时，提升移动速度
	 * <p>再次获得start道具后，判断坦克的弹夹容量，如果为原弹夹数量1，则提升弹夹数量
	 * <p>再次获得start道具后，判断坦克的子弹威力dps，如果为初始威力1，则提升子弹威力
	 * @param myTank
	 * 
	 */
	public void starFunction(MyTank myTank) {
		
		if (myTank.getSpeed() == 4) {
			myTank.setSpeed(5);
		} else if (myTank.getBulletMax() <= 1) {
			myTank.setBulletMax(2);
		} else if (myTank.getDps() == 1) {
			myTank.setDps(3);
			myTank.setBulletMax(1);
		}
	}
	/**
	 * 获得道具所占的游戏空间
	 * @return
	 */
	public Rectangle getRect() {
		return new Rectangle(x, y, WIDTH + 10, HEIGHT + 10);
	}

}
