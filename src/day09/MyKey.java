package day09;
import java.io.*;
//new key file class
public class MyKey {
	public static void main(String args[]) {
		try {
			//location
			File f=new File("C:\\Users\\Administrator\\Desktop\\code\\key.key");
			//create channel
			FileOutputStream fos=new FileOutputStream(f);
			//operating channel
			for(int i=0;i<128;i++) {
				fos.write((int)(Math.random()*128));
			}
			System.out.println("new key.key file");
		}catch(Exception e) {}
	}
}