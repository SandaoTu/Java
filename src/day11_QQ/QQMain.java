package day11_QQ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class QQMain extends JFrame implements ActionListener {
	JTextField txtMess = new JTextField();
	JTextArea txtContent = new JTextArea();
	//set socket
	private Socket s;
	public void setSocket(Socket value) {
		s=value;
	}

	QQMain() {
		this.setSize(500, 700);
		this.setLocation(350, 50);
		// new components
		JComboBox comUser = new JComboBox();
		JButton btnSend = new JButton("Send");
		JScrollPane spContent = new JScrollPane(txtContent);
		// new small panel
		JPanel panSmall = new JPanel();
		panSmall.setLayout(new GridLayout(1, 2));
		panSmall.add(comUser);
		panSmall.add(btnSend);
		// new big panel
		JPanel panBig = new JPanel();
		panBig.setLayout(new GridLayout(2, 1));
		panBig.add(txtMess);
		panBig.add(panSmall);
		// add panel to frame
		this.setLayout(new BorderLayout());
		this.add(panBig, BorderLayout.NORTH);
		this.add(spContent, BorderLayout.CENTER);
		// add actionlistener to btnSend
		btnSend.addActionListener(this);
		//
		try {
			File inFile=new File("c:/Users/Administrator/Desktop/code/qq.txt");
			FileReader fr= new FileReader(inFile);
			BufferedReader br=new BufferedReader(fr);
			
			while(br.ready()) {
				txtContent.append(br.readLine()+"\n");
			}
			
		}catch(Exception ee) {
			
		}

	}

	//
	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand().equals("Send")) {
			txtContent.append(txtMess.getText() + "\n");
			try {
				File outFile = new File("C:/Users/Administrator/Desktop/code/qq.txt");
				FileWriter fw=new FileWriter(outFile,true);
				PrintWriter pw=new PrintWriter(fw,true);
				
				pw.println(txtMess.getText());
				
			} catch (Exception ee) {

			}
			try {
				//send message to server
				OutputStream os=s.getOutputStream();
				OutputStreamWriter osw=new OutputStreamWriter(os);
				PrintWriter pw=new PrintWriter(osw,true);
				pw.println(txtMess.getText());
			}catch(Exception e) {
				
			}
			
			
			// set txtMess null
			txtMess.setText("");
		}

	}

}
