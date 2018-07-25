package eg.oop.comparatorDemo_3;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorDemo {
	public static void main(String[] args) {
        Integer[] nums = {1,2,3,4,5,6};
        
        Arrays.sort(nums, new MyComparator());
        
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}

class MyComparator implements Comparator<Integer> {
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}