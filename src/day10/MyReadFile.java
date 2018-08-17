package day10;

import java.io.*;

public class MyReadFile {
	public static void main(String args[]) {
		try {
			//location
			File f=new File("C:\\Users\\Administrator\\Desktop\\code\\test.txt");
			File fCopy=new File("C:\\Users\\Administrator\\Desktop\\code\\test1.txt");
			//create channel
			FileReader fr=new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
			
			FileWriter fw=new FileWriter(fCopy);
//			BufferedWriter bw=new BufferedWriter(fw);
			PrintWriter pw=new PrintWriter(fw);
			while(br.ready()) {
//				pw.write(br.readLine());
				pw.println(br.readLine());
				System.out.print("ddd");
//				fw.write(br.readLine());
			}
			//close
//			fw.close();
			fw.flush();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}
}
