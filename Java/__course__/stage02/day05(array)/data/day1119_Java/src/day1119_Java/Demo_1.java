package day1119_Java;

import java.util.Scanner;

public class Demo_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int index = -1;// 下标
		int num = 0;// 修改数
		boolean flag = true;// 循环开关
		// 数据源
		int[] nums = new int[4];// 4表示这个数组长度为4，这样写法的数组里面都是默认值
		Scanner input = new Scanner(System.in);
		// 查找单个元素
		// System.out.println("请输入你要查哪个下标的元素：");
		// index = input.nextInt();// 用户给下标
		// System.out.println(nums[index]);// 显示下标所对应的元素
		// 访问/获取数组中某个下标在数组中的元素：数组名字[下标值]（nums[1]）
		// 对某一个下标的元素赋值
		// System.out.println("请输入你的值：");
		// 改数据/添加数据，如果是已有有效数据了，那就是改
		// nums[3]=input.nextInt();//数组的下标，数组下标最大值是数组长度-1（数组名.length-1）
		// 给数组每个元素赋值
		// for (int i = 0; i < nums.length; i++) {
		// System.out.println("请个第" + (i + 1) + "赋值：");
		// nums[i] = input.nextInt();
		// }
		// 根据用户需求来给修改数组中某一个元素（哪个元素，修改成什么）循环 条件
		// 1.用户输入哪个元素去查下标然后修改；2.用户输入下标修改
		// 方法1
		while (flag) {//如果你要修改后结束/继续修改，加个判断是否继续
			System.out.println("请输入你要修改的数：");
			num = input.nextInt();
			// 用户输入的数是否在数组里存在，如果不存在那就要告诉用户，如果存在那就要记录这个元素的下标
			for (int i = 0; i < nums.length; i++) {
				if (num == nums[i]) {
					index = i;
					break;
				}
			}
			// 根据index中的值判断是否存在
			if (index == -1) {
				System.out.println("没有该数！");
				// flag = false;
				continue;
			}
			System.out.println("输入你要修改后的数：");
			nums[index] = input.nextInt();
			// 方法2
			// System.out.println("请输入要修改的下标：");
			// index = input.nextInt();
			// System.out.println("输入你要修改后的数：");
			// nums[index] = input.nextInt();
			// 遍历数组的元素
			for (int i = 0; i < nums.length; i++) {
				// 怎么遍历每一个元素？
				// System.out.println(nums[i]);
				System.out.print(nums[i] + "空格");
			}
			System.out.println();
		}
	}
}
