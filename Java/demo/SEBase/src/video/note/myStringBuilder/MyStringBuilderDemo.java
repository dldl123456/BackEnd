/*
 *  �Զ���һ���Լ���StringBuilder��
 */

package video.note.myStringBuilder;

import java.util.Arrays;

public class MyStringBuilderDemo {
	//���������������
	public static void main(String[] args) {
		MyStringBuilder msb = new MyStringBuilder();
		
		msb.append("1sd");
		msb.append("123").append("zzz123123");
		
		System.out.println("�ַ�������" + msb.length());
		System.out.println("��������С��" + msb.capacity());
		System.out.println("�ַ�������" + msb);  //�൱��toString����
	}
}

class MyStringBuilder{
	private char[] value;  //�ַ�����
	private int count = 0;  //�ַ��������ַ��ĸ���
	
	//���췽��
	public MyStringBuilder(){  //����
		value = new char[16];
	}
	
	public MyStringBuilder(int capacity){
		value = new char[capacity];
	}
	
	public MyStringBuilder(String str){
		value = new char[str.length()+16];
	}
	
	//�õ��ַ������е��ַ�����
	public int length(){
		return count;
	}
	
	//����������������С
	public int capacity(){
		return value.length;
	}
	
	//ʵ��׷���ַ���
	public MyStringBuilder append(String str){
		int len = str.length();  //��ȡҪ����ַ����ĳ���
		//ȷ���ַ������ܷŽ�ȥ����ӵ��ַ���
		ensureCapacity(count+len);
		//��Ҫ��ӵ��ַ���׷�ӵ��µ�ָ�������ָ��λ�õĺ���
		str.getChars(0, len, value, count);
		count += len;  //Ԫ�صĸ���������
		
		//���ص�ǰ���������Ķ�̬�ַ���
		return this;
	}
	
	//ȷ���ַ������ܷŽ�ȥ����ӵ��ַ���(�����һ����������)
	//�ж��Ƿ�Ҫ����
	private void ensureCapacity(int capacity){
		//���ݳ�����������С
		if(capacity-value.length>0){
			int newCapacity = value.length*2+2;  //���ݺ����ַ�����Ĵ�С
			value = Arrays.copyOf(value, newCapacity);  //���������鵽�������в�����Ϊ�����������
		}
	}
	
	//���ַ������е��ַ�ת�����ַ�����ʾ
	public String toString(){
		return new String(value, 0, count);
	}
}

