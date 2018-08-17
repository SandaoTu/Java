package day09;

import java.io.*;

//decryption class
public class MyDecrypt {
	public static void main(String args[]) {
		try {
			// write key.key file
			// location
			File fKey = new File("C:\\Users\\Administrator\\Desktop\\code\\key.key");
			// create channel
			FileInputStream fisKey = new FileInputStream(fKey);
			//operating the channel
			int key[]=new int[128];
			for(int i=0;i<128;i++) {
				key[i]=fisKey.read();
			}
			//decryption
			//location
			File fEnc=new File("C:\\Users\\Administrator\\Desktop\\code\\enc.txt");
			File fDec=new File("C:\\Users\\Administrator\\Desktop\\code\\dec.txt");
			//create the channel
			FileInputStream fis=new FileInputStream(fEnc);
			FileOutputStream fos=new FileOutputStream(fDec);
			//operating the channel
			int length=fis.available();
			for(int i=0;i<length;i++) {
				System.out.print("sdfsdfsd");
				fos.write(fis.read()-key[i%128]);
			}
			System.out.println("\n"+"decrypt the file success");
			
			
		} catch (Exception e) {
		}


	}
}
