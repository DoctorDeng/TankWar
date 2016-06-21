package game.control;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import entity.User;
import game.dataEntity.GameMap;
import game.gameAssist.GameAssistAI;
import game.gameAssist.GameAssistInfor;
import game.gameAssist.GameAssistProp;
import game.gameAssist.GameAssistScore;
import game.gameAssist.GameAssistWall;
import game.model.GameFactory;
import view.GameFrame;
import view.viewUtil.CommanButton;

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
	private GameAssistScore scoreAssist;
	private JLabel score = new JLabel("? ? ?");;
	private JLabel enemyNum = new JLabel("? ? ?");;
	
	private final Image CLOSE = Toolkit.getDefaultToolkit().getImage("image/loginView/close.png");
	private final Image CLOSE_HOVER = Toolkit.getDefaultToolkit().getImage("image/loginView/closeRed.png");
//	private final Image LOGO = Toolkit.getDefaultToolkit().getImage("image/loginView/logo.jpg");
//	private final Image TOUXIANG = Toolkit.getDefaultToolkit().getImage("image/loginView/touxiang.png");
//	private final Image TANK_LOGO = Toolkit.getDefaultToolkit().getImage("image/loginView/tankLogo.png");
	private final Image MINIMUM = Toolkit.getDefaultToolkit().getImage("image/loginView/minimum.png");
	private final Image MINIMUM_HOVER = Toolkit.getDefaultToolkit().getImage("image/loginView/minimumHover.png");
	
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
	
	public TankClient(User user) {
		gameInit(user);
		assistInit();
		viewInit();
	}
	
	/**
	 * 游戏基本类初始化
	 */
	private void gameInit(User user) {
		admin = new DataAdmin();
		/**
		 * 将用户的信息放入数据中心中
		 */
		admin.getUser().setUser_account(user.getUser_account());
		admin.getUser().setUser_pwd(user.getUser_pwd());
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
		/**
		 * 在每次游戏开始时都将游戏的分数存入用户对象中
		 */
		admin.getUser().setUser_score(admin.getScore());;
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
		gameFrame.setBackground(new Color(0, 0, 0));
		
		JPanel inforPanel = new JPanel();
		inforPanel.setToolTipText("");
		inforPanel.setBackground(new Color(255, 153, 0));
		inforPanel.setBounds(800, 29, 294, 191);
		gameFrame.getContentPane().add(inforPanel);
		inforPanel.setLayout(null);
//		Image image1 = Toolkit.getDefaultToolkit().getImage("image/startGame.png");
//		Image image2 = image1.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		
		JPanel scorePanel = new JPanel();
		scorePanel.setBackground(new Color(204,51, 204));
		scorePanel.setBounds(0, 91, 294, 50);
		inforPanel.add(scorePanel);
		scorePanel.setLayout(null);
		
		JLabel scoreLabel = new JLabel("Score   -->");
		scoreLabel.setBounds(0, 0, 152, 50);
		scorePanel.add(scoreLabel);
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setForeground(new Color(255, 255, 255));
		scoreLabel.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 20));
		score.setBounds(147, -2, 147, 50);
		scorePanel.add(score);
		
		score.setForeground(new Color(255, 255, 255));
		score.setFont(new Font("MV Boli", Font.PLAIN, 30));
		score.setHorizontalAlignment(SwingConstants.CENTER);
//		Image image3 = Toolkit.getDefaultToolkit().getImage("image/grade.png");
		
		JPanel aiNumPanel = new JPanel();
		aiNumPanel.setBackground(new Color(204, 51, 204));
		aiNumPanel.setBounds(0, 141, 294, 50);
		inforPanel.add(aiNumPanel);
		aiNumPanel.setLayout(null);
		
		JLabel aiNumLabel = new JLabel("Ai Num  -->");
		aiNumLabel.setBounds(0, 0, 147, 50);
		aiNumPanel.add(aiNumLabel);
		aiNumLabel.setForeground(new Color(255, 255, 255));
		aiNumLabel.setHorizontalAlignment(SwingConstants.CENTER);
		aiNumLabel.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 20));
		enemyNum.setBounds(147, 0, 147, 50);
		aiNumPanel.add(enemyNum);
		
		enemyNum.setHorizontalAlignment(SwingConstants.CENTER);
		enemyNum.setForeground(new Color(255, 255, 255));
		enemyNum.setFont(new Font("MV Boli", Font.PLAIN, 30));
		
		Image animalImage1 = Toolkit.getDefaultToolkit().getImage("image/animal/dog1.png");
		Image animalImage2 = Toolkit.getDefaultToolkit().getImage("image/animal/cat6.png");
		Image animalImage3 = Toolkit.getDefaultToolkit().getImage("image/animal/dog2.png");
		
		JLabel animal1 = new JLabel("");
		animal1.setBounds(15, 10, 70, 70);
		animal1.setIcon(new ImageIcon(imageAdapt(animalImage1, animal1.getWidth(), animal1.getHeight())));
		inforPanel.add(animal1);
		
		JLabel animal2 = new JLabel("");
		animal2.setBounds(115, 10, 70, 70);
		animal2.setIcon(new ImageIcon(imageAdapt(animalImage2, animal2.getWidth(), animal2.getHeight())));
		inforPanel.add(animal2);
		
		JLabel animal3 = new JLabel("");
		animal3.setBounds(215, 10, 70, 70);
		animal3.setIcon(new ImageIcon(imageAdapt(animalImage3, animal3.getWidth(), animal3.getHeight())));
		inforPanel.add(animal3);
		
		JPanel setPanel = new JPanel();
		setPanel.setBackground(new Color(255, 255, 255));
		setPanel.setBounds(800, 220, 294, 255);
		gameFrame.getContentPane().add(setPanel);
		setPanel.setLayout(null);
		
		CommanButton startGame = new CommanButton("开始游戏");
		startGame.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		startGame.setHU_1(0);
		startGame.setHU_2(0);
		startGame.setCOLOR(new Color(153, 204, 51));
		startGame.setBounds(0, 0, 148, 132);
		setPanel.add(startGame);
		
		CommanButton stopGame = new CommanButton("停止(开始)游戏");
		stopGame.setText("停止(开始)");
		stopGame.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		stopGame.setHU_1(0);
		stopGame.setHU_2(0);
		stopGame.setCOLOR(new Color(255, 102, 51));
		stopGame.setBounds(147, 0, 148, 132);
		setPanel.add(stopGame);
		
		CommanButton restartGame = new CommanButton("重新开始");
		restartGame.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		restartGame.setHU_1(0);
		restartGame.setHU_2(0);
		restartGame.setCOLOR(new Color(204, 0, 255));
		restartGame.setBounds(0, 131, 148, 125);
		setPanel.add(restartGame);
		
		CommanButton rankGame = new CommanButton("排行榜");
		rankGame.setText("上传分数");
		rankGame.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		rankGame.setHU_1(0);
		rankGame.setHU_2(0);
		rankGame.setCOLOR(new Color(255, 51, 204));
		rankGame.setBounds(147, 131, 148, 125);
		setPanel.add(rankGame);
		
		JPanel hepPanel = new JPanel();
		hepPanel.setBackground(new Color(22, 154, 218));
		hepPanel.setBounds(800, 473, 294, 208);
		gameFrame.getContentPane().add(hepPanel);
		hepPanel.setLayout(null);
		
		JLabel helpLabel = new JLabel("");
		Image image = Toolkit.getDefaultToolkit().getImage("image/gameHelp.jpg");
		helpLabel.setBounds(0, 0, 294, 208);
		helpLabel.setIcon(new ImageIcon(imageAdapt(image, helpLabel.getWidth(), helpLabel.getHeight())));
		hepPanel.add(helpLabel);
//		inforBgLabel.setIcon(new ImageIcon(imageAdapt(inforBg, inforBgLabel.getWidth(), inforBgLabel.getHeight())));
		
		JPanel closePanel = new JPanel();
		closePanel.setBackground(new Color(22,154,218));
		closePanel.setBounds(800, -1, 294, 30);
		gameFrame.getContentPane().add(closePanel);
		closePanel.setLayout(null);
		
		JLabel closeLabel = new JLabel("");
		closeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				closeLabel.setIcon(new ImageIcon(CLOSE_HOVER));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				closeLabel.setIcon(new ImageIcon(CLOSE));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				gameFrame.getSetTray().removeTray();
				System.exit(0);
			}
		});
		closeLabel.setIcon(new ImageIcon(CLOSE));
		closeLabel.setBounds(265, -1, 30, 30);
		closePanel.add(closeLabel);
		
		JLabel minimumLabel = new JLabel("");
		minimumLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				minimumLabel.setIcon(new ImageIcon(MINIMUM_HOVER));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				minimumLabel.setIcon(new ImageIcon(MINIMUM));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				gameFrame.setVisible(false);
			}
		});
		minimumLabel.setIcon(new ImageIcon(MINIMUM));
		minimumLabel.setBounds(235, -1, 30, 30);
		closePanel.add(minimumLabel);
		
		JLabel lblAthuor = new JLabel("         --By  Docotr");
		lblAthuor.setVerticalAlignment(SwingConstants.BOTTOM);
		lblAthuor.setForeground(new Color(255, 255, 255));
		lblAthuor.setFont(new Font("MV Boli", Font.BOLD, 18));
		lblAthuor.setBounds(0, -1, 225, 30);
		closePanel.add(lblAthuor);
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
		
		rankGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/**
				 * 当游戏结束时才能够上传分数
				 */
				if (!gameStatus) {
					scoreAssist = new GameAssistScore(admin, gameFrame);
					scoreAssist.start();
				}
			}
		});
	}
	
	public static void main(String[] args) {
		User user = new User("Test", "123456");
		TankClient gameRun = new TankClient(user);
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
	
	public Image imageAdapt(Image image,int width, int height) {
		Image image1 = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return image1;
	}
}
