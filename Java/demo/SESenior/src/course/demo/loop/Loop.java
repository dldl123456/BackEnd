package course.demo.loop;

public class Loop {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {  //控制总体行数
			for (int j = 4-i; j >0; j--) {  //每行空格数
				System.out.print(" ");
			}
			
			for (int j = 0; j < i; j++) {  //每行*数
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
}
