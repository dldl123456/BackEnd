/*
 *  淘宝上的商品(Goods)种类繁多，有电器类(Elec)，有服装类(Clothing)。
 *  电器类商品都可以充电(IChargeable)，
 *  服装类商品都可以穿戴(IWearable)。
 *  Google眼镜(GoogleGlass)属于电器类，却既可以充电，也可以穿戴。
 *  请根据题目描述创建相应的类、接口，正确关联它们的关系（继承 or 实现）
 */

package test2;

//测试类(程序入口)
public class GoodsDemo {
	public static void main(String[] args) {
		Goods goods = new Goods("GoogleGlass");  //商品对象实例化
		Elec eltc = new Elec("GoogleGlass");  //电器类对象实例化
		Clothing clothing = new Clothing("GoogleGlass");  //穿戴类对象实例化
		
		goods.chargeable(eltc);  //电器类实例化的对象调用充电接口实现充电
		goods.wearable(clothing);  //穿戴类实例化的对象调用穿戴接口实现穿戴
	}
}
