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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.sun.awt.AWTUtilities;

import bussiness.VerifyUserAction;
import game.gameRun.TankClient;
import view.viewUtil.CommanButton;
import view.viewUtil.CommanJPasswordField;
import view.viewUtil.JframeNoBorder;
import view.viewUtil.OpenURL;
import view.viewUtil.RoundJTextField;

public class LoginView {

	private JFrame loginFrame;
	private VerifyUserAction verifyUser = new VerifyUserAction();;
	private JTextField user_account;
	private JPasswordField user_pwd;
	private JButton loginButton;
	private JLabel error_login;
	private OpenURL openURL = new OpenURL();
	
	private final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	private final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	private final Image CLOSE = Toolkit.getDefaultToolkit().getImage("image/loginView/close.png");
	private final Image CLOSE_HOVER = Toolkit.getDefaultToolkit().getImage("image/loginView/closeRed.png");
	private final Image LOGO = Toolkit.getDefaultToolkit().getImage("image/loginView/logo.jpg");
	private final Image TOUXIANG = Toolkit.getDefaultToolkit().getImage("image/loginView/touxiang.png");
	private final Image TANK_LOGO = Toolkit.getDefaultToolkit().getImage("image/loginView/tankLogo.png");
	
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
		loginFrame.setTitle("Tank  War");
		loginFrame.setIconImage(TANK_LOGO);
		loginFrame.setBounds( (SCREEN_WIDTH - 431)/2, (SCREEN_HEIGHT - 325)/2, 431, 325);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.setResizable(false);
		loginFrame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(22, 154, 218));
		panel.setBounds(0, 0, 436, 181);
		loginFrame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel closeLabel = new JLabel("");
		closeLabel.setIcon(new ImageIcon(CLOSE));
		closeLabel.setBounds(403, -2, 30, 30);
		panel.add(closeLabel);
		
		JLabel logoLabel = new JLabel("");
		logoLabel.setIcon(new ImageIcon(LOGO));
		logoLabel.setBounds(66, 50, 319, 110);
		panel.add(logoLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(235, 242, 249));
		panel_1.setBounds(0, 182, 436, 150);
		loginFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		user_account = new RoundJTextField();
		user_account.setText("  ");
//		textField.setBorder();
		user_account.setForeground(new Color(0, 0, 0));
		user_account.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		user_account.setBounds(130, 17, 200, 30);
		panel_1.add(user_account);
		user_account.setColumns(10);
		
		user_pwd = new CommanJPasswordField();
		user_pwd.setFont(new Font("微软雅黑", Font.PLAIN, 19));
		user_pwd.setBounds(130, 47, 200, 30);
		panel_1.add(user_pwd);
		
		loginButton = new CommanButton("登     陆");
//		loginButton.setMargin(new Insets(0,0,0,0));
		loginButton.setBorder(null);
		loginButton.setForeground(new Color(240, 248, 255));
		loginButton.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		loginButton.setBackground(new Color(9, 163, 220));
//		loginButton.setFocusPainted(false);
		loginButton.setBounds(130, 99, 200, 30);
		panel_1.add(loginButton);
		
		JLabel signLabel = new JLabel("注册账号");
		signLabel.setHorizontalAlignment(SwingConstants.CENTER);
		signLabel.setForeground(new Color(39, 134, 228));
		signLabel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		signLabel.setBounds(340, 23, 54, 15);
		panel_1.add(signLabel);
		
		JLabel changePwdLabel = new JLabel("找回密码");
		changePwdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		changePwdLabel.setForeground(new Color(39, 134, 228));
		changePwdLabel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		changePwdLabel.setBounds(340, 53, 54, 20);
		panel_1.add(changePwdLabel);
		
		JLabel headLabel = new JLabel("");
		headLabel.setIcon(new ImageIcon(TOUXIANG));
		headLabel.setBounds(28, 10, 80, 89);
		panel_1.add(headLabel);
		
		error_login = new JLabel("");
		error_login.setForeground(Color.RED);
		error_login.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		error_login.setBounds(130, 76, 200, 23);
		panel_1.add(error_login);
		
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
		
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verifyUser();
			}
		});
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
				openURL.gotoUrl("http://doctordeng.github.io/signUp.html");
			}
		});
		
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
				openURL.gotoUrl("http://doctordeng.github.io/changePwd.html");
			}
		});
		
		new JframeNoBorder().noBorder(loginFrame);
		/**
		 * 设置窗体为圆角矩形
		 */
		AWTUtilities.setWindowShape(loginFrame, new RoundRectangle2D.Double(  
	            0.0D, 0.0D, loginFrame.getWidth(), loginFrame.getHeight(), 15.0D,  
	            15.0D));  
	}
	
	public void verifyUser() {
		if (isClick == false) {
			isClick = true;
			if ("".equals(user_account.getText().trim()) || "".equals(user_pwd.getText().trim())
					|| null == user_account.getText().trim() || null ==user_pwd.getText().trim()) {
				error_login.setText("用户名或密码为空,请重新输入");
				isClick = false;
			}
			else if (verifyUser.verify(user_account.getText().trim(), user_pwd.getText())) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							TankClient tankClient = new TankClient();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				/**
				 * 登陆成功后，释放登陆窗口
				 */
				loginFrame.dispose();
				isClick = false;
			} 
			else {
				error_login.setText("用户名或密码错误,请重新输入！");
				isClick = false;
			}
		}
	}
}
