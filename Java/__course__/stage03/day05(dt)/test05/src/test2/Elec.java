/*
 *  �����඼���Գ��
 */

package test2;

public class Elec extends Goods implements IChargeable {
	//���췽��
	public Elec(String name){
		super(name);  //���ø����һ�������Ĺ��췽��
	}
	
	//��д��ʵ�֣��ӿڳ�緽��
	public void chargeable(){
		System.out.println(getName() + "���Գ��");
	}
}
