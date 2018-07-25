package test2_fix;

public class Goods {
	/*
	 * 商品类
	 */
	private String brand;//商标
	private double money;//标价
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
