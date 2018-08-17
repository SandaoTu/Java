package day11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class QQ {
	public static void main(String args[]) {
		QQLogin qq = new QQLogin();

		qq.setVisible(true);
	}
}

// login panel
class QQLogin extends JFrame implements ActionListener {
	JTextField txtUser = new JTextField();
	JPasswordField pfPsd = new JPasswordField();

	// constructor
	QQLogin() {
		this.setSize(280, 160);
		this.setLocation(500, 200);
		// new components
		JLabel labUser = new JLabel("UserName");
		JLabel labPsd = new JLabel("Password");
		JButton btnLogin = new JButton("Login");
		JButton btnRegister = new JButton("Register");
		JButton btnCancel = new JButton("Cancel");
		// new panel
		JPanel pan1 = new JPanel();
		pan1.setLayout(new GridLayout(2, 2));
		// add component to panel
		pan1.add(labUser);
		pan1.add(txtUser);
		pan1.add(labPsd);
		pan1.add(pfPsd);
		// new panel
		JPanel pan2 = new JPanel();
		pan2.setLayout(new FlowLayout());
		// new component to panel
		pan2.add(btnLogin);
		pan2.add(btnRegister);
		pan2.add(btnCancel);

		// add panel to frame
		this.setLayout(new BorderLayout());
		this.add(pan1, BorderLayout.CENTER);
		this.add(pan2, BorderLayout.SOUTH);
		// add actionlistener to the login button
		btnLogin.addActionListener(this);
		btnRegister.addActionListener(this);
		btnCancel.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("Login")) {
			try {
				//client
				String user=txtUser.getText();
				String pass=pfPsd.getText();
				//new Socket
				Socket s=new Socket("127.0.0.1",8888);
				System.out.println(user);
				//
				OutputStream os =s.getOutputStream();
				OutputStreamWriter osw=new OutputStreamWriter(os);
				PrintWriter pw=new PrintWriter(osw,true);
				pw.println(user+"%"+pass);
				//
				InputStream is=s.getInputStream();
				InputStreamReader isr=new InputStreamReader(is);
				BufferedReader br=new BufferedReader(isr);
				
				String yorn=br.readLine();
				System.out.println(yorn);
				if(yorn.equals("ok")) {
					this.setVisible(false);
					QQMain m=new QQMain();
					m.setSocket(s);
					m.setVisible(true);
					
				}else {
					JOptionPane.showMessageDialog(this,"sorry,Username or password error!");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}

// message panel
class QQMain extends JFrame implements ActionListener{
	private Socket s;
	JTextField txtMess=new JTextField();
	JTextArea txtContent=new JTextArea();
	public void setSocket(Socket value){
		s=value;
	}
	// constructor
	QQMain() {
		this.setSize(500, 700);
		this.setLocation(400, 50);
		//new components
		JComboBox comUser=new JComboBox();
		JButton btnSend=new JButton("Send");
		JScrollPane spContent=new JScrollPane(txtContent);
		//new panel
		JPanel panSmall=new JPanel();
		panSmall.setLayout(new GridLayout(1,2));
		panSmall.add(comUser);
		panSmall.add(btnSend);
		//new big panel
		JPanel panBig=new JPanel();
		panBig.setLayout(new GridLayout(2,1));
		panBig.add(txtMess);
		panBig.add(panSmall);
		//add the panel to frame
		this.setLayout(new BorderLayout());
		this.add(panBig,BorderLayout.NORTH);
		this.add(spContent, BorderLayout.CENTER);
		//add actionlistener to btnSend
		btnSend.addActionListener(this);
		//receive message from qq.txt file
		try {
			File inFile=new File("C:\\Users\\Administrator\\Desktop\\code\\qq\\qq.txt");
			FileReader fr=new FileReader(inFile);
			BufferedReader br=new BufferedReader(fr);
			while(br.ready()) {
				txtContent.append(br.readLine()+"\n");
			}
			
		}catch(Exception ee) {
			
		}
		
		
	}
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getActionCommand().equals("Send")) {
			txtContent.append(txtMess.getText()+"\n");
			try {
				File outFile=new File("C:\\Users\\Administrator\\Desktop\\code\\qq\\qq.txt");
				FileWriter fw=new FileWriter(outFile,true);
				PrintWriter pw=new PrintWriter(fw,true);
				pw.println(txtMess.getText());
				
				
			}catch(Exception e) {
				e.printStackTrace();;
			}
			//send message to server
			try {
				OutputStream os=s.getOutputStream();
				OutputStreamWriter osw=new OutputStreamWriter(os);
				PrintWriter pw=new PrintWriter(osw,true);
				
				pw.println(txtMess.getText());
				
			}catch(Exception ee) {
				
			}
			txtMess.setText("");
		}
	}
}