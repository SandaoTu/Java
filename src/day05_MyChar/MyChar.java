package day05_MyChar;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyChar {
	public static void main(String args[]) {
		JFrame w = new JFrame();
		w.setSize(800, 900);
		
		MyPanel mp = new MyPanel();
		mp.setBackground(Color.black);
		w.add(mp);
	
		Thread t = new Thread(mp);
		t.start();

		w.addKeyListener(mp);
		mp.addKeyListener(mp);

		w.setVisible(true);
	}
}

class MyPanel extends JPanel implements Runnable, KeyListener {
	int x[] = new int[10];
	int y[] = new int[10];
	char c[] = new char[10];
	int score = 1000;

	public MyPanel() {
		for (int i = 0; i < 10; i++) {
			x[i] = (int) (Math.random() * 800);
			y[i] = (int) (Math.random() * 500);
			c[i] = (char) (Math.random() * 26 + 97);
		}

	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(new Color(255, 0, 255));
		g.drawString("Score =" + score, 50, 50);
		g.setColor(Color.white);
		for (int i = 0; i < 10; i++) {
			g.drawString(new Character(c[i]).toString(), x[i], y[i]);
		}
		g.setColor(Color.blue);
		g.fillRect(0, 798, 800, 100);
	}

	@Override
	public void run() {
		while (true) {
			try {
				for (int i = 0; i < 10; i++) {
					y[i]++;
					if (y[i] > 800) {
						y[i] = 0;
						c[i] = (char) (Math.random() * 26 + 97);
					}
				}
				Thread.sleep(30);
			} catch (Exception e) {
			}
			repaint();
		}

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
//		boolean mark = false;
		int nowY = -1;
		int nowIndex = -1;
		for (int i = 0; i < 10; i++) {
			if (c[i] == arg0.getKeyChar()) {
				if (y[i] > nowY) {
					nowIndex = i;
					nowY = y[i];
				}
//				mark = true;
			}

		}
		if (nowIndex>-1) {
			y[nowIndex] = 0;
			c[nowIndex] = (char) (Math.random() * 26 + 97);
			score += 10;
		} else {
			score -= 100;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

}