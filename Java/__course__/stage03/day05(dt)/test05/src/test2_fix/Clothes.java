package test2_fix;

public class Clothes extends Goods implements Wearable{
	/*
	 * ��װ��
	 */
	
	//��д���๹�췽��
	public Clothes(String brand, double money) {
		super(brand, money);
	}

	@Override
	public String wear() {
		String result="����"+this.getMoney()+"�����"+this.getBrand()+"���Դ���Ӵ";
		return result;
	}
	
}
