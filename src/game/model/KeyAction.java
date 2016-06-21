package game.model;

import java.awt.event.KeyEvent;
import java.util.List;

import game.control.DataAdmin;
import game.control.TankClient;
import game.dataEntity.Direction;
import game.dataEntity.MyTank;

/**
 *	游戏监听类，用于监听用户的操作，
 * @author Doctor邓
 */
public class KeyAction {
	private DataAdmin admin;
	private List<MyTank> myTanks;
	/**
	 * 玩家一
	 */
	private MyTank myTank1 = null;   
	/**
	 * 玩家二
	 */
	private MyTank myTank2 = null;   
	
	public KeyAction(DataAdmin admin) {
		this.admin = admin;
		this.myTanks = this.admin.getMyTanks();
	} 
	
	/**
	 * 按键按下处理方法
	 * @param e
	 */
	public  void keyPressed(KeyEvent e) {
		/**
		 * 通过游戏是否已经开始的状态来确定键盘监听事件
		 */
		if (TankClient.gameStatus) {
			keyTank(e);
		} else if (TankClient.gameStatus == false && admin.getGameMenu().isMenuStatus() == false){
			keyMenu(e);
		}
	}
	
	public void keyReleased(KeyEvent e) {
		
	}
	
	/**
	 * 操作坦克的键盘监听事件
	 * @param e
	 */
	public void keyTank(KeyEvent e) {
		
		if (myTanks.size()!= 0 && myTanks.size() == 1) {
			myTank1 = myTanks.get(0);
		} 
		else if (myTanks.size()!= 0 && myTanks.size() == 2) {
			myTank1 = myTanks.get(0);
			myTank2 = myTanks.get(1);
		} 
		
		if (myTank1 != null) {
			
			switch(e.getKeyCode()) {
			case KeyEvent.VK_W:
				myTank1.setMotionStatus(true);
				myTank1.setDir(Direction.Up);
				break;
			case KeyEvent.VK_A:
				myTank1.setMotionStatus(true);
				myTank1.setDir(Direction.Left);
				break;
			case KeyEvent.VK_S:
				myTank1.setMotionStatus(true);
				myTank1.setDir(Direction.Down);
				break;
			case KeyEvent.VK_D:
				myTank1.setMotionStatus(true);
				myTank1.setDir(Direction.Right);
				break;
			case KeyEvent.VK_J:
				myTank1.fire();
				break;
			}
		}
		
		if (myTank2 != null) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_UP:
				myTank2.setMotionStatus(true);
				myTank2.setDir(Direction.Up);
				break;
			case KeyEvent.VK_LEFT:
				myTank2.setMotionStatus(true);
				myTank2.setDir(Direction.Left);
				break;
			case KeyEvent.VK_DOWN:
				myTank2.setMotionStatus(true);
				myTank2.setDir(Direction.Down);
				break;
			case KeyEvent.VK_RIGHT:
				myTank2.setMotionStatus(true);
				myTank2.setDir(Direction.Right);
				break;
			case KeyEvent.VK_NUMPAD0:
				myTank2.fire();
				break;
			}
		}
	}
	/**
	 * 游戏菜单选择人数的键盘监听事件
	 * @param e
	 */
	public void keyMenu(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_UP:
			admin.getGameMenu().setPlayerNum(true);  //选择游戏人数为一人
			break;
		case KeyEvent.VK_DOWN:
			admin.getGameMenu().setPlayerNum(false); //选择游戏人数为二人
			break;
		case KeyEvent.VK_W:
			admin.getGameMenu().setPlayerNum(true);  //选择游戏人数为一人
			break;
		case KeyEvent.VK_S:
			admin.getGameMenu().setPlayerNum(false); //选择游戏人数为二人
			break;
		case KeyEvent.VK_ENTER:
			TankClient.gameStart(getPlayerNum());
			break;
		}
	}
	
	/**
	 * 获得玩家选择游戏的人数
	 * @return
	 */
	public int getPlayerNum() {
		if (admin.getGameMenu().isPlayerNum()) {
			return 1;
		}
		return 2;
	}
}