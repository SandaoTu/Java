package day11_QQ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class QQLogin extends JFrame implements ActionListener {
	JTextField txtUser = new JTextField();
	JPasswordField pfPass = new JPasswordField();

	// constructor
	public QQLogin() {
		this.setSize(270, 160);
		this.setLocation(500, 100);
		// new components
		JLabel labUser = new JLabel("UserName");
		JLabel labPass = new JLabel("Password");
		JButton btnLogin = new JButton("Login");
		JButton btnRegister = new JButton("Register");
		JButton btnCancel = new JButton("Cancel");
		// new pan1
		JPanel pan1 = new JPanel();
		pan1.setLayout(new GridLayout(2, 2));
		pan1.add(labUser);
		pan1.add(txtUser);
		pan1.add(labPass);
		pan1.add(pfPass);
		// new pan2
		JPanel pan2 = new JPanel();
		pan2.setLayout(new FlowLayout());
		pan2.add(btnLogin);
		pan2.add(btnRegister);
		pan2.add(btnCancel);

		// add panel to frame
		this.setLayout(new BorderLayout());
		this.add(pan1, BorderLayout.CENTER);
		this.add(pan2, BorderLayout.SOUTH);
		// add action listener to button
		btnLogin.addActionListener(this);
		btnRegister.addActionListener(this);
		btnCancel.addActionListener(this);
	}

	//
	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand().equals("Login")) {
			//new socket
			try {
				Socket s=new Socket("127.0.0.1",8888);
				//send username and password to server 
				String user=txtUser.getText();
				String pass=pfPass.getText();
				
				OutputStream os=s.getOutputStream();
				OutputStreamWriter osw=new OutputStreamWriter(os);
				PrintWriter pw=new PrintWriter(osw,true);
				pw.println(user+"%"+pass);
				//receive message from server
				InputStream is=s.getInputStream();
				InputStreamReader isr=new InputStreamReader(is);
				BufferedReader br=new BufferedReader(isr);
				String yorn=br.readLine();
				System.out.println(yorn);
				if(yorn.equals("ok")) {
					this.setVisible(false);
					QQMain m=new QQMain();
					m.setVisible(true);
					m.setSocket(s);
					System.out.println("login");
					
				}else {
					JOptionPane.showMessageDialog(this,"sorry user or password error");
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}

		}
		if (ae.getActionCommand().equals("Register")) {
			System.out.println("Register");
		}
		if (ae.getActionCommand().equals("Cancel")) {
			System.out.println("Cancel");
		}
	}

}
