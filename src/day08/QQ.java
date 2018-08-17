package day08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QQ {
	public static void main(String args[]) {
		QQLogin qq = new QQLogin();
		qq.setVisible(true);

	}
}

// QQLogin class define
class QQLogin extends JFrame implements ActionListener {

	static JTextField txtUser = new JTextField();
	static JPasswordField txtPsd = new JPasswordField();

	// ¹¹Ôìº¯Êýconstructors
	QQLogin() {
		this.setSize(300, 160);
		// new component
		JLabel lbUser = new JLabel("UserName");
		JLabel lbPsd = new JLabel("Password");
		JButton btnLogin = new JButton("Login");
		JButton btnReg = new JButton("Register");
		JButton btnCancel = new JButton("Cancel");
		// new pan1
		JPanel pan1 = new JPanel();
		pan1.setLayout(new GridLayout(2, 2));
		pan1.add(lbUser);
		pan1.add(txtUser);
		pan1.add(lbPsd);
		pan1.add(txtPsd);
		// new pan2
		JPanel pan2 = new JPanel();
		pan2.setLayout(new FlowLayout());
		pan2.add(btnLogin);
		pan2.add(btnReg);
		pan2.add(btnCancel);
		// add panel to frame
		this.setLayout(new BorderLayout());
		this.add(pan1, BorderLayout.CENTER);
		this.add(pan2, BorderLayout.SOUTH);
		// add actionlistener for the login button
		btnLogin.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Login")) {
			if(txtUser.getText().equals("111")&&(new String(txtPsd.getPassword())).equals("123")) {
				this.setVisible(false);
				QQMain qqMain=new QQMain();
				qqMain.setVisible(true);
				System.out.println("Login success!");
			}
		}
//		this.setVisible(false);
//		QQMain qqMain=new QQMain();
//		qqMain.setVisible(true);
	}
}
//QQMain class define
class QQMain extends JFrame{
	//constructors
	QQMain(){
		this.setSize(300,400);
		//new component
		JTextField txtMess=new JTextField();
		JComboBox cmbUser=new JComboBox();
		JButton btnSend=new JButton("Send");
		JTextArea txtContent=new JTextArea();
		JScrollPane spContent=new JScrollPane(txtContent);
		//new small panel
		JPanel panSmall=new JPanel();
		panSmall.setLayout(new GridLayout(1,2));
		//add componet to the panel
		panSmall.add(cmbUser);
		panSmall.add(btnSend);
		//new big panel
		JPanel panBig=new JPanel();
		panBig.setLayout(new GridLayout(2,1));
		//add component
		panBig.add(txtMess);
		panBig.add(panSmall);
		//
		this.setLayout(new BorderLayout());
		this.add(panBig,BorderLayout.NORTH);
		this.add(spContent,BorderLayout.CENTER);
	}
	
}

