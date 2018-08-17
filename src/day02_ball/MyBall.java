package day02_ball;
import java.awt.*;
import javax.swing.*;

public class MyBall {
	public static void main(String args[]) {
		JFrame w=new JFrame();
		w.setSize(1280, 1080);
		MyPanel mp=new MyPanel();
		mp.setBackground(Color.black);
		w.add(mp);
		
		Thread t=new Thread(mp);
		t.start();
		
		w.setVisible(true);
		
	}
}
class MyPanel extends JPanel implements Runnable {
	int x=500;
	int y=200;
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.red);
		g.fillOval(x, y, 200, 200);
		
	}
	public void run() {
		while(true) {
			try {
				Thread.sleep(100);
			}catch(Exception e) {}
			y=y+10;
			if(y>1080) {
				y=200;
			}
			repaint();
		}
	}
}