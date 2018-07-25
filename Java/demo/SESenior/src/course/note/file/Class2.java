package course.note.file;

/**
 * 递归
 */

public class Class2 {
	public static void main(String[] args) {
		test(10);
	}
	
	public static void test(int value){
		System.out.println(value);
		if(value == 0) {
			return;
		} else {
 			test(--value);
			//不能用value--，
		}
		/*System.out.println(value);
		test(--value);
		直接溢出，没有条件*/
	}
}
