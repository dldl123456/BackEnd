package test2_fix;

public class GoogleGlass extends Elec implements Wearable{
	/*
	 * 眼镜类
	 */
	public GoogleGlass(String brand, double money) {
		super(brand, money);
		
	}
	public String wear() {
		String result="花了"+this.getMoney()+"购买的"+this.getBrand()+"可以穿戴哟";
		return result;
	}
	public static void main(String[] args) {
		GoogleGlass g=new GoogleGlass("邦顿", 905.8);
		System.out.println(g.work());
		System.out.println(g.wear());
	}	
}
