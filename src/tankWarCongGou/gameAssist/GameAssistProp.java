package tankWarCongGou.gameAssist;

import tankWarCongGou.dataEntity.Prop;
import tankWarCongGou.gameRun.DataAdmin;
import tankWarCongGou.gameRun.TankClient;
/**
 * 游戏辅助工具类
 * @author Administrator
 *
 */
public class GameAssistProp extends Thread {
	private DataAdmin admin;
	
	public GameAssistProp(DataAdmin admin) {
		this.admin = admin;
	}
	
	public void run() {
		try {
			while(true) {
				if (TankClient.gameStatus == false) {
					sleep(200);
					continue;
				}
				
				sleep(5000);
				if (admin.getProps().size()==0) {
					admin.getProps().add(new Prop(admin));
					sleep(15000);
				}
				if (admin.getProps().size() > 0) {
					admin.getProps().clear();
				}
			}
		} catch (InterruptedException e) {
				e.printStackTrace();
		}
	}
	
	public void stopPropAssist() {
		
	}
}
