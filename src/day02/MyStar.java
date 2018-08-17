package day02;

import java.awt.*;

public class MyStar {
	public static void main(String args[]) {
		Frame w=new Frame();
		w.setSize(1280, 1080);
		w.setBackground(Color.black);
		
		MyPanel mp=new MyPanel();
		w.add(mp);
			
		w.setVisible(true);
	}
}
class MyPanel extends Panel{
	public void paint(Graphics g) {
		g.setColor(new Color(255,0,255));
		//
		for(int x=0;x<300;x++) {
			g.drawString("*", (int)(Math.random()*1280), (int)(Math.random()*1080));
		}
	}
}
