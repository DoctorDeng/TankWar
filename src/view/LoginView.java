package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.sun.awt.AWTUtilities;

import bussiness.UserAction;
import entity.User;
import game.control.TankClient;
import util.OpenURL;
import view.viewUtil.CommanButton;
import view.viewUtil.CommanJPasswordField;
import view.viewUtil.JFrameSet;
import view.viewUtil.RoundJTextField;
import view.viewUtil.SetTray;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 * 游戏登陆的界面
 * @author Doctor邓
 *
 */
public class LoginView {

	private JFrame loginFrame;
	private JPanel loginPanel;
	private JPanel logoPanel;
//	private ScorePointOut pointOut = new ScorePointOut();
	
	private JTextField user_account;
	private JPasswordField user_pwd;
	private JButton loginButton;
	private JLabel error_login;
	private JLabel minimumLabel;
	private JLabel changePwdLabel;
	private JLabel signLabel;
	private JButton cancelLogin;
	private JLabel headLabel;
	
	private UserAction verifyUser = new UserAction();
	private OpenURL openURL = new OpenURL();
	private SetTray setTray = new SetTray();
	
	private final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	private final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	private final Image CLOSE = Toolkit.getDefaultToolkit().getImage("image/loginView/close.png");
	private final Image CLOSE_HOVER = Toolkit.getDefaultToolkit().getImage("image/loginView/closeRed.png");
	private final Image LOGO = Toolkit.getDefaultToolkit().getImage("image/loginView/logo.jpg");
	private final Image TOUXIANG = Toolkit.getDefaultToolkit().getImage("image/loginView/touxiang.png");
	private final Image TANK_LOGO = Toolkit.getDefaultToolkit().getImage("image/loginView/tankLogo.png");
	private final Image MINIMUM = Toolkit.getDefaultToolkit().getImage("image/loginView/minimum.png");
	private final Image MINIMUM_HOVER = Toolkit.getDefaultToolkit().getImage("image/loginView/minimumHover.png");
	
	/*
	 * 用于标识是否被点击过的变量
	 * false : 未被点击多
	 * true  : 被点击过 
	 */
	private boolean isClick = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
					window.loginFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//JFrame.setDefaultLookAndFeelDecorated(true); 
		loginFrame = new JFrame();
		loginFrame.setBackground(new Color(22, 154, 218));
		/**
		 * 设置Frame不显示任务栏图标
		 */
		loginFrame.setType(java.awt.Window.Type.UTILITY); 
		setTray.setTrayToFrame(loginFrame);
		loginFrame.setTitle("Tank  War");
		loginFrame.setIconImage(TANK_LOGO);
		loginFrame.setBounds( (SCREEN_WIDTH - 431)/2, (SCREEN_HEIGHT - 325)/2, 431, 325);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.setResizable(false);
		loginFrame.getContentPane().setLayout(null);
		
		logoPanel = new JPanel();
		logoPanel.setBackground(new Color(22, 154, 218));
		logoPanel.setBounds(0, 0, 436, 181);
		loginFrame.getContentPane().add(logoPanel);
		logoPanel.setLayout(null);
		
		JLabel closeLabel = new JLabel("");
		closeLabel.setIcon(new ImageIcon(CLOSE));
		closeLabel.setBounds(403, -2, 30, 30);
		logoPanel.add(closeLabel);
		
		JLabel logoLabel = new JLabel("");
		logoLabel.setIcon(new ImageIcon(LOGO));
		logoLabel.setBounds(68, 58, 287, 113);
		logoPanel.add(logoLabel);
		
		minimumLabel = new JLabel("");
		minimumLabel.setIcon(new ImageIcon(MINIMUM));
		minimumLabel.setBounds(373, -4, 30, 30);
		logoPanel.add(minimumLabel);
		
		loginPanel = new JPanel();
		loginPanel.setBackground(new Color(235, 242, 249));
		loginPanel.setBounds(0, 182, 436, 150);
		loginFrame.getContentPane().add(loginPanel);
		loginPanel.setLayout(null);
		
		user_account = new RoundJTextField();
		user_account.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user_account.setText("  ");
			}
		});
		user_account.setText("  ");
//		textField.setBorder();
		user_account.setForeground(new Color(0, 0, 0));
		user_account.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		user_account.setBounds(130, 17, 200, 30);
		loginPanel.add(user_account);
		user_account.setColumns(10);
		
		user_pwd = new CommanJPasswordField();
		user_pwd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user_pwd.setText("");
			}
		});
		user_pwd.setFont(new Font("微软雅黑", Font.PLAIN, 19));
		user_pwd.setBounds(130, 47, 200, 30);
		loginPanel.add(user_pwd);
		
		loginButton = new CommanButton("登     陆");
		user_pwd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
				case KeyEvent.VK_ENTER:
					login();
					break;
				}
			}
		});
//		loginButton.setMargin(new Insets(0,0,0,0));
		loginButton.setBorder(null);
		loginButton.setForeground(new Color(240, 248, 255));
		loginButton.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		loginButton.setBackground(new Color(9, 163, 220));
//		loginButton.setFocusPainted(false);
		loginButton.setBounds(130, 99, 200, 30);
		loginPanel.add(loginButton);
		
		cancelLogin = new CommanButton("取   消");
		cancelLogin.setBorder(null);
		cancelLogin.setForeground(new Color(240, 248, 255));
		cancelLogin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		cancelLogin.setBackground(new Color(9, 163, 220));
//		loginButton.setFocusPainted(false);
		cancelLogin.setBounds(130, 99, 200, 30);
		cancelLogin.setVisible(false);
		loginPanel.add(cancelLogin);
		
		
		signLabel = new JLabel("注册账号");
		signLabel.setHorizontalAlignment(SwingConstants.CENTER);
		signLabel.setForeground(new Color(39, 134, 228));
		signLabel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		signLabel.setBounds(340, 23, 54, 15);
		loginPanel.add(signLabel);
		
		changePwdLabel = new JLabel("修改密码");
		changePwdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		changePwdLabel.setForeground(new Color(39, 134, 228));
		changePwdLabel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		changePwdLabel.setBounds(340, 53, 54, 20);
		loginPanel.add(changePwdLabel);
		
		headLabel = new JLabel("");
		headLabel.setIcon(new ImageIcon(TOUXIANG));
		headLabel.setBounds(28, 10, 80, 89);
		loginPanel.add(headLabel);
		
		error_login = new JLabel("");
		error_login.setForeground(Color.RED);
		error_login.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		error_login.setBounds(130, 76, 200, 23);
		loginPanel.add(error_login);
		/**
		 * 窗口关闭的鼠标事件
		 */
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
				System.exit(0);
			}
		});
		/**
		 * 缩小窗口的鼠标事件
		 */
		minimumLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				minimumLabel.setIcon(new ImageIcon(MINIMUM_HOVER));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				minimumLabel.setIcon(new ImageIcon(MINIMUM));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				loginFrame.setVisible(false);
			}
		});
		/**
		 * 登陆的监听事件
		 */
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		/**
		 * 注册的监听事件
		 */
		signLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				signLabel.setForeground(new Color(98, 180, 247));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				signLabel.setForeground(new Color(39, 134, 228));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				openURL.gotoUrl("http://119.29.223.16/JSPStudy/tankWar/signUp.jsp");
			}
		});
		/**
		 * 改密的监听事件
		 */
		changePwdLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changePwdLabel.setForeground(new Color(98, 180, 247));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				changePwdLabel.setForeground(new Color(39, 134, 228));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				openURL.gotoUrl("http://119.29.223.16/JSPStudy/tankWar/login.jsp");
			}
		});
		user_pwd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
				case KeyEvent.VK_ENTER:
					login();
					break;
				}
			}
		});
		user_account.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
				case KeyEvent.VK_ENTER:
					login();
					break;
				}
			}
		});
		/**
		 * 设置窗口无边框
		 */
		new JFrameSet().noBorder(loginFrame);
		/**
		 * 设置窗体为圆角矩形
		 */
		AWTUtilities.setWindowShape(loginFrame, new RoundRectangle2D.Double(  
	            0.0D, 0.0D, loginFrame.getWidth(), loginFrame.getHeight(), 15.0D,  
	            15.0D));  
	}
	/**
	 * 登陆方法
	 */
	public void login() {
		
		LoginPointOut pointOut = new LoginPointOut();
		if (isClick == false) {
			isClick = true;
			pointOut.setVisible(true);
			loginFrame.setVisible(false);
			/**
			 * 在指定时间后执行登陆验证操作
			 */
			Timer timer = new Timer();  
	        timer.schedule(new TimerTask() {  
	            public void run() {  
	            	if ("".equals(user_account.getText().trim()) || "".equals(user_pwd.getText().trim())
	    					|| null == user_account.getText().trim() || null ==user_pwd.getText().trim()) {
	    				
	    				error_login.setText("用户名或密码为空,请重新输入");
	    				isClick = false;
	    				pointOut.setVisible(false);
	    				loginFrame.setVisible(true);
	    			}
	    			else if (verifyUser.verifyUser(user_account.getText().trim(), user_pwd.getText())) {
	    				EventQueue.invokeLater(new Runnable() {
	    					public void run() {
	    						try {
	    							User user = new User(user_account.getText().trim(),user_pwd.getText());
	    							TankClient tankClient = new TankClient(user);
	    						} catch (Exception e) {
	    							e.printStackTrace();
	    						}
	    					}
	    				});
	    				/**
	    				 * 登陆成功后，释放登陆窗口,并退出托盘图标
	    				 */
	    				exit();
	    				isClick = false;
	    				pointOut.dispose();
	    			} 
	    			else {
	    				error_login.setText("用户名或密码错误,请重新输入！");
	    				isClick = false;
	    				pointOut.setVisible(false);;
	    				loginFrame.setVisible(true);
	    			} 
	            }  
	        }, 3000);
			
			
		}
	}
	
	/**
	 * 释放当前窗口和相关的托盘
	 */
	public void exit() {
		loginFrame.dispose();
		setTray.removeTray();
	}
	
	public JTextField getUser_account() {
		return user_account;
	}

	public JPasswordField getUser_pwd() {
		return user_pwd;
	}

	public JButton getLoginButton() {
		return loginButton;
	}

	public JLabel getError_login() {
		return error_login;
	}

	public JLabel getChangePwdLabel() {
		return changePwdLabel;
	}

	public JLabel getSignLabel() {
		return signLabel;
	}

	public JFrame getLoginFrame() {
		return loginFrame;
	}

	public Image getTOUXIANG() {
		return TOUXIANG;
	}

	public JPanel getLoginPanel() {
		return loginPanel;
	}

	public JPanel getLogoPanel() {
		return logoPanel;
	}
}
