package game.model;

import game.control.DataAdmin;
import game.control.TankClient;

/**
 * 判断游戏胜利或者失败的类
 * @author Doctor邓
 *
 */
public class GameJudge {
	private DataAdmin admin;
	
	public GameJudge(DataAdmin admin) {
		this.admin = admin;
	} 
	/**
	 * 判断游戏是否胜利或失败
	 */
	public void judge() {
		/**
		 * 当敌方坦克全部 被摧毁时，游戏胜利
		 */
		if (admin.getEnemyNum()<= 0 && admin.getAITanks().size() <= 0) {
			TankClient.victory = 1;
		}
		
		/*
		 * 当我方坦克全部阵亡时，游戏失败 
		 */
		if (admin.getMyTanks().size() == 0) {
			TankClient.victory = 2;
		}
		
		/**
		 * 当老家被摧毁时，游戏失败
		 */
		if (!admin.getGameHome().isLive()) {
			TankClient.victory = 2;
		}
	}
}
