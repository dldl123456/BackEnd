package test2_fix;

public class Elec extends Goods implements IChargeable{
	/*
	 * ������
	 */
	
	//��д���๹�췽��
	public Elec(String brand, double money) {
		super(brand, money);
	}

	@Override
	public String work() {
		String result="����"+this.getMoney()+"�����"+this.getBrand()+"���Գ��Ӵ";
		return result;
	}
	
}
