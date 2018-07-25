package test2_fix;

public class Clothes extends Goods implements Wearable{
	/*
	 * 服装类
	 */
	
	//重写父类构造方法
	public Clothes(String brand, double money) {
		super(brand, money);
	}

	@Override
	public String wear() {
		String result="花了"+this.getMoney()+"购买的"+this.getBrand()+"可以穿戴哟";
		return result;
	}
	
}
