package day08;

import java.io.*;

public class IOTest {
	public static void main(String args[]) {
		try {
			//��λ����Դ
//			File f=new File("C:/Users/Administrator/Desktop/code/test.txt");
//			File fCopy=new File("C:/Users/Administrator/Desktop/code/newtest.txt");
			File f=new File("D:\\01_ѧϰ\\���ѧϰ-Java\\API�ĵ�\\jdk-source-master\\jdk1.9\\src.zip");
			File fCopy=new File("D:\\01_ѧϰ\\���ѧϰ-Java\\working\\src.zip");
			//�����ܵ�
			FileInputStream fis=new FileInputStream(f);
			FileOutputStream fos=new FileOutputStream(fCopy);
			//�����ܵ�
			byte[] tmp=new byte[8192];
			int length=fis.available()/8192;
			
			for(int i=0;i<length;i++) {
				System.out.println(i);
				//read from fis and  write to tmp
				fis.read(tmp);
				//read from tmp and write in fos
				fos.write(tmp);
			}
			int size=fis.read(tmp);
			fos.write(tmp, 0, size);
			
		}catch(Exception e) {}
	}

}
