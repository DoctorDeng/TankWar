package view.viewUtil;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Font;

public class CommanButton extends JButton {
	private Shape shape;
	/**
	 * 矩形边框的圆角弧度
	 */
	private int HU_1 = 5;
	private int HU_2 = 5;
	private Color COLOR = new Color(9,163,220);
	private Color COLOR_ENTERED = new Color(60, 195, 245);
	private Color COLOR_EXITED = new Color(9, 140, 188);
	
	private boolean hover;
	private boolean click;
	
	public CommanButton(String text) {
		super(text);
		setFont(new Font("微软雅黑", Font.PLAIN, 14));
		setBorderPainted(false);
		setFocusPainted(false);
		setContentAreaFilled(false);
		setForeground(Color.WHITE);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hover = true;
				repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				hover = false;
				repaint();
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				click = true;
				repaint();
			}
			
			
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		Shape clip = g2d.getClip();
	
        //绘制整个按钮
		RoundRectangle2D.Float r2d = new RoundRectangle2D.Float(0, 0, getWidth() - 1,
				getHeight() - 1,  HU_1,  HU_2);
		g2d.clip(r2d);
		g2d.setColor(COLOR);
		g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1,  HU_1,  HU_2);
		
		if (hover) {
			RoundRectangle2D.Float r2d2 = new RoundRectangle2D.Float(0, 0,
					getWidth() -1, getHeight()-1,  HU_1,  HU_2);
			g2d.clip(r2d2);
			g2d.setColor(COLOR_ENTERED);
			g2d.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, HU_1,  HU_2);
			g2d.setColor(COLOR);
		}
		
		if (click) {
			RoundRectangle2D.Float r2d2 = new RoundRectangle2D.Float(0, 0,
					getWidth()-1, getHeight()-1,  HU_1,  HU_2);
			g2d.clip(r2d2);
			g2d.setColor(COLOR_EXITED);
			g2d.fillRoundRect(0, 0, getWidth(), getHeight() , HU_1,  HU_2);
			g2d.setColor(COLOR);
			click = false;
		}
		
		g2d.dispose();
		super.paintComponent(g);
	}
	
	@Override
	protected void paintBorder(Graphics g) {
		
	}

	public Color getCOLOR() {
		return COLOR;
	}

	public void setCOLOR(Color cOLOR) {
		COLOR = cOLOR;
	}

	public Color getCOLOR_ENTERED() {
		return COLOR_ENTERED;
	}

	public void setCOLOR_ENTERED(Color cOLOR_ENTERED) {
		COLOR_ENTERED = cOLOR_ENTERED;
	}

	public Color getCOLOR_EXITED() {
		return COLOR_EXITED;
	}

	public void setCOLOR_EXITED(Color cOLOR_EXITED) {
		COLOR_EXITED = cOLOR_EXITED;
	}

	public int getHU_1() {
		return HU_1;
	}

	public int getHU_2() {
		return HU_2;
	}

	public void setHU_1(int hU_1) {
		HU_1 = hU_1;
	}

	public void setHU_2(int hU_2) {
		HU_2 = hU_2;
	}
	
//	public static void main(String[] args){
//		 JFrame frame = new JFrame("Rounded corner text filed demo");
//		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		 frame.setSize(400, 400);
//		 frame.getContentPane().setLayout(new FlowLayout());
//		 CommanButton button = new CommanButton("222");
////	 	 field.setColumns(10);
//////	 field.setBounds(0, 0, 100, 50);
//		 button.setPreferredSize(new Dimension(200, 30));
//		 frame.getContentPane().add(button);
//		 frame.setVisible(true);
//	 }
//	
}
