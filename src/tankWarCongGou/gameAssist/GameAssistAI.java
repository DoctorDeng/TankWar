package tankWarCongGou.gameAssist;

import tankWarCongGou.dataEntity.AITank;
import tankWarCongGou.gameRun.DataAdmin;
import tankWarCongGou.gameRun.GameListener;
import tankWarCongGou.gameRun.TankClient;
import tankWarCongGou.model.GameFactory;

/**
 * 用于检测敌方坦克的数量，并当敌方坦克数量少于6时，动态生成敌方坦克。
 * @author Doctor邓
 *
 */
public class GameAssistAI extends Thread{
	private DataAdmin admin;
	private GameFactory factory;
	private GameListener listener;
	/**
	 * AI坦克最大存在数量
	 */
	private final int AITankMaxValue = 6;
	
	public GameAssistAI(DataAdmin admin, GameFactory factory, GameListener listener) {
		this.factory = factory;
		this.admin = admin;
		this.listener = listener;
	}
	
	public void run() {
		try {
			while (true) {
				if (TankClient.gameStatus == false) {
					sleep(200);
					continue;
				}
				sleep(1000);
				if (admin.getAITanks().size() <AITankMaxValue && admin.getEnemyNum() >0) {
					AITank aiTank = factory.getAITank();
					aiTank.setGameListener(listener);
					admin.getAICartoon().setSymbol(factory.getSituationSymbol());
					/**
					 * 开启AI坦克生成时动画
					 */
					admin.getAICartoon().setOpen(true);
					int i = 3;
					while(true) {
						for(int j=1; j<=4; j++) {
							admin.getAICartoon().setNumCartoon(j);
							sleep(200);
						}
						i --;
						if (i==0) break;
					}
					admin.getAICartoon().setOpen(false);
					admin.addAITank(aiTank);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
