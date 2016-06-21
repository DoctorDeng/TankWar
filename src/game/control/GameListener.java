package game.control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.dataEntity.Boom;
import game.dataEntity.Bullet;
import game.dataEntity.Direction;
import game.dataEntity.Tank;
import game.model.KeyAction;

/**
 * 
 * @author Doctor邓
 * 游戏的监听类，用于监听游戏的各种事件
 */
public class GameListener implements KeyListener {
	private DataAdmin admin;
	private KeyAction gameAction;
	
	public GameListener(DataAdmin admin) {
		this.admin = admin;
		gameAction = new KeyAction(admin);
	}
	
	/**
	 * 坦克开火后生成一颗子弹
	 * @param x 
	 * @param y
	 * @param camp 子弹的阵营
	 * @param dir 子弹的方向
	 * @param ourTank 子弹所属坦克
	 * @param dps     子弹的威力
	 */
	public void fireAction(int x, int y, boolean camp, Direction dir, Tank ourTank, int dps) {
		Bullet bullet = new Bullet(x, y, camp, dir, ourTank, dps);
		bullet.setListener(this);
		admin.addBullet(bullet);
	}
	
	/**
	 * 子弹越界后在数据中心中移除子弹
	 * @param bullet   越界的子弹对象
	 */
	public void bulletOverBorder(Bullet bullet) {
		admin.removeBullet(bullet);
	}

	/**
	 * 在指定位置生成一个爆炸动画
	 * @param x    指定位置的 X 坐标
	 * @param y    指定位置的 X 坐标
	 */
	public void boomAction(int x, int y) {
		Boom boom = new Boom(x, y);
		boom.setListener(this);
		admin.addBoom(boom);
	}
	/**
	 * 爆炸结束后,将爆炸从数据中心移除
	 * @param boom
	 */
	public void boomEnd(Boom boom) {
		admin.removeBoom(boom);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		gameAction.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		gameAction.keyReleased(e);
	}
}
