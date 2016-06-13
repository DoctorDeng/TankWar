package game.gameRun;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

import game.dataEntity.GameMap;
import game.gameAssist.GameAssistAI;
import game.gameAssist.GameAssistInfor;
import game.gameAssist.GameAssistProp;
import game.gameAssist.GameAssistWall;
import game.model.GameFactory;
import view.GameFrame;

/**
 * 
 * @author Doctor邓
 * 游戏负责将游戏的界面和后台逻辑相连接
 * 游戏的主体类，控制游戏主题界面和运行
 */
public class TankClient {
	private GameFrame gameFrame;
	private static GameFactory gameFactory;
	private static DataAdmin admin;
	private static GameListener listener ;
	private GamePaint gamePaint;
	private GameAssistProp gameAssist;
	private GameAssistAI aiAssist;
	private GameAssistWall wallAssist;
	private GameAssistInfor inforAssist;
	private JLabel score = new JLabel("???");;
	private JLabel enemyNum = new JLabel("???");;
	
	/**
	 * 游戏是否在进行的标识，true为在进行，false为已经结束
	 */
	public static boolean gameStatus = false;
	/**
	 * 游戏是否暂停的标识，true为游戏已经暂停，false为游戏没有暂停
	 */
	public static boolean stopStatus = false;
	/**
	 * 游戏是否胜利的标识
	 * 0 为游戏还未开始，或结束
	 * 1为游戏胜利
	 * 2为游戏失败
	 */
	public static int victory = 0;
	
	public TankClient() {
		gameInit();
		assistInit();
		viewInit();
	}
	
	/**
	 * 游戏基本类初始化
	 */
	private void gameInit() {
		admin = new DataAdmin();
		gameFactory = new GameFactory();
		listener = new GameListener(admin);
		gamePaint = new GamePaint(admin);
	}
	
	/**
	 * 游戏辅助进程初始化
	 */
	private void assistInit() {
		/**
		 * 开启自动生成道具的线程
		 */
		gameAssist = new GameAssistProp(admin);
		gameAssist.start();
		/**
		 * 开启自动生成AItank的线程
		 */
		aiAssist = new GameAssistAI(admin, gameFactory, listener);
		aiAssist.start();
		/**
		 * 开启检测老家白墙是否存在，并让白墙自动消失的线程
		 */
		wallAssist = new GameAssistWall(admin);
		wallAssist.start();
		/**
		 * 开启后台更新前台显示的游戏数据（游戏分数和剩余敌人数量）的线程
		 */
		inforAssist = new GameAssistInfor(admin, score, enemyNum);
		inforAssist.start();
	}
	
	/**
	 * 通过玩家指定的游戏人数对游戏的数据进行初始化
	 * @param playerNum
	 */
	public static void gameStart(int playerNum) {
		/*
		 * 初始化游戏的状态 
		 */
		gameStatus = true;
		stopStatus = false;
		victory = 0;
		/**
		 * 清空游戏数据
		 */
		admin.clear();
		/*
		 * 初始化游戏的各种数据 
		 */
		admin.setEnemyNum(20);
		admin.setScore(0);
		admin.getGameHome().setLive(true);
		admin.setMyTanks(gameFactory.getMyTanks(playerNum));
//		admin.setAITanks(gameFactory.getAITanks(3));
		admin.setWalls(gameFactory.getWalls(new GameMap()));
		admin.dataAddListener(listener);
		admin.getGameEnd().dataInit();
		admin.getGameMenu().dataInit();
	}
	/**
	 * 游戏界面初始化
	 */
	private void viewInit() {
		gameFrame = new GameFrame(gamePaint, listener);
		gameFrame.setBackground(new Color(255, 255, 255));
		
		JPanel inforPanel = new JPanel();
		inforPanel.setToolTipText("");
		inforPanel.setBackground(new Color(255, 255, 255));
		inforPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(143, 188, 143), new Color(143, 188, 143), new Color(143, 188, 143), new Color(143, 188, 143)));
		inforPanel.setBounds(800, 0, 294, 172);
		gameFrame.getContentPane().add(inforPanel);
		inforPanel.setLayout(null);
		
		JLabel scoreLabel = new JLabel("游戏分数");
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setForeground(new Color(0, 128, 0));
		scoreLabel.setFont(new Font("楷体", Font.PLAIN, 18));
		scoreLabel.setBounds(10, 10, 89, 28);
		inforPanel.add(scoreLabel);
		
		JLabel lblNewLabel = new JLabel("敌人剩余数量");
		lblNewLabel.setForeground(new Color(153, 50, 204));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 95, 134, 28);
		inforPanel.add(lblNewLabel);
		
		score.setForeground(new Color(255, 0, 0));
		score.setFont(new Font("宋体", Font.PLAIN, 30));
		score.setHorizontalAlignment(SwingConstants.CENTER);
		score.setBounds(101, 48, 89, 37);
		inforPanel.add(score);
		
		enemyNum.setHorizontalAlignment(SwingConstants.CENTER);
		enemyNum.setForeground(Color.RED);
		enemyNum.setFont(new Font("宋体", Font.PLAIN, 30));
		enemyNum.setBounds(101, 128, 89, 37);
		inforPanel.add(enemyNum);
		
		JPanel setPanel = new JPanel();
		setPanel.setBorder(new TitledBorder(new LineBorder(new Color(128, 0, 128), 3), "\u6E38\u620F\u8BBE\u7F6E", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		setPanel.setBounds(800, 175, 294, 280);
		gameFrame.getContentPane().add(setPanel);
		setPanel.setLayout(null);
		
		JButton startGame = new JButton("开始游戏");
		
		startGame.setBounds(38, 60, 93, 23);
		setPanel.add(startGame);
		
		JButton stopGame = new JButton("停止(开始)游戏");
		stopGame.setBounds(163, 60, 121, 23);
		setPanel.add(stopGame);
		
		JButton restartGame = new JButton("重新开始");
		restartGame.setBounds(38, 158, 93, 23);
		setPanel.add(restartGame);
		
		JButton rankGame = new JButton("排行榜");
		rankGame.setBounds(163, 158, 93, 23);
		setPanel.add(rankGame);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)), "\u6E38\u620F\u5E2E\u52A9", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(30, 144, 255)));
		panel.setBounds(800, 465, 294, 197);
		gameFrame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("E:\\win10\\desktop\\test\\image\\menu\\gameHelp.PNG"));
		label.setBounds(10, 36, 274, 130);
		panel.add(label);
		/**
		 * 为每一个按钮都添加键盘监听事件，这样就不会再点击按钮后，
		 * jframe中的键盘事件失灵导致游戏中的坦克无法通过键盘控制移动
		 */
		startGame.addKeyListener(listener);
		stopGame.addKeyListener(listener);
		restartGame.addKeyListener(listener);
		rankGame.addKeyListener(listener);
		
		startGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * 将游戏设置为 未在进行中
				 */
				gameStatus = false;
				/**
				 * 开启游戏重画
				 */
				stopStatus = false;
				/*
				 * 将菜单跳转至选择人数的界面 
				 */
				admin.getGameMenu().setMenuStatus(false);
				/**
				 * 初始化选择界面出现动画的数据
				 */
				admin.getGameMenu().dataInit();
				/**
				 * 默认将游戏人数设置为一人
				 */
				admin.getGameMenu().setPlayerNum(true);
			}
		});
		
		stopGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * 当游戏在进行中才能暂停游戏
				 */
				if (gameStatus == true) {
					if (stopStatus == false) {
						stopStatus = true;
					} else {
						stopStatus = false;
					}
				}
			}
		});
		
		restartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * 当游戏在进行中才能重新开始游戏
				 */
				if (gameStatus == true) {
					gameStart(getPlayerNum());
				}
			}
		});
	}
	
	public static void main(String[] args) {
		TankClient gameRun = new TankClient();
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
	
	public GameFrame getGameFrame() {
		return gameFrame;
	}

	public DataAdmin getAdmin() {
		return admin;
	}
}
