package test2_fix;

public class Elec extends Goods implements IChargeable{
	/*
	 * 电器类
	 */
	
	//重写父类构造方法
	public Elec(String brand, double money) {
		super(brand, money);
	}

	@Override
	public String work() {
		String result="花了"+this.getMoney()+"购买的"+this.getBrand()+"可以充电哟";
		return result;
	}
	
}
