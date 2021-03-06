package view.reference;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class SysTray extends JFrame{
	
	public SysTray() {
		init();
	}
	
	public void init() {
		
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);
		this.setTray();
		this.setVisible(true);
	}
	
	//添加托盘显示：1.先判断当前平台是否支持托盘显示
	public void setTray() {
		
		if(SystemTray.isSupported()){//判断当前平台是否支持托盘功能
			//创建托盘实例
			SystemTray tray = SystemTray.getSystemTray();
			//创建托盘图标：1.显示图标Image 2.停留提示text 3.弹出菜单popupMenu 4.创建托盘图标实例
			//1.创建Image图像
			Image image = Toolkit.getDefaultToolkit().getImage("image/loginView/game3.png");
			//2.停留提示text
			String text = "MySystemTray";
			//3.弹出菜单popupMenu
			PopupMenu popMenu = new PopupMenu();
			MenuItem itmOpen = new MenuItem("Open");
			itmOpen.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					Show();
				}				
			});
			MenuItem itmHide = new MenuItem("UnVisible");
			itmHide.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					UnVisible();
				}
			});
			MenuItem itmExit = new MenuItem("Exit");
			itmExit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					Exit();
				}
			});
			popMenu.add(itmOpen);
			popMenu.add(itmHide);
			popMenu.add(itmExit);
			
			//创建托盘图标
			TrayIcon trayIcon = new TrayIcon(image,text,popMenu);
			//将托盘图标加到托盘上
			try {
				tray.add(trayIcon);
			} catch (AWTException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	//内部类中不能直接调用外部类（this不能指向）
	public void UnVisible() {
		this.setVisible(false);
	}
	public void Show() {
		this.setVisible(true);
	}
	public void Exit() {
		System.exit(0);
	}
	
	
	public static void main(String[] args) {
		new SysTray();
	}
}


