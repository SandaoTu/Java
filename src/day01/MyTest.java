package day01;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.Graphics;

public class MyTest {
	public static void main(String[] args) {
//		Frame f = new Frame();
//		f.setSize(500, 500);
//		NewPanel np = new NewPanel();
//		f.add(np);
//		f.setVisible(true);
		char a='1';
		char b='1';
		int x=1;
		int y=1;
		int z=156;
		byte w=(byte)z;
		System.out.println("byte w="+w);
		String s1="a";
		String s2="ab";
		System.out.println(s2==s1);
		System.out.println(s1.getBytes());
		System.out.println(s2.getBytes());
		System.out.println(s2.hashCode());

	}
}

//class NewPanel extends Panel {
//	public void paint(Graphics g) {
//		Button btn=new Button("ddd");
//		Panel p=new Panel();
//		p.setSize(100, 200);
//		p.add(btn);
//		p.setVisible(true);
//		g.setColor(new Color(255, 255, 0));
//		g.drawOval(50, 50, 200, 200);
//		g.setColor(new Color(0, 255, 0));
//		g.fillOval(40, 40, 200, 200);
//	}
//}