package view.reference;

import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class SystemTrayDemo
{
   public static void main(String[] args)
   {
      // 判断是否支持系统托盘
      if (SystemTray.isSupported())
      {
         // 获取图片所在的URL
         URL url = SystemTrayDemo.class.getResource("image/loginView/close.png");
         Image image1=Toolkit.getDefaultToolkit().getImage("image/loginView/close.png");
         // 实例化图像对象
         ImageIcon icon = new ImageIcon(image1);
         // 获得Image对象
         Image image = icon.getImage();
         // 创建托盘图标
         TrayIcon trayIcon = new TrayIcon(image);
         // 为托盘添加鼠标适配器
         trayIcon.addMouseListener(new MouseAdapter()
         {
            // 鼠标事件
            public void mouseClicked(MouseEvent e)
            {
               // 判断是否双击了鼠标
               if (e.getClickCount() == 2)
               {
                  JOptionPane.showMessageDialog(null, "SystemTrayDemo");
               }
            }
         });
         // 添加工具提示文本
         trayIcon.setToolTip("本地连接\r\n速度：100.0 Mbps\r\n状态：已连接上");
         // 创建弹出菜单
         PopupMenu popupMenu = new PopupMenu();
         popupMenu.add(new MenuItem("禁用(D)"));
         popupMenu.add(new MenuItem("状态(S)"));
         popupMenu.add(new MenuItem("修复(P)"));
         popupMenu.addSeparator();
         popupMenu.add(new MenuItem("更改 Windows 防火墙设置(C)"));
         popupMenu.addSeparator();
         popupMenu.add(new MenuItem("打开网络连接(O)"));

         // 为托盘图标加弹出菜弹
         trayIcon.setPopupMenu(popupMenu);
         // 获得系统托盘对象
         SystemTray systemTray = SystemTray.getSystemTray();
         try
         {
            // 为系统托盘加托盘图标
            systemTray.add(trayIcon);
         }
         catch (Exception e)
         {
            e.printStackTrace();
         }
      }
      else
      {
         JOptionPane.showMessageDialog(null, "not support");
      }
   }
}
