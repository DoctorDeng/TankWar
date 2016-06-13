package game.gameAssist;

import javax.swing.JLabel;

import game.gameRun.DataAdmin;
import game.gameRun.TankClient;

/*
 * 动态的将游戏的相关信息显示出来的线程 
 */
public class GameAssistInfor extends Thread{
	private DataAdmin admin;
	private JLabel score;
	private JLabel enemyNum;
	
	public GameAssistInfor(DataAdmin admin, JLabel score, JLabel enemyNum)  {
		this.admin = admin;
		this.score = score;
		this.enemyNum = enemyNum;
	}
	
	
	@Override
	public void run() {
		try {
			while (true) {
				if (TankClient.gameStatus) {
					score.setText(String.valueOf(admin.getScore()));
					enemyNum.setText(String.valueOf(admin.getEnemyNum() + admin.getAITanks().size()));
				} 
				else {
					score.setText("???");
					enemyNum.setText("???");
				}
				sleep(300);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
