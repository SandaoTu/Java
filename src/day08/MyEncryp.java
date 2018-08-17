package day08;

import java.io.*;

//encryption
public class MyEncryp {
	public static void main(String args[]) {
		try {
			// location
			File inFile = new File("C:\\Users\\Administrator\\Desktop\\code\\test.txt");
			File outFile = new File("C:\\Users\\Administrator\\Desktop\\code\\newtest.txt");
			// create channel
			FileInputStream fis = new FileInputStream(inFile);
			FileOutputStream fos = new FileOutputStream(outFile);
			// operating the channel
			int length = fis.available();
			for (int i = 0; i < length; i++) {
				fos.write(fis.read()+10);
				System.out.println(i);
			}
		} catch (Exception e) {
		}
	}
}
// decryption
