package test2_fix;

public class GoogleGlass extends Elec implements Wearable{
	/*
	 * �۾���
	 */
	public GoogleGlass(String brand, double money) {
		super(brand, money);
		
	}
	public String wear() {
		String result="����"+this.getMoney()+"�����"+this.getBrand()+"���Դ���Ӵ";
		return result;
	}
	public static void main(String[] args) {
		GoogleGlass g=new GoogleGlass("���", 905.8);
		System.out.println(g.work());
		System.out.println(g.wear());
	}	
}
