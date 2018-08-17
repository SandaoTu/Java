package day10;

import java.net.*;
import java.io.*;

public class MyServer {
	public static void main(String srgs[]) {
		try {
			// lister port
			ServerSocket ss = new ServerSocket(8000);
			System.out.println("lister before......");
			// achieve socket
			Socket s = ss.accept();
			
			// achieve inputstream
			InputStream is = s.getInputStream();
			// new channel
			InputStreamReader isr = new InputStreamReader(is);
			// operating channel
			BufferedReader br = new BufferedReader(isr);

			String name=br.readLine();
			System.out.println(name);
			//return message to client
			OutputStream os=s.getOutputStream();
			OutputStreamWriter osw=new OutputStreamWriter(os);
			//set auto refresh
			PrintWriter pw=new PrintWriter(osw,true);
			
			pw.println("Welcome "+name);

		} catch (Exception e) {
		}

	}
}
