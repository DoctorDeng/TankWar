package view.viewUtil;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

public class RoundJTextField extends JTextField {
	 private Shape shape;
	 private boolean hover = false;
	 private final Color  hoverBorderColor = new Color(98, 180, 247);
	 private final Color borderColor = new Color(209, 209, 209);
	 private final int hudu_w = 10;
	 private final int hude_h = 10;
	 
	 public RoundJTextField() {
		 super();
		 setOpaque(false); // As suggested by @AVD in comment.
		 
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
			});
	 }
	 
	 protected void paintComponent(Graphics g) {
		 g.setColor(getBackground());
		 g.fillRoundRect(0, 0,  getWidth()-1, getHeight()-1, hudu_w, hude_h);
		 super.paintComponent(g);
	 }
	 
	 protected void paintBorder(Graphics g) {
		 g.setColor(borderColor);
		 g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, hudu_w, hude_h);
		 if (hover) {
			 g.setColor(hoverBorderColor);
			 g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, hudu_w, hude_h);
			 g.drawRoundRect(-1, -1, getWidth(), getHeight(), hudu_w, hude_h);
			 g.drawRoundRect(1, 1, getWidth()-3, getHeight()-3, 0, 0);
			
			 g.setColor(borderColor);
		 }
	 }
	 
	 public boolean contains(int x, int y) {
		 if (shape == null || !shape.getBounds().equals(getBounds())) {
			 shape = new RoundRectangle2D.Double(0.0D, 0.0D,  getWidth()-1, getHeight()-1, 10.0D, 10.0D);
		 }
		 return shape.contains(x, y);
	 }
	 
//	 
//	 public static void main(String[] args){
//		 JFrame frame = new JFrame("Rounded corner text filed demo");
//		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		 frame.setSize(400, 400);
//		 frame.setLayout(new FlowLayout());
//		 JTextField field = new RoundJTextField();
//		 field.setColumns(10);
////		 field.setBounds(0, 0, 100, 50);
//		 field.setPreferredSize(new Dimension(200, 30));
//		 frame.add(field);
//		 frame.setVisible(true);
//		 
//	}
}
	

