/*
 *  ���������ַ�����������������һ��,
 *  ���n�Σ��������飬���ж�������г��ִ��������ַ���
 */

package demo.ease.randomStr;

import java.util.Scanner;

public class RandomStr_1 {
	//�ж��ַ��������г��ִ�������Ԫ��
	public static String majorityElement(String[] arr){
		int i; //ѭ���Ĳ���
    	int count = 0;  //ͳ�ƴ���
    	String temp = null;  //�������淵�صĽ��
        
    	for(i=0; i<arr.length; i++){
        		if(count == 0){
            		temp = arr[i];
            			count++;
        		}else{
            		if(temp == arr[i]){
            			count++;
            		}else{
            			count--;
            		} 
        		}
    	}
		return temp;
	}
	
	public static void main(String[] args) {
		//�������
		int num,i;  //���������������ѭ������
		String str = null;  //�������������ַ���
		int n = 0;  //��������������Ҫѭ���Ĵ���
		//��ʾ
		System.out.print("������������Ҫ����������ֵĸ�����");
		
		//��ȡ����
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		in.close();
		
		//����
		System.out.println();
		
		//�������飬������ָ������
		String[] arr = new String[n];
		
		//��ʼѭ������ȡn������ַ���
		for(i=0; i<n; i++){
			num = (int)(Math.random()*3+1);  //ȡ�����1-3
			
			switch(num){
				case 1:
					str = "����";
					break;
				case 2:
					str = "С��";
					break;
				case 3:
					str = "����";
					break;
			}
			
			if(i == n-1){
				System.out.print(str + "\n\n");
			}else{
				System.out.print(str + ",");
			}
			
			//���õ����ַ����ֱ��������
			arr[i] = str;
		}
		
		//����ַ��������г��������ַ���
		System.out.println("\"" + majorityElement(arr) + "\"������ֳ��ִ������\n�Ժ�������־ͽ�\"" + majorityElement(arr) + "\"���������� !^_^");
	}
}
