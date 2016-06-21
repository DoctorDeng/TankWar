package game.dataEntity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import game.control.GameListener;
/**
 * 
 * @author Doctor邓
 * 爆炸类
 */
public class Boom {
	private int x;
	private int y;
	/**
	 * 爆炸存活标识,默认存活
	 * <p>true: 存活
	 * <p>false: 死亡
	 */
	private boolean live = true;
	private GameListener listener;
	/**
	 * 记录子弹画到第几步了
	 */
	private int step =0; 
	
	private static boolean init = false;
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	/**
	 * 爆炸图片集合
	 */
	private static Image[] imgs = {
			tk.getImage("image/Boom/0.gif"),
			tk.getImage("image/Boom/1.gif"),
			tk.getImage("image/Boom/2.gif"),
			tk.getImage("image/Boom/3.gif"),
			tk.getImage("image/Boom/4.gif"),
			tk.getImage("image/Boom/5.gif"),
			tk.getImage("image/Boom/6.gif"),
			tk.getImage("image/Boom/7.gif"),
			tk.getImage("image/Boom/8.gif"),
			tk.getImage("image/Boom/9.gif"),
			tk.getImage("image/Boom/10.gif")
	};
	
	public Boom(int x, int y) {
		this.x = x;
		this.y = y;
	}
	/**
	 * 爆炸的画图方法
	 * @param g   需要的画笔
	 */
	public void draw(Graphics g) {

		if(!init) {
			for (int i = 0; i < imgs.length; i++) {
				g.drawImage(imgs[i], -100, -100, null);
			}			
			init = true;
		}
		/**
		 * 但爆炸死亡时,通知监听器
		 */
		if (!live) {
			listener.boomEnd(this);
			return;
		}
		/**
		 * 但爆炸画图的步数达到上限时,爆炸死亡
		 */
		if (step == imgs.length) {
			live = false;
			step = 0;
			return;
		}
		g.drawImage(imgs[step], x-imgs[step].getWidth(null)/2, y-imgs[step].getHeight(null)/2, null);
		step ++;
	}

	public void setListener(GameListener listener) {
		this.listener = listener;
	}
}
