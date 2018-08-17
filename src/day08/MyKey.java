package day08;

import java.io.*;

public class MyKey {
	public static void main(String args[]) {
		try {
			//location
			File outFile =new File("C:\\Users\\Administrator\\Desktop\\code\\key.key");
			
			//create chanel
			FileOutputStream fos=new FileOutputStream(outFile);
			//operating the channel
			
			for(int i=0;i<128;i++) {
				fos.write((int)(Math.random()*128));
				System.out.println(i);
			}
			
		}catch(Exception e) {}
	}

}
