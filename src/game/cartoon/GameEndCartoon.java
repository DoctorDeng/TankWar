package game.cartoon;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import game.control.TankClient;
import view.GamePanel;
/**
 * 游戏结束的动画,包括:
 * <p>游戏胜利时动画
 * <p>游戏失败时动画
 * @author Doctor邓
 *
 */
public class GameEndCartoon {
	private  int x =0;
	private  int y =0;
	private int width;
	private int height;
	int i = 1;
	int j= 0;
	
	private Image victory = Toolkit.getDefaultToolkit().getImage("image/end/gameVictory.png");
	private Image gameOver = Toolkit.getDefaultToolkit().getImage("image/end/gameOver.png");
	
	/**
	 * 动画的画图方法
	 * @param g   动画需要的画笔
	 */
	public void draw(Graphics g) {
		if (TankClient.victory == 1) {
			victoryCartoon();
			g.drawImage(victory, x, y, width, height,  null);
		} else {
			overCartoon();
			g.drawImage(gameOver, x, y, width, height,  null);
		}
	}
	
	/**
	 * 游戏失败时的动画
	 */
	public void overCartoon() {
		width = 338;
		height = 265;
		x=GamePanel.WIDTH/2 - width/2;
		y=GamePanel.HEIGHT - j*5;
		int temp = 104;
		if (j< temp) {
			j++;
		} else {
//			TankClient.stopStatus = true;
			TankClient.gameStatus = false;
		}
	
	}
	/**
	 * 游戏胜利时的动画
	 */
	public void victoryCartoon() {
		width = 20*i;
		height = 17*i;
		x = GamePanel.WIDTH/2 - width/2;
		y = GamePanel.HEIGHT/2 - height/2;
		if (i<40) {
			i++;
		} else {
//			TankClient.stopStatus = true;
			TankClient.gameStatus = false;
		}
	}
	
	public void dataInit() {
		i=1;
		j=0;
	}
	
	
}
