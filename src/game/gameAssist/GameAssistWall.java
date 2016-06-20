package game.gameAssist;

import java.util.List;

import game.dataEntity.GameMap;
import game.dataEntity.Wall;
import game.gameRun.DataAdmin;
import game.gameRun.GameFactory;
import game.gameRun.TankClient;
/**
 * 用于每隔一段时间就将老家的白墙转换为红墙
 * @author Doctor邓
 *
 */
public class GameAssistWall extends Thread {
	private DataAdmin admin;
	private GameMap map;
	private GameFactory factory;
	private List<Wall> homeWalls;
	private List<Wall> homeWhiteWalls;
	
	public GameAssistWall(DataAdmin admin) {
		this.admin = admin;
		map = new GameMap();
		factory = new GameFactory();
		homeWalls = factory.getWalls(map.getHomeMap());
		homeWhiteWalls = factory.getWalls(map.getWhiteHomeMap());
	}
	
	public void run() {
		 try {
			while(true) {
				if (TankClient.gameStatus == false) {
					sleep(200);
					continue;
				}
				
				sleep(2000);
				/**
				 * 用于判断老家的墙是否有白色的墙存在，默认为false，不存在
				 */
				boolean temp = false;
				/**
				 * 当老家的墙只要有一堵白色的墙，temp 为true
				 */
				for (int i=0; i<homeWhiteWalls.size(); i++) {
					if (admin.getWalls().contains(homeWhiteWalls.get(i))) {
						temp = true;
						break;
					}
				}
				/**
				 * 当老家中有白墙存在时，等待一段时间清除白墙，并为其添加上红墙
				 */
				if (temp) {
					/**
					 * 清除老家中还存在的普通红墙
					 */
					for (int i=0; i<homeWalls.size(); i++) {
						if (admin.getWalls().contains(homeWalls.get(i))) {
							admin.getWalls().remove(homeWalls.get(i));						}
					}
					sleep(5000);
					/**
					 * 开启白墙和普通红墙间的切换特效
					 */
					int j=5;
					while (true) {
						admin.getWallEffects().setWall(true);
						admin.getWallEffects().setWhiteWall(false);
						sleep(180);
						admin.getWallEffects().setWall(false);
						admin.getWallEffects().setWhiteWall(true);
						sleep(180);
						if (j<0) {
							break;
						}
						j--;
					}
					admin.getWallEffects().setWall(false);
					admin.getWallEffects().setWhiteWall(false);
					
					/**
					 * 清除老家中还存在的白色的墙
					 */
					for (int i=0; i<homeWhiteWalls.size(); i++) {
						if (admin.getWalls().contains(homeWhiteWalls.get(i))) {
							admin.getWalls().remove(homeWhiteWalls.get(i));						}
					}
					/**
					 * 为老家添加上新的红墙
					 */
					admin.getWalls().addAll(homeWalls);
					
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
