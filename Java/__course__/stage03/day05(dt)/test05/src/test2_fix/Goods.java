package test2_fix;

public class Goods {
	/*
	 * ��Ʒ��
	 */
	private String brand;//�̱�
	private double money;//���
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public Goods(String brand,double money) {
		this.brand=brand;
		this.money=money;
	}
}
