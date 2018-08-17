package day08;

import java.io.*;

//class decryption
public class MyDecrypt {
	public static void main(String args[]) {
		try {
			// location
			File inFile = new File("C:\\Users\\Administrator\\Desktop\\code\\newtest.txt");
			File outFile = new File("C:\\Users\\Administrator\\Desktop\\code\\newtest1.txt");
			// create channel
			FileInputStream fis=new FileInputStream(inFile);
			FileOutputStream fos=new FileOutputStream(outFile);
			//operating the channel
			int length=fis.available();
			System.out.print(length);
			for(int i=0;i<length;i++) {
				System.out.println(i);
				fos.write(fis.read()-10);
			}
			
		}catch(Exception e) {}
	}
}
