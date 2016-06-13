package tankWarCongGou.model;

import java.util.ArrayList;
import java.util.List;

import tankWarCongGou.cartoon.AICartoon;
import tankWarCongGou.cartoon.GameEnd;
import tankWarCongGou.cartoon.WallEffects;
import tankWarCongGou.dataEntity.AITank;
import tankWarCongGou.dataEntity.Boom;
import tankWarCongGou.dataEntity.Bullet;
import tankWarCongGou.dataEntity.GameHome;
import tankWarCongGou.dataEntity.GameMenu;
import tankWarCongGou.dataEntity.MyTank;
import tankWarCongGou.dataEntity.Prop;
import tankWarCongGou.dataEntity.Wall;

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
	private WallEffects wallEffects;    //老家动画特效
	private AICartoon aiCartoon;        //AI坦克生成时动画
	private GameMenu gameMenu;          //游戏菜单
	private int score;                  //游戏分数
	private int enemyNum;               //游戏剩余敌人数量
	private GameEnd gameEnd;            //游戏结束类
	
	public GameData() {
		myTanks = new ArrayList<MyTank>();
		aiTanks = new ArrayList<AITank>();
		bullets = new ArrayList<Bullet>();
		props = new ArrayList<Prop>();
		walls = new ArrayList<Wall>();
		booms = new ArrayList<Boom>();
		gameHome = new GameHome();
		wallEffects = new WallEffects();
		aiCartoon = new AICartoon();
		gameMenu = new GameMenu();
		gameEnd = new GameEnd();
		score = 0;
		enemyNum = 3;
	} 
	
	public WallEffects getWallEffects() {
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

	public GameEnd getGameEnd() {
		return gameEnd;
	}
}
