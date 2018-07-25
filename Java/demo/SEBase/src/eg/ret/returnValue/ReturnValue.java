package eg.ret.returnValue;

public class ReturnValue {
	public static int add(int x,int y) {
		return x+y;
	}
	
	public static void main(String[] args) {
		int b = add(3,4);
		System.out.println(b);
	}
}
