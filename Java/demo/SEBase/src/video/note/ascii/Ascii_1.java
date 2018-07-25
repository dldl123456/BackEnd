/*
 * 把小写b转换成大写a
 */

package video.note.ascii;

public class Ascii_1 {
	public static void main(String[] args) {
		char ch = 'b';
		System.out.println("原始值：" + ch);
		ch = 'b' - 33;
		System.out.println("转换后：" + ch);
		/*System.out.println('b' - 'A');
        ltoc('b');*/
	}
	
	/*public static void ltoc(char ch) {
        ch -= 33;
        System.out.println(ch);
    }*/
}
