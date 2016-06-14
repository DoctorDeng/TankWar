package view.viewUtil;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPasswordField;

public class CommanJPasswordField extends JPasswordField{
	 private Shape shape;
	 private boolean hover = false;
	 private final Color  hoverBorderColor = new Color(98, 180, 247);
	 private final Color borderColor = new Color(209, 209, 209);
	 private final int HUDU_W = 10;
	 private final int HUDU_H = 10;
	 
	 
	 public CommanJPasswordField() {
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
		 g.fillRoundRect(0, 0,  getWidth()-1, getHeight()-1, HUDU_W, HUDU_H);
		 super.paintComponent(g);
	 }
	 
	 protected void paintBorder(Graphics g) {
		 g.setColor(borderColor);
		 g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 10, 10);
		 
		 if (hover) {
			 g.setColor(hoverBorderColor);
			 g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, HUDU_W, HUDU_H);
			 g.drawRoundRect(-1, -1, getWidth(), getHeight(), HUDU_W, HUDU_H);
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
}
