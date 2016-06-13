package game.gameRun;

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
	 */
	public void fireAction(int x, int y, boolean camp, Direction dir, Tank ourTank, int dps) {
		Bullet bullet = new Bullet(x, y, camp, dir, ourTank, dps);
		bullet.setListener(this);
		admin.addBullet(bullet);
	}
	
	public void bulletOverBorder(Bullet bullet) {
		admin.removeBullet(bullet);
	}

	public void boomAction(int x, int y) {
		Boom boom = new Boom(x, y);
		boom.setListener(this);
		admin.addBoom(boom);
	}
	
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
