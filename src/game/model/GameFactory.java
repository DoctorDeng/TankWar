package game.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import game.dataEntity.AITank;
import game.dataEntity.GameMap;
import game.dataEntity.MyTank;
import game.dataEntity.Tank;
import game.dataEntity.Wall;
import view.GamePanel;

/**
 * 
 * @author Doctor邓
 * <p>作用: 用于生成游戏的各个对象的工厂类，例如：坦克，子弹，墙等。<p>
 */
public class GameFactory {

	private final Random random = new Random();
	/**
	 * AiTank的初始三个位置
	 */
	private final int[][] aiPosition = {{Tank.WIDTH/2, 0},
									{GamePanel.WIDTH/2 - Tank.WIDTH/2, 0},
									{GamePanel.WIDTH - Tank.WIDTH*3/2, 0}};
	/**
	 * 代表AITank位置的标识符
	 */
	private int situationSymbol;
	
	/**
	 * MyTank的两个初始位置
	 */
	private final int[][] myPosition = {{GamePanel.WIDTH/2- Tank.WIDTH*2, GamePanel.HEIGHT - Tank.HEIGHT},
			{GamePanel.WIDTH/2 + Tank.WIDTH*2, GamePanel.HEIGHT - Tank.HEIGHT}};
	
	/**
	 * 初始化我方坦克。
	 * @param volume  要初始化我方坦克的数量
	 * @return        返回我方坦克的List集合
	 */
	public List<MyTank> getMyTanks(int volume) {
		List<MyTank> myTanks = new ArrayList<>();
		if (volume == 1) {
				int x = myPosition[0][0];
				int y = myPosition[0][1];
				MyTank  myTank = new MyTank(x, y);
				myTanks.add(myTank);
		} else {
			int x1 = myPosition[0][0];
			int y1 = myPosition[0][1];
			MyTank  myTank1 = new MyTank(x1, y1);
			myTanks.add(myTank1);
			int x2 = myPosition[1][0];
			int y2 = myPosition[1][1];
			MyTank myTank2 = new MyTank(x2, y2);
			myTanks.add(myTank2);
		}
		return myTanks;
	}
	
	/**
	 * 初始化AI坦克
	 * @param volume    要初始化的AI坦克的数量
	 * @return          返回AI坦克的List集合
	 */
	public List<AITank> getAITanks(int volume) {
		List<AITank> aiTanks = new ArrayList<AITank>();
		
		for(int i=0; i<volume; i++) {
			int j = random.nextInt(3);
			situationSymbol = j;
			int x = aiPosition[j][0];
			int y = aiPosition[j][1];
			AITank aiTank = new AITank(x, y);
			aiTanks.add(aiTank);
		}
		return aiTanks;
	}
	
	/**
	 * @return 一个位置随机的AITank
	 */
	public AITank getAITank() {
		int j = random.nextInt(aiPosition.length);
		situationSymbol = j;
		int x = aiPosition[j][0];
		int y = aiPosition[j][1];
		AITank aiTank = new AITank(x, y);
		return aiTank;
	}
	
	/**
	 * 获得地图墙的信息的集合
	 * @param map   指定的地图
	 * @return   指定地图包含的墙的信息的集合
	 */
	public List<Wall> getWalls(GameMap map) {
		List<Wall> wallList = new ArrayList<>();
		/**
		 * 初始化用户指定的地图的信息
		 */
		int[][] gameMap = map.getMap1();
		for (int i=0; i<gameMap.length; i++) {
			Wall wall = new Wall(gameMap[i][0], gameMap[i][1], gameMap[i][2]);
			wallList.add(wall);
		}
		/**
		 * 初始化不变的老家的地图的信息
		 */
		int[][] homeMap = map.getHomeMap();
		for (int i=0; i<homeMap.length; i++) {
			Wall wall = new Wall(homeMap[i][0], homeMap[i][1], homeMap[i][2]);
			wallList.add(wall);
		}
		return wallList;
	}
	/**
	 * 将指定的地图信息集合转化为地图墙的信息的集合
	 * @param map   地图信息的集合
	 * @return      包含指定地图信息的墙的集合
	 */
	public List<Wall> getWalls(int[][] map) {
		List<Wall> wallList = new ArrayList<>();
		
		int[][] homeMap = map;
		for (int i=0; i<homeMap.length; i++) {
			Wall wall = new Wall(homeMap[i][0], homeMap[i][1], homeMap[i][2]);
			wallList.add(wall);
		}
		return wallList;
	}
	
	/**
	 * 获得代表AI坦克初始位置的标识符
	 * @return   返回AI坦克的初始位置标识符
	 */
	public int getSituationSymbol() {
		return situationSymbol;
	}
}
