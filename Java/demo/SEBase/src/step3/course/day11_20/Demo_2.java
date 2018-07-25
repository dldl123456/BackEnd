package step3.course.day11_20;

public class Demo_2 {
	public static void main(String[] args) {
		int[] arr1 = new int[4];  //new后面的[]里数字不写
		int[] arr2 = {1,2,4,8};  //声明数组并给每个元素赋初始值
		
		System.out.println(arr1 + "" + arr2);
		
		int[] arr3 = new int[]{1,2,4,8};  //(不常用)由于后面括号里已经有详细的元素个数，所以不用写长度
		int[] arr4 = null;  //声明数组，没有开辟空间
		
		arr4 = arr3;
		
		for(int i=0; i<arr4.length; i++){
			System.out.print(arr4[i]);
		}
		
		
	}
}
