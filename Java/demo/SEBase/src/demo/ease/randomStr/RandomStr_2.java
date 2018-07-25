/*
 *  定义三个字符串，并随机输出其中一个
 */

package demo.ease.randomStr;

public class RandomStr_2 {
	public static void main(String[] args) {
		String[] str = { "嘿嘿", "嘻嘻", "哈哈", "嘎嘎", "呜呜" };
		int random = (int) ( Math.random () * 5 );
		System.out.println (str[random]);
	}
}
