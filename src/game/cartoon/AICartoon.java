package game.cartoon;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import view.GamePanel;

/**
 * AI坦克在生成时的动画类
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
	 * 决定图片的标识,决定每次动画画哪一张图片
	 */
	private int numCartoon;
	/**
	 * 动画图片的集合
	 */
	private final Image[] images = {
			Toolkit.getDefaultToolkit().createImage("image/aiCartoon/1.png"),
			Toolkit.getDefaultToolkit().createImage("image/aiCartoon/2.png"),
			Toolkit.getDefaultToolkit().createImage("image/aiCartoon/3.png"),
			Toolkit.getDefaultToolkit().createImage("image/aiCartoon/4.png")}; 
	private final int[][] situation = {{40,0},{GamePanel.WIDTH/2 - WIDTH/2,0},
			{GamePanel.WIDTH -10 - 30 - WIDTH,0}};
	
	/**
	 * 无参的构造方法,默认：
	 * <p>isOpen = false   :不开启动画
	 * <p>numCartoon = 1   :初始画第一张动画图片
	 * <p>symbol = 0       :初始位置标识为0,即游戏左上角位置
	 */
	public AICartoon() {
		isOpen = false;
		numCartoon = 1;
		symbol = 0;
	}
	
	/**
	 * 动画的画图方法
	 * @param g    动画画图需要的画笔 Graphics
	 */
	public void draw(Graphics g) {
		if(isOpen) {
			selectSituation(symbol);
			g.drawImage(selectImage(numCartoon), x, y, WIDTH, HEIGHT, null);
		}
	}
	
	/**
	 * 通过动画的位置标识符,确定动画出现的位置
	 * @param symbol    动画的位置标识符
	 */
	private void selectSituation(int symbol) {
			x = situation[symbol][0];
			y = situation[symbol][1];
	}
	
	
	/**
	 * 通过图片标识,决定动画所要画的图片
	 * @param numCartoon     :动画图片标识
	 * @return
	 */
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
