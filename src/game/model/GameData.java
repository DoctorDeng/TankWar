package game.model;

import java.util.ArrayList;
import java.util.List;

import entity.User;
import game.cartoon.AICartoon;
import game.cartoon.GameEndCartoon;
import game.cartoon.WallCartoon;
import game.dataEntity.AITank;
import game.dataEntity.Boom;
import game.dataEntity.Bullet;
import game.dataEntity.GameHome;
import game.dataEntity.GameMenu;
import game.dataEntity.MyTank;
import game.dataEntity.Prop;
import game.dataEntity.Wall;

/**
 * 
 * @author Doctor邓
 *	存储游戏的数据，并对游戏的数据初始化
 */
public class GameData {
	
	private List<MyTank> myTanks;       //我方坦克集合
	private List<AITank> aiTanks;       //AI坦克集合
	private List<Bullet> bullets;       //子弹集合
	private List<Prop> props;           //道具集合
	private List<Wall> walls;           //墙集合
	private List<Boom> booms;           //爆炸集合
	private GameHome gameHome;          //家
	private WallCartoon wallEffects;    //老家动画特效
	private AICartoon aiCartoon;        //AI坦克生成时动画
	private GameMenu gameMenu;          //游戏菜单
	private int score;                  //游戏分数
	private int enemyNum;               //游戏剩余敌人数量
	private GameEndCartoon gameEnd;     //游戏结束类
	private User user;                  //游戏用户
	
	public GameData() {
		myTanks = new ArrayList<MyTank>();
		aiTanks = new ArrayList<AITank>();
		bullets = new ArrayList<Bullet>();
		props = new ArrayList<Prop>();
		walls = new ArrayList<Wall>();
		booms = new ArrayList<Boom>();
		gameHome = new GameHome();
		wallEffects = new WallCartoon();
		aiCartoon = new AICartoon();
		gameMenu = new GameMenu();
		gameEnd = new GameEndCartoon();
		score = 0;
	} 
	
	public WallCartoon getWallEffects() {
		return wallEffects;
	}
	
	public  List<Bullet> getBullets() {
		return bullets;
	}

	public  List<MyTank> getMyTanks() {
		return myTanks;
	}
	
	public void setMyTanks(List<MyTank> myTanks) {
		this.myTanks = myTanks;
	}

	public List<AITank> getAiTanks() {
		return aiTanks;
	}

	public void setAiTanks(List<AITank> aiTanks) {
		this.aiTanks = aiTanks;
	}

	public List<Wall> getWalls() {
		return walls;
	}

	public void setWalls(List<Wall> walls) {
		this.walls = walls;
	}

	public List<Prop> getProps() {
		return props;
	}

	public void setProps(List<Prop> props) {
		this.props = props;
	}

	public List<Boom> getBooms() {
		return booms;
	}

	public void setBooms(List<Boom> booms) {
		this.booms = booms;
	}

	public void setBullets(List<Bullet> bullets) {
		this.bullets = bullets;
	}

	public GameHome getGameHome() {
		return gameHome;
	}

	public void setGameHome(GameHome gameHome) {
		this.gameHome = gameHome;
	}

	public AICartoon getAiCartoon() {
		return aiCartoon;
	}

	public void setAiCartoon(AICartoon aiCartoon) {
		this.aiCartoon = aiCartoon;
	}

	public GameMenu getGameMenu() {
		return gameMenu;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getEnemyNum() {
		return enemyNum;
	}

	public void setEnemyNum(int enemyNum) {
		this.enemyNum = enemyNum;
	}

	public GameEndCartoon getGameEnd() {
		return gameEnd;
	}
}
