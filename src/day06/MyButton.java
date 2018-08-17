package day06;

import java.awt.*;
import javax.swing.*;
public class MyButton{
	public static void main(String args[]) {
		JFrame w=new JFrame();
		w.setSize(350, 150);

		//set Layout
		w.setLayout(new BorderLayout());
		//new pane one
		JPanel mp1=new JPanel();
		w.add(mp1,BorderLayout.CENTER);
		//set mp1 Layout
		mp1.setLayout(new GridLayout(2,2));
		//add label and field to mp1
		JLabel l1=new JLabel("用户名");
		JLabel l2=new JLabel("密码");
		JTextField t=new JTextField();
		JPasswordField p=new JPasswordField();
		mp1.add(l1);
		mp1.add(t);
		mp1.add(l2);
		mp1.add(p);
		//new panel two
		JPanel mp2=new JPanel();
		w.add(mp2,BorderLayout.SOUTH);
		//set mp2 layout
		mp2.setLayout(new FlowLayout());
		//add button to mp2
		JButton b1=new JButton("登录");
		JButton b2=new JButton("注册");
		JButton b3=new JButton("取消");
		mp2.add(b1);
		mp2.add(b2);
		mp2.add(b3);
		
		w.setVisible(true);
	}
}