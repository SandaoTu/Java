package day03_snow;

import java.awt.*;

//雪花落下
public class MySnow {
	public static void main(String args[]) {
		Frame w = new Frame();
		w.setSize(1280, 1080);
		w.setBackground(Color.black);

		MyPanel mp = new MyPanel();
		w.add(mp);

		Thread t = new Thread(mp);
		t.start();

		w.setVisible(true);
	}
}

// 画布
class MyPanel extends Panel implements Runnable {

	int x[] = new int[300];
	int y[] = new int[300];

	// 构造方法
	public MyPanel() {
		for (int i = 0; i < 300; i++) {
			x[i] = (int) (Math.random() * 1280);
			y[i] = (int) (Math.random() * 1080);
		}
	}

	public void paint(Graphics g) {
		g.setColor(new Color(255, 0, 255));
		for (int i = 0; i < 300; i++) {
			g.drawString("*", x[i], y[i]);
		}

	}

	public void run() {
		while (true) {
			try {
				for (int i = 0; i < 300; i++) {
					y[i]++;
					if (y[i] > 1080) {
						y[i] = 0;
					}
				}
				Thread.sleep(20);
			} catch (Exception e) {
			}

			repaint();
		}
	}

}