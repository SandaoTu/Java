package day10;

import java.net.*;
import java.io.*;

public class MyClient {
	public static void main(String args[]) {
		try {
			// new socket
			Socket s = new Socket("127.0.0.1", 8000);
			// s.getOutputStream().write(100);
			// achieve outputstream
			OutputStream os = s.getOutputStream();
			//create channel
			OutputStreamWriter osw=new OutputStreamWriter(os);
			//operating the channel,set auto refresh
			PrintWriter pw=new PrintWriter(osw,true);
			
			pw.println("zhengrenwei");
			//receive message from server
			InputStream is=s.getInputStream();
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader br=new BufferedReader(isr);
			
			System.out.println(br.readLine());
			
		} catch (Exception e) {
		}
	}
}
