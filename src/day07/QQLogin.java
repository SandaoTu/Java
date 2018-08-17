package day07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class QQLogin {
	public static void main(String args[]) {
		QQPanel w = new QQPanel();
		w.setVisible(true);
	}
}

class QQPanel extends JFrame implements ActionListener,KeyListener {
	static JTextField txtUser = new JTextField();
	static JPasswordField psdPass = new JPasswordField();

	QQPanel() {
		this.setSize(250, 160);
		// new component
		JLabel lbUser = new JLabel("ÕË»§");
		JLabel lbPass = new JLabel("ÃÜÂë");

		JButton btnLogin = new JButton("µÇÂ¼");
		JButton btnRegister = new JButton("×¢²á");
		JButton btnCancel = new JButton("È¡Ïû");
		// new panel up
		JPanel panUp = new JPanel();
		panUp.setLayout(new GridLayout(2, 2));
		// add component to panUp
		panUp.add(lbUser);
		panUp.add(txtUser);
		panUp.add(lbPass);
		panUp.add(psdPass);
		// new panel down
		JPanel panDown = new JPanel();
		panDown.setLayout(new FlowLayout());
		panDown.add(btnLogin);
		panDown.add(btnRegister);
		panDown.add(btnCancel);
		// add panel to frame
		this.setLayout(new BorderLayout());
		this.add(panUp, BorderLayout.CENTER);
		this.add(panDown, BorderLayout.SOUTH);

		btnLogin.addActionListener(this);
		btnRegister.addActionListener(this);
		//add Keylistener
		txtUser.addKeyListener(this);
		psdPass.addKeyListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getActionCommand().equals("µÇÂ¼")) {
			if (txtUser.getText().equals("aaa") && psdPass.getText().equals("123")) {
				System.out.println("µÇÂ¼³É¹¦");
				this.setVisible(false);
				QQMain m=new QQMain();
				m.setVisible(true);
			} else {
				System.out.println("µÇÂ¼Ê§°Ü");
			}

		}
		if (arg0.getActionCommand().equals("×¢²á")) {
			System.out.println("×¢²á");

		}

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.VK_ENTER==arg0.getKeyCode()) {
			if (txtUser.getText().equals("aaa") && psdPass.getText().equals("123")) {
				System.out.println("µÇÂ¼³É¹¦");
				this.setVisible(false);
				QQMain m=new QQMain();
				m.setVisible(true);
			} else {
				System.out.println("µÇÂ¼Ê§°Ü");
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

class QQMain extends JFrame {
	QQMain() {
		this.setSize(300, 400);
		// new component
		JTextField txtMess = new JTextField();
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
		this.setLayout(new BorderLayout());
		this.add(bigPanel, BorderLayout.NORTH);
		this.add(spContent, BorderLayout.CENTER);

//		this.setVisible(true);

	}
}
