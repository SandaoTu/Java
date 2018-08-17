package ball;

public class MyBall{
	public static void main(String args[]) {
		Father p=new Son();
		System.out.println(p.i);
		System.out.println(((Son)p).i);
		System.out.println(p.aaa());
	}
}
class Father{
	
	int i=10;
	public int aaa() {
		int x=40;
		return x;
	}
}
class Son extends Father{
	int i=200;
	public int aaa() {
		int x=300;
		return super.aaa();
//		return x;
	}
	
}
