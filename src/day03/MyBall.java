package day03;

import java.awt.*;

//小球撞墙
public class MyBall {
	public static void main(String agrs[]) {
		Frame w = new Frame();
		w.setSize(400, 500);

		MyPanel mp = new MyPanel();
		w.add(mp);

		Thread t = new Thread(mp);
		t.start();

		w.setVisible(true);
	}
}

class MyPanel extends Panel implements Runnable {
	int x = 200;
	int y = 0;
	int att = 0;// 0是右下，1是左下，2是左上，3是右上

	public void paint(Graphics g) {
		g.fillOval(x, y, 50, 50);
	}

	public void run() {
		while (true) {
			// 定义飞行姿态
			if (att == 0) {
				x++;
				y++;
			}
			if (att == 1) {
				x--;
				y++;
			}
			if (att == 2) {
				x--;
				y--;
			}
			if (att == 3) {
				x++;
				y--;
			}

			// 改变飞行状态
			try {
				Thread.sleep(10);
			} catch (Exception e) {
			}

			if (x > 350) {
				if (att == 0) {
					att = 1;
				} else {
					att = 2;
				}
			}
			if (x < 0) {
				if (att == 2) {
					att = 3;
				} else {
					att = 0;
				}
			}
			if (y > 350) {
				if (att == 1) {
					att = 2;
				} else {
					att = 3;
				}
			}
			if (y < 0) {
				if (att == 3) {
					att = 0;
				} else {
					att = 1;
				}
			}

			repaint();
		}

	}
}
