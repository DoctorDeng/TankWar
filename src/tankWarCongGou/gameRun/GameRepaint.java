package tankWarCongGou.gameRun;

import javax.swing.JPanel;

/**
 * 
 * @author Doctor邓
 * 生成游戏画面类
 */
public class GameRepaint implements Runnable{
	private JPanel gamePanel;

	public GameRepaint(JPanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				if(TankClient.stopStatus) {
					Thread.sleep(200);					
					continue;
				}
				gamePanel.repaint();
				Thread.sleep(45);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

}
