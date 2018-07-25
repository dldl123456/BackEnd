package StudentMS;

public class Test {
	public int method1(){
        int n = 5;
        return  n;
	}
	
	public void method2(){
	        int j = this.method1();  //调用方法1中的整数
	        System.out.println(j);
	}
	
	public static void main(String[] args) {
		Test t = new Test();
		t.method2();
	}
}
