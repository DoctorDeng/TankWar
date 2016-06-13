package tankWarCongGou.gameRun;

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
import tankWarCongGou.model.GameData;
/**
 * 
 * @author Doctor邓
 * <p>用于对游戏中的存放统一管理。例如：添加AI坦克，添加爆炸对象</p>
 */
public class DataAdmin {
	private GameData gameData;
	
	public DataAdmin() {
		gameData = new GameData();
	}
	
	public void clear() {
		gameData.getMyTanks().clear();
		gameData.getAiTanks().clear();
		gameData.getProps().clear();
		gameData.getBullets().clear();
		gameData.getWalls().clear();
		gameData.getBooms().clear();
	}
	
	public WallEffects getWallEffects() {
		return gameData.getWallEffects();
	}
	
	public void addBullet(Bullet bullet) {
		gameData.getBullets().add(bullet);
	}
	
	public List<Bullet> getBullets() {
		return gameData.getBullets();
	}
	
	public void removeBullet(Bullet bullet) {
		if (gameData.getBullets().contains(bullet)) {
			gameData.getBullets().remove(bullet);
		}
	}
	
	public void addMyTank(MyTank myTank) {
		gameData.getMyTanks().add(myTank);
	}
	
	public List<MyTank> getMyTanks() {
		return gameData.getMyTanks();
	} 
	
	public void removeMyTank(MyTank myTank) {
		if (gameData.getMyTanks().contains(myTank)) {
			gameData.getMyTanks().remove(myTank);
		}
	}
	
	public void setMyTanks(List<MyTank> myTanks) {
		gameData.getMyTanks().addAll(myTanks);
	}
	
	public List<AITank> getAITanks() {
		return gameData.getAiTanks();
	}
	
	public void setAITanks(List<AITank> aiTanks)  {
		gameData.setEnemyNum(gameData.getEnemyNum() - aiTanks.size());
		gameData.getAiTanks().addAll(aiTanks);
	}
	
	public void addAITank(AITank aiTank) {
		gameData.setEnemyNum(gameData.getEnemyNum() - 1);
		gameData.getAiTanks().add(aiTank);
	}
	
	public void dataAddListener(GameListener listener) {
		for (int i=0; i<getMyTanks().size(); i++) {
			getMyTanks().get(i).setGameListener(listener);
		}
		for (int i=0; i<getAITanks().size(); i++) {
			getAITanks().get(i).setGameListener(listener);
		}
	}

	public void addBoom(Boom boom) {
		gameData.getBooms().add(boom);
	}
	
	public void removeBoom(Boom boom) {
		if (gameData.getBooms().contains(boom)) {
			gameData.getBooms().remove(boom);
		}
	}
	
	public void addWalls(List<Wall> wallList) {
		gameData.getWalls().addAll(wallList);
	}
	
	public List<Boom> getBooms() {
		return gameData.getBooms();
	}
	
	public List<Wall> getWalls() {
		return gameData.getWalls();
	}
	
	public void setWalls(List<Wall> walls) {
		gameData.getWalls().addAll(walls);
	}
	
    public void addProp(Prop prop) {
    	gameData.getProps().add(prop);
    }
    
    public List<Prop> getProps() {
    	return gameData.getProps();
    }
    
    public GameHome getGameHome() {
    	return gameData.getGameHome();
    }
    
    public AICartoon getAICartoon() {
    	return gameData.getAiCartoon();
    }
    
    public void setAICartoon(AICartoon aiCartoon) {
    	gameData.setAiCartoon(aiCartoon);
    }
	
    public GameMenu getGameMenu() {
    	return gameData.getGameMenu();
    }
    
    public int getScore() {
		return gameData.getScore();
	}

	public void setScore(int score) {
		gameData.setScore(score);
	}

	public int getEnemyNum() {
		return gameData.getEnemyNum();
	}

	public void setEnemyNum(int enemyNum) {
		gameData.setEnemyNum(enemyNum);
	}
	
	public GameEnd getGameEnd() {
		return gameData.getGameEnd();
	}
}
