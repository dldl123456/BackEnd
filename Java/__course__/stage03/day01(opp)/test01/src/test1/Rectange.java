/*
 *  ���һ��Rectange�����ʾ����
 *  1.����2������width��weight,���Ƿֱ��ʾ�ߺͿ�Ĭ��ֵ��Ϊ1
 *  2.����Ĭ�ϵľ��ε��޲ι��췽��
 *  3.����һ��getArea()�ķ���������������ε����
 *  4.����һ��getPerimeter()�ķ������ؾ��ε��ܳ�
 *  
 */

package test1;

public class Rectange {
	public int width;  //��
	public int height;  //��
	
	//�ڹ��췽���н��г�ʼ��
	public Rectange(){
		width = 1;  
		height = 1;  
	}
	
	//���ε����
	public int getArea(int width, int height){
		return width * height;
	}
	
	//���ε��ܳ�
	public int getPerimeter(int width, int height){
		return (width + height) * 2;
	}
	
	//��������������ڣ�
	public static void main(String[] args) {
		Rectange rtg = new Rectange();  //newһ�����ζ���
		
		int area = 0;  //��������������
		int perimeter = 0;  //����������ε��ܳ�
		
		area = rtg.getArea(rtg.width, rtg.height);  //���þ��ε�����ķ���
		perimeter = rtg.getPerimeter(rtg.width, rtg.height);  //���þ��ε��ܳ��ķ���
		
		System.out.println("�þ��ε�����ǣ�" + area);
		System.out.println("�þ��ε��ܳ��ǣ�" + perimeter);
	}
}
