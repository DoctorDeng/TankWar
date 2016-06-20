package view.reference;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Test4Rotate extends JFrame {
    private static final long serialVersionUID = 1L;
    public static void main(String[] args) {
        new Test4Rotate();
    }
    
    public Test4Rotate() {
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final MyPanel mp = new MyPanel();
        getContentPane().add(mp);
        
        mp.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mousePressed(MouseEvent mouseevent) {
                int diagonal = (int)(50/Math.sin(Math.toRadians(45)));
                int x = 5 + (diagonal-50)/2;
                int y = 5 + (diagonal-50)/2;
                mp.bi = new BufferedImage(diagonal + 10 , diagonal + 10, BufferedImage.TRANSLUCENT);
                Graphics g = mp.bi.getGraphics();
                g.setColor(Color.red);
                g.drawLine(x, y, x+50, y);
                g.setColor(Color.blue);
                g.drawLine(x+50, y, x+50, y+50);
                g.setColor(Color.green);
                g.drawLine(x, y, x, y+50);
                g.setColor(Color.orange);
                g.drawLine(x, y+50, x+50, y+50);
                mp.repaint();
            }
        });
        
        JButton jb = new JButton();
        jb.setText("right 15°");
        jb.setSize(80, 20);
        jb.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent arg0) {
                mp.rotate = (mp.rotate + 15) % 360;
                mp.repaint();
            }
        });
        mp.add(jb);
        
        
        setVisible(true);
    }
    
    class MyPanel extends JPanel {
        private static final long serialVersionUID = 1L;
        private BufferedImage bi = null;
        private double rotate = 0;
        AffineTransform trans = null;
        private Image back = null;
        public MyPanel() {
            super();
            setOpaque(false);
            trans = new AffineTransform();
            try {
                back = ImageIO.read(new File("image/color1.png"));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        @Override
        public void paintComponent(Graphics g) {
            g.drawImage(back, 0, 0, 500, 300, null);
            if (null != bi) {
                Graphics2D gg = (Graphics2D)g;
                trans.setToIdentity();
                trans.setToRotation(Math.toRadians(rotate), bi.getWidth()/2, bi.getHeight()/2);
                //gg.drawImage(back, trans, null);
                gg.drawImage(bi, trans, null);
            }
            super.paintComponent(g);
            
        }
        
    }
}