package game.dataEntity;

import view.GamePanel;

public class GameMap {

	/**
	 * 定义的变量仅仅是为了方便代码书写的简洁
	 */
	int panleW = GamePanel.WIDTH/2;
	int panleH = GamePanel.HEIGHT - 20;
	int homeW = GameHome.WIDTH;
	int homeH = GameHome.HEIGHT;
	
	public void mapInit() {
		
	}
	
	/**
	 * 地图一
	 * @return  包含地图各种墙信息的二维数组
	 */
	public int[][] getMap1() {
		int[][] map = {{70,60,0}, {70, 110,0}, {70,160,0}, {70,210,0},
						{190,60,0}, {190,110,0}, {190,160,0}, {190,210,0},
						{310,60,0}, {310,110,0}, {310,160,0}, {310,260,0},
						{360,110,1},
						{410,60,0}, {410,110,0}, {410,160,0}, {410,260,0},
						{550,60,0}, {550,110,0}, {550,160,0}, {550,210,0},
						{670,60,0}, {670,110,0}, {670,160,0}, {670,210,0},
						{320,340,4},{370,340,4}, {420,340,4},
						{320,400,2},{370,400,2},{345,400,2},{395,400,2},{420,400,2},
						{320,425,2},{370,425,2},{345,425,2},{395,425,2},{420,425,2},
		{70,450,1}, {120,450,1}, {170,450,1}, {220,450,1}, {270,450,1},{320,450,2},{345,450,2},{370,450,2},{395,450,2},{420,450,2},
		{445,450,1},{495,450,1}, {545,450,1}, {595,450,1}, {645,450,1},{320,475,2},{345,475,2},{370,475,2},{395,475,2},{420,475,2},
						{0,320,3},{750,320,3},
						{120,320,2},{145,320,2},{170,320,2},{195,320,2},{220,320,2},
						{120,345,2},{145,345,2},{170,345,2},{195,345,2},{220,345,2},
						{655,320,2},{630,320,2},{605,320,2},{580,320,2},{555,320,2},
						{655,345,2},{630,345,2},{605,345,2},{580,345,2},{555,345,2},
		};
		return map;
	}
	
	/**
	 * 老家的地图，这是不会变得地图
	 */
	public int[][] getHomeMap() {
		int[][] homeMap = {
				{panleW - homeW, panleH - homeH/2, 2}, {panleW - homeW, panleH - homeH, 2}, {panleW - homeW, panleH - 3*homeH/2, 2},
				{panleW - homeW/2, panleH - 3*homeH/2, 2}, {panleW, panleH - 3*homeH/2, 2},
				{panleW + homeW/2, panleH - homeH/2, 2}, {panleW + homeW/2, panleH - homeH, 2}, {panleW + homeW/2, panleH - 3*homeH/2, 2}
						  };
		return homeMap;
	}
	/**
	 * 老家墙变为白墙的地图
	 */
	public int[][] getWhiteHomeMap() {
		int[][] homeMap = {{panleW - homeW, panleH - homeH, 4},
						   {panleW - homeW, panleH - 3*homeH/2, 3},
						   {panleW, panleH - 3*homeH/2, 3},
						   {panleW + homeW/2,panleH - homeH, 4}
						  };
		return homeMap;
	}
	
}
