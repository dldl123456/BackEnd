/*
 *  �ӿڵ����ñ�������������ʵ����Ķ���
 *  �ӿ�ʵ���˶�̬
 */

package test2;

//��Ʒ�ࣨ���ࣩ
public class Goods {
	private String name;  //��Ʒ����
	
	//���췽��
	public Goods(String name){
		this.name = name;
	}
	
	//��ȡ��Ʒ��
	public String getName(){
		return name;
	}
	
	//ʵ�ֳ��ӿ�
	void chargeable(IChargeable chab){
		chab.chargeable();
	}
	
	//ʵ�ִ����ӿ�
	void wearable(IWearable wrab){
		wrab.wearable();
	}
}
