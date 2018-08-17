//keyboard control the ball
package day04_ball;

import java.awt.*;
import java.awt.event.*;

public class MyBall {
	public static void main(String args[]) {
		// new Frame Object
		Frame w = new Frame(); // declare and instantiation
		w.setSize(800, 600);// set size of windows
		
		MyPanel mp = new MyPanel();
		w.add(mp);// add the object of MyPanel to the window
		//registered with a component using the component's addKeyListener method
		w.addKeyListener(mp);
		mp.addKeyListener(mp);//avoid failing to receive keyboard events when clicking on the Panel
		
		w.setVisible(true);

	}
}

// define MyPanel class
class MyPanel extends Panel implements KeyListener {
	// overriding the method of 'paint'
	int x=300;
	int y=100;
	static int aa=3;
	public void paint(Graphics g) {
		g.fillOval(x, y, 100, 100);// draw a oval
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		//control the direction of the ball
		if(arg0.getKeyCode()==37) {
			x--;
		}//towards the left
		if(arg0.getKeyCode()==38) {
			y--;
		}//towards the above
		if(arg0.getKeyCode()==39) {
			x++;
		}//towards the right
		if(arg0.getKeyCode()==40) {
			y++;
		}//towards the below
		repaint();
//		System.out.println(arg0.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}