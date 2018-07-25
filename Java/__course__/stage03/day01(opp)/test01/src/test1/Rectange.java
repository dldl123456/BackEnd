/*
 *  设计一个Rectange的类表示矩形
 *  1.具有2个属性width和weight,他们分别表示高和宽，默认值都为1
 *  2.创建默认的矩形的无参构造方法
 *  3.创建一个getArea()的方法，返回这个矩形的面积
 *  4.创建一个getPerimeter()的方法返回矩形的周长
 *  
 */

package test1;

public class Rectange {
	public int width;  //宽
	public int height;  //高
	
	//在构造方法中进行初始化
	public Rectange(){
		width = 1;  
		height = 1;  
	}
	
	//矩形的面积
	public int getArea(int width, int height){
		return width * height;
	}
	
	//矩形的周长
	public int getPerimeter(int width, int height){
		return (width + height) * 2;
	}
	
	//主方法（程序入口）
	public static void main(String[] args) {
		Rectange rtg = new Rectange();  //new一个矩形对象
		
		int area = 0;  //用来保存矩形面积
		int perimeter = 0;  //用来保存矩形的周长
		
		area = rtg.getArea(rtg.width, rtg.height);  //调用矩形的面积的方法
		perimeter = rtg.getPerimeter(rtg.width, rtg.height);  //调用矩形的周长的方法
		
		System.out.println("该矩形的面积是：" + area);
		System.out.println("该矩形的周长是：" + perimeter);
	}
}
