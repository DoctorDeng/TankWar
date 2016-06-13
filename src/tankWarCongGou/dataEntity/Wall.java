package tankWarCongGou.dataEntity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

/**
 * 
 * @author Doctor邓
 * 墙类
 */
public class Wall {
	private int x;
	private int y;
	private  int width;
	private  int height;
	/**
	 * 墙的标识（信息如下）：
	 *  0 ：  代表普通的红墙
	 *  1 ：  代表普通的白墙
	 *  2 ：  代表小的红墙（一个普通红墙相当于四个小的红墙）
	 *  3 ：  代表横的白墙（横着的白墙相当于普通白墙的一半）
	 *  4 ：  代表竖的白墙 （竖着的白墙相当于普通白墙的一半）
	 */
	private int wallMark;
	/**
	 * 墙的护甲
	 */
	private int armor;
	Image[] images = {
			Toolkit.getDefaultToolkit().getImage("image/wall/wall.png"),           //普通的红墙
		    Toolkit.getDefaultToolkit().getImage("image/wall/wallWhite.png"),      //普通的白墙
		    Toolkit.getDefaultToolkit().getImage("image/wall/smallWall.png"),      //小的红墙
		    Toolkit.getDefaultToolkit().getImage("image/wall/whiteWallRow.png"),      //横的白墙
		    Toolkit.getDefaultToolkit().getImage("image/wall/whiteWallCrow.png")       //竖的白墙
	};
	public Wall() {
		wallMark=0;      //墙默认为红墙
		setArmor(0);    //墙的护甲默认为0
		width = 50;
		height = 50;
	}
	
	public Wall(int x, int y, int wallMark) {
		this.x = x;
		this.y = y;
		this.wallMark = wallMark;
		armorInit(wallMark);
		whInit(wallMark);
	}
	public void draw(Graphics g) {
		g.drawImage(images[wallMark], x, y, width, height,	null);
	}
	
	/**
	 * 根据墙的标识 （wallMark）来确定墙的宽度
	 */
	public void whInit(int wallMark) {
		switch(wallMark) {
		case 0:
			width = 50;
			height = 50;
			break;
		case 1:
			width = 50;
			height = 50;
			break;
		case 2:
			width = 25;
			height = 25;
			break;
		case 3:
			width = 50;
			height = 25;
			break;
		case 4:
			width = 25;
			height = 50;
			break;
		default:
			width = 50;
			height = 50;
			break;
		}
		
	}
	
	/**
	 * 根据墙的标识（wallMark）来决定坦克的护甲
	 */
	public void armorInit(int wallMark) {
		switch(wallMark) {
		case 0:
			armor = 0;
			break;
		case 1:
			armor = 2;
			break;
		case 2:
			armor = 0;
			break;
		case 3:
			armor = 2;
			break;
		case 4:
			armor = 2;
			break;
		default:
			armor = 0;
			break;
		}
	}
	/**
	 * 获得坦克在游戏中所在区域
	 * @return 坦克所占的游戏空间
	 */
	public Rectangle getRect() {
		return new Rectangle(x, y, width, height);
	}

	public void setWallMark(int wallMark) {
		this.wallMark = wallMark;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWallMark() {
		return wallMark;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + height;
		result = prime * result + width;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wall other = (Wall) obj;
		if (height != other.height)
			return false;
		if (width != other.width)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	} 

}
