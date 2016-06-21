package game.dataEntity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import view.GamePanel;
/**
 * 游戏开始选择时的菜单实体类
 * @author Doctor邓
 *
 */
public class GameMenu {
	/**
	 * 游戏菜单背景图坐标
	 */
	private int X=0;
	private int Y=0;
	/**
	 * 游戏选择人数时，小坦克的坐标
	 */
	private int x;
	private int y;
	/**
	 * 用于判断菜单在开始还是选择人数界面的标识
	 * true为开始界面，false为选择人数界面
	 */
	private boolean menuStatus = true;
	/**
	 * 用于判断玩家选择人数的标识
	 * true为选择一人，false 为选择两个人
	 */
	private boolean playerNum = true;
	/*
	 * 游戏开始界面图片
	 */
	private  Image gameShow = Toolkit.getDefaultToolkit().getImage("image/menu/gameShow.png");
	/**
	 * 游戏选择人数的小坦克的图片
	 */
	private final Image selectTank = Toolkit.getDefaultToolkit().getImage("image/menu/selectTank.png");
	/**
	 * 选择游戏人数的背景图片
	 */
	private final Image menuBackground = Toolkit.getDefaultToolkit().getImage("image/menu/menuBackground.gif");
	/**
	 * 游戏菜单选择人数时，小坦克的位置集合
	 */
	private final int[][] XY = {{230,400},{230,445}};
	/**
	 * 菜单画图方法
	 * @param g   所需要的画笔
	 */
	public void draw(Graphics g) {
		if (menuStatus) {
			showCartoon();
			g.drawImage(gameShow, x, y, GamePanel.WIDTH, GamePanel.HEIGHT, null);
		} else {
			selectPosition();
			selectCartoon();
			g.drawImage(menuBackground, X, Y, GamePanel.WIDTH, GamePanel.HEIGHT, null);
			if (j==35) {
				g.drawImage(selectTank, x, y, null);
			}
		}
		
	}
	/**
	 * 根据玩家的选择确定选择的小坦克的位置
	 */
	public void selectPosition() {
		if (playerNum) {
			x = XY[0][0];
			y = XY[0][1];
		} else {
			x = XY[1][0];
			y = XY[1][1];
		}
	}
	/**
	 * 主界面生成时的动画
	 */
	int i=0;
	public void showCartoon() {
		y = GamePanel.HEIGHT - i*20;
		if (i<35) {
			i++;
		}
	}
	/**
	 * 选择人数界面生成动画
	 */
	int j=0;
	public void selectCartoon() {
		Y = GamePanel.HEIGHT - j*20;
		if (j<35) {
			j++;
		}
	}
	/**
	 * Menu数据初始化
	 */
	public void dataInit() {
		i=0;
		j=0;
	}
	public boolean isMenuStatus() {
		return menuStatus;
	}
	public void setMenuStatus(boolean menuStatus) {
		this.menuStatus = menuStatus;
	}
	public boolean isPlayerNum() {
		return playerNum;
	}
	public void setPlayerNum(boolean playerNum) {
		this.playerNum = playerNum;
	}
}
