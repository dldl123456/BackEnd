/*
 *  �Ա��ϵ���Ʒ(Goods)���෱�࣬�е�����(Elec)���з�װ��(Clothing)��
 *  ��������Ʒ�����Գ��(IChargeable)��
 *  ��װ����Ʒ�����Դ���(IWearable)��
 *  Google�۾�(GoogleGlass)���ڵ����࣬ȴ�ȿ��Գ�磬Ҳ���Դ�����
 *  �������Ŀ����������Ӧ���ࡢ�ӿڣ���ȷ�������ǵĹ�ϵ���̳� or ʵ�֣�
 */

package test2;

//������(�������)
public class GoodsDemo {
	public static void main(String[] args) {
		Goods goods = new Goods("GoogleGlass");  //��Ʒ����ʵ����
		Elec eltc = new Elec("GoogleGlass");  //���������ʵ����
		Clothing clothing = new Clothing("GoogleGlass");  //���������ʵ����
		
		goods.chargeable(eltc);  //������ʵ�����Ķ�����ó��ӿ�ʵ�ֳ��
		goods.wearable(clothing);  //������ʵ�����Ķ�����ô����ӿ�ʵ�ִ���
	}
}
