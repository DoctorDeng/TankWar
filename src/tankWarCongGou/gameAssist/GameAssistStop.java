package tankWarCongGou.gameAssist;
import tankWarCongGou.gameRun.DataAdmin;

/**
 * 让游戏停止的线程
 * 包括：让游戏停止和让AI坦克的移动、开火全部停止两个功能
 * @author Doctor邓
 *
 */
public class GameAssistStop extends Thread{
	private DataAdmin admin;
	private int symbol;
	
	/**
	 * 
	 * @param admin   DataAdmin对象，管理游戏的所有数据
	 * @param symbol  让线程进行相关功能操作的标识
	 */
	public GameAssistStop(DataAdmin admin, int symbol) {
		this.admin = admin;
		this.symbol = symbol;
	}

	@Override
	public void run() {
		switch(symbol) {
		case 1:
			stopAITank();
			break;
		case 2:
			stopGame();
			break;
		}
	}
	
	public void stopAITank() {
		for (int i=0; i< admin.getAITanks().size(); i++) {
			admin.getAITanks().get(i).setStopStatus(false);
		}
		int temp = 80;
		/**
		 * 将游戏中新生成的AI坦克也设置为无法开火的移动的状态
		 */
		while(true) {
			try {
				sleep(100);
				for (int i=0; i<admin.getAITanks().size(); i++) {
					if (admin.getAITanks().get(i).isStopStatus()) {
						admin.getAITanks().get(i).setStopStatus(false);
					}
				}
				if (temp<0) break;
				temp --;
		    } catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i=0; i<admin.getAITanks().size(); i++) {
			if (admin.getAITanks().get(i).isStopStatus() == false) {
				admin.getAITanks().get(i).setStopStatus(true);
			}
		}
	}
	
	public void stopGame() {
		
	}
	
}
