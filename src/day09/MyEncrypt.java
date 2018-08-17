package day09;

import java.io.*;

//encryption class
public class MyEncrypt {
	public static void main(String args[]) {
		try {
			//write key.key file
			//location
			File fKey=new File("C:\\Users\\Administrator\\Desktop\\code\\key.key");
			//create channel
			FileInputStream fisKey=new FileInputStream(fKey);
			//operating channel
			int key[]=new int[128];
			for(int i=0;i<128;i++) {
				key[i]=fisKey.read();
//				System.out.print(key[i]);
			}
			//encrypt the file
			//location
			File fSrc=new File("C:\\Users\\Administrator\\Desktop\\code\\test.txt");
			File fEnc=new File("C:\\Users\\Administrator\\Desktop\\code\\enc.txt");
			//create channel
			FileInputStream fis=new FileInputStream(fSrc);
			FileOutputStream fos=new FileOutputStream(fEnc);
			//operating the channel
			int length=fis.available();
			for(int i=0;i<length;i++) {
				fos.write(fis.read()+key[i%128]);
			}
			System.out.print("encrypt success!");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
