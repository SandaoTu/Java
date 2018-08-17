package day14;
import java.sql.*;

public class TestSQL {
	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
			System.out.println("zuihou");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
