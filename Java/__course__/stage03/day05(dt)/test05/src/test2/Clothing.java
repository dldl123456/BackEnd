/*
 *  ��װ�඼���Դ���
 */

package test2;

public class Clothing extends Goods implements IWearable {
	//���췽��
	public Clothing(String name) {
		super(name);  //���ø����һ�������Ĺ��췽��
	}

	//��д��ʵ�֣��ӿڴ�������
	public void wearable(){
		System.out.println(getName() + "���Դ���");
	}
}
