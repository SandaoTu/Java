package day06;

import javax.swing.*;
import java.awt.*;

public class QQMain {
	public static void main(String args[]) {
		JFrame w = new JFrame();
		w.setSize(300, 400);
		// new component
		JTextField txtMess=new JTextField();
		JTextArea messgInput = new JTextArea();
		JScrollPane spContent = new JScrollPane(messgInput);
		
		JComboBox comBox = new JComboBox();
		JButton enterButton = new JButton("·¢ËÍ");
		// new panel
		JPanel smallPanel = new JPanel();
		// set layout
		smallPanel.setLayout(new GridLayout(1, 2));
		// add component to panel
		smallPanel.add(comBox);
		smallPanel.add(enterButton);
		// new big panel
		JPanel bigPanel = new JPanel();
		// set layout
		bigPanel.setLayout(new BorderLayout());
		// add component to big panel
		bigPanel.add(txtMess, BorderLayout.CENTER);
		bigPanel.add(smallPanel, BorderLayout.SOUTH);
		// set windows layout
		w.setLayout(new BorderLayout());
		w.add(bigPanel, BorderLayout.NORTH);
		w.add(spContent, BorderLayout.CENTER);

		w.setVisible(true);

	}
}
