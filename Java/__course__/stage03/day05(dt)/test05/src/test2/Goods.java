/*
 *  接口的引用变量可以引用其实现类的对象
 *  接口实现了多态
 */

package test2;

//商品类（父类）
public class Goods {
	private String name;  //商品名字
	
	//构造方法
	public Goods(String name){
		this.name = name;
	}
	
	//获取商品名
	public String getName(){
		return name;
	}
	
	//实现充电接口
	void chargeable(IChargeable chab){
		chab.chargeable();
	}
	
	//实现穿戴接口
	void wearable(IWearable wrab){
		wrab.wearable();
	}
}
