package project.StudentMS_4;

import java.util.Random;

//生成验证码
public class RandomGen{
	//生成四位不重复的验证码
	public static String getCodeGen(){
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
			//随机产生一个下标，通过下标取出字符数组中的对应的字符
			char c = codeSequence[radom.nextInt(codeSequence.length)];
			
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