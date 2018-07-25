

public class Demo_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 3 6 8 2
		// 冒泡排序：两两比较，要么把大的数往后排（升序），要么把小的数往后排（降序）
		// 第一次排序	i=0
		// 3和6，3小于6，不换
		// 6和8，6小于8，不换
		// 8和2，8大于2，换 3 6 2 8 比较3
		// 第二次排序	i=1
		// 3和6，3小于6，不换
		// 6和2，6大于2，换 3 2 6 8 比较2
		// 第三次排序	i=2
		// 3和2，3大于2，换 2 3 6 8 比较1
		int[] arr = { 3, 6, 8, 2 };
		for (int i = 0; i < arr.length - 1; i++) {// 排序的次数
			for (int j = 0; j < arr.length - 1 - i; j++) {// 比较次数

			}
		}
	}

}
