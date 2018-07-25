/*
 *  策略模式
 */

package video.note.strategyDemo;

public class StrategyDemo {
	public static void main(String[] args) {
		int[] array = {1,5,9,45,77,32,21};
		
		ISort bubbleSort = new BubbleSort();
		ISort selectSort = new SelectSort();
		
		Context context1 = new Context(bubbleSort);
		context1.sort(array);
		context1.printArray(array);
		
		System.out.println("\n");
		
		Context context2 = new Context(selectSort);
		context2.sort(array);
		context2.printArray(array);
	}
}

//策略的持有者
class Context{
	private ISort iSort = null;
	
	//构造方法
	//多态
	public Context(ISort iSort){
		this.iSort = iSort;
	}
	
	public void sort(int[] array){
		//交给具体接收到的策略类对象来帮忙排序
		iSort.sort(array);
	}
	
	//打印数组中的内容
	public void  printArray(int[] array){
		for(int i=0; i<array.length; i++){
			if(i<array.length-1){
				System.out.print(array[i] + ",");
			}else{
				System.out.print(array[i]);
			}
		}
	}
}

//对数组排序的算法接口
interface ISort{
	//声明对数组排序的方法
	public void sort(int[] array);
}

//调用数组排序接口
//封装了冒泡排序法
class BubbleSort implements ISort{
	//重写（实现）接口中声明的排序方法
	public void sort(int[] array){
		System.out.println("冒泡排序法");
		for(int i=0; i<array.length-1; i++){
			for(int j=0; j<array.length-1-i; j++){
				if(array[j]>array[j+1]){
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}
}

//调用数组排序接口
//封装了选择排序法
class SelectSort implements ISort{
	//重写（实现）接口中声明的排序方法
	public void sort(int[] array){
		System.out.println("选择排序法");
		int min = 0;
		for(int i=0; i<array.length; i++){
			min = i;
			for(int j=i+1; j<array.length; j++){
				if(array[min]>array[j]){
					min = j;
				}
			}
			if(i != min){
				int temp = array[i];
				array[i] = array[min];
				array[min] = temp;
			}
		}
	}
}