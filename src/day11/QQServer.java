package day11;

import java.net.*;
import java.io.*;

public class QQServer {
	public static void main(String args[]) {
		try {
		
			ServerSocket ss=new ServerSocket(8888);
			System.out.println("listen before...");
			
			Socket s=ss.accept();
			System.out.println("listen after...");
			//
			InputStream is=s.getInputStream();
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader br=new BufferedReader(isr);
			//
			String uandp=br.readLine();
			String u="";
			String p="";
			try {
				u=uandp.split("%")[0];
				p=uandp.split("%")[1];
			}catch(Exception e) { 
				
			}
			System.out.println("name or password error");
			
			System.out.println(u+"pass"+p);
			//output message to client
			OutputStream os=s.getOutputStream();
			OutputStreamWriter osw=new OutputStreamWriter(os);
			PrintWriter pw=new PrintWriter(osw,true);
			//estimate 
			if(u.equals("111")&&p.equals("111")) {
				pw.println("ok");
					while(true) {
						String message=br.readLine();
						System.out.println(message);
					}
			}else {
				pw.println("err");
				
			}
			
		}catch(Exception e) {
			
		}
		
		
	}
}
