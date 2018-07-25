package project.StudentMS_4;

import java.util.Random;

//������֤��
public class RandomGen{
	//������λ���ظ�����֤��
	public static String getCodeGen(){
		//һ���ַ�����
		char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
				'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
				'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
				'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
				'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		
		Random radom = new Random();  //�����
		StringBuilder sb = new StringBuilder();  //��̬�ַ���
		int count = 0;  //������
		
		while(true){
			//�������һ���±꣬ͨ���±�ȡ���ַ������еĶ�Ӧ���ַ�
			char c = codeSequence[radom.nextInt(codeSequence.length)];
			
			//����ȡ�������ַ��ڶ�̬�ַ����в����ڣ�����û���ظ�
			if(sb.indexOf(c + "") == -1){
				sb.append(c);  //׷�ӵ���̬�ַ�����
				count++;
				
				if(count == 4){
					break;
				}
			}
		}
		
		//�����ַ���
		return sb.toString();
	}
}