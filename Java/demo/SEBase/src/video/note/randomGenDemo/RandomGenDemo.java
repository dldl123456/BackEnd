/*
 *  随机验证码
 */

package video.note.randomGenDemo;

import java.util.Random;

public class RandomGenDemo {
	//测试类
	public static void main(String[] args) {
		//调用一个静态的方法(类名.方法名)
		System.out.println("四位验证码：" + RandomGen.codeGen());
	}
}

//生成验证码
class RandomGen{
//这个类里面没有属性，纯粹是一个功能的方法，为外面的人提供相应的验证码
//这种情况没必要产生对象，所以用static，代表一个静态的方法
	//生成四位不重复的验证码
	public static String codeGen(){
		//一个字符数组
		char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
				'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
				'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
				'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
				'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		
		Random radom = new Random();  //随机数
		StringBuilder sb = new StringBuilder();  //动态字符串
		int count = 0;  //计数器
		
		while(true){
			//radom.nextInt(codeSequence.length);表示下标
			//根据下标取出字符数组对应下标的字符
			//随机产生一个下标，通过下标取出字符数组中的对应的字符
			char c = codeSequence[radom.nextInt(codeSequence.length)];
			
			//判断动态字符串中有没有
			//任何字符加上空字符串，就是字符串连接
			//假设取出来的字符在动态字符串中不存在，代表没有重复
			if(sb.indexOf(c + "") == -1){
				sb.append(c);  //追加到动态字符串中
				count++;
				
				if(count == 4){
					break;
				}
			}
		}
		//返回字符串
		return sb.toString();
	}
}
