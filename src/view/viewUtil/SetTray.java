package view.viewUtil;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SetTray {
	
	public void setTrayToFrame(JFrame jframe) {
		if (SystemTray.isSupported()) {
			SystemTray tray = SystemTray.getSystemTray();
			Image imageIco = Toolkit.getDefaultToolkit().getImage("image/loginView/gam2.png");
			ImageIcon icon = new ImageIcon(imageIco);
			TrayIcon trayIcon = new TrayIcon(icon.getImage());
			/**
			 * 设置图片大小自适应，不然图片无法显示
			 */
			trayIcon.setImageAutoSize(true);
			
			trayIcon.addMouseListener(new MouseAdapter()
	         {
	            // 鼠标事件
	            public void mouseClicked(MouseEvent e)
	            {
	            	jframe.setVisible(true);
	            }
	         });
			
			  // 添加工具提示文本
	         trayIcon.setToolTip("Tank War");
	         
	         PopupMenu popupMenu = new PopupMenu();
	         MenuItem showFrame = new MenuItem("打开主面板");
	         popupMenu.add(showFrame);
	         MenuItem exit = new MenuItem("退出");
	         popupMenu.add(exit);
	         popupMenu.addSeparator();
	         
	         showFrame.addActionListener(new ActionListener() { // 点击“显示窗口”菜单后将窗口显示出来
	             public void actionPerformed(ActionEvent e) {
//	                 tray.remove(trayIcon); // 从系统的托盘实例中移除托盘图标
	                 jframe.setVisible(true); // 显示窗口
	             }
	         });
	         
	         exit.addActionListener(new ActionListener() { // 点击“显示窗口”菜单后将窗口显示出来
	             public void actionPerformed(ActionEvent e) {
//	                 tray.remove(trayIcon); // 从系统的托盘实例中移除托盘图标
	            	 System.exit(0);
	             }
	         });
	         
	         // 为托盘图标加弹出菜弹
	         trayIcon.setPopupMenu(popupMenu);
	         
	         try {
				tray.add(trayIcon);
			} catch (AWTException e1) {
				e1.printStackTrace();
			}
		}
		else
	      {
	         JOptionPane.showMessageDialog(null, "操作系统不支持托盘");
	      }
	}
}
