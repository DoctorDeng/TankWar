package game.gameAssist;

import javax.swing.JPanel;

import game.control.TankClient;

/**
 * 后台每隔一段时间就重画的线程
 * @author Doctor邓
 */
public class GameAssistRepaint implements Runnable{
	private JPanel gamePanel;

	public GameAssistRepaint(JPanel gamePanel) {
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
				e.printStackTrace();
			}
		}
	}

}
