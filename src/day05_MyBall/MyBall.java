package day05_MyBall;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MyBall {
	public static void main(String args[]) {
		Frame w = new Frame();
		w.setSize(800, 900);

		MyPanel mp = new MyPanel();
		w.add(mp);

		w.addMouseMotionListener(mp);
		mp.addMouseMotionListener(mp);

		w.addMouseListener(mp);
		mp.addMouseListener(mp);

		w.setVisible(true);
	}
}

class MyPanel extends Panel implements MouseMotionListener, MouseListener {
	int x = 150;
	int y = 150;
	int p = 0;
	int q = 0;

	public void paint(Graphics g) {
		g.fillOval(x, y, 150, 150);
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		x = arg0.getX() - p;
		y = arg0.getY() - q;
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		p = arg0.getX() - x;
		q = arg0.getY() - y;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}