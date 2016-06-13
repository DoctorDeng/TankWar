package game.cartoon;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import view.GamePanel;

/**
 * AI坦克
 * @author Administrator
 *
 */
public class AICartoon {
	private int x;
	private int y;
	private final int WIDTH = 30;
	private final int HEIGHT = 30;
	/**
	 * 决定动画位置的标识
	 */
	private int symbol;
	/**
	 * 决定是否动画是否开启的指令
	 */
	private boolean isOpen;
	/**
	 * 决定画哪一张图片的标识
	 */
	private int numCartoon;
	private final Image[] images = {
			Toolkit.getDefaultToolkit().createImage("image/aiCartoon/1.png"),
			Toolkit.getDefaultToolkit().createImage("image/aiCartoon/2.png"),
			Toolkit.getDefaultToolkit().createImage("image/aiCartoon/3.png"),
			Toolkit.getDefaultToolkit().createImage("image/aiCartoon/4.png")}; 
	private final int[][] situation = {{40,0},{GamePanel.WIDTH/2 - WIDTH/2,0},
			{GamePanel.WIDTH -10 - 30 - WIDTH,0}};
	
	
	public AICartoon() {
		isOpen = false;
		numCartoon = 1;
		symbol = 0;
	}
	
	public void draw(Graphics g) {
		if(isOpen) {
			selectSituation(symbol);
			g.drawImage(selectImage(numCartoon), x, y, WIDTH, HEIGHT, null);
		}
	}
	
	private void selectSituation(int symbol) {
			x = situation[symbol][0];
			y = situation[symbol][1];
	}
	
	private Image selectImage(int numCartoon) {
		switch(numCartoon) {
		case 1:
			return images[0];
		case 2:
			return images[1];
		case 3:
			return images[2];
		case 4:
			return images[3];
		default:
			return images[0];
		}
	}

	public int getSymbol() {
		return symbol;
	}

	public void setSymbol(int symbol) {
		this.symbol = symbol;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public int getNumCartoon() {
		return numCartoon;
	}

	public void setNumCartoon(int numCartoon) {
		this.numCartoon = numCartoon;
	}
}
