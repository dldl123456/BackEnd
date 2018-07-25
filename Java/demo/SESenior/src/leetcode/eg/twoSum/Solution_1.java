package leetcode.eg.twoSum;

import java.util.HashMap;
import java.util.Map;

public class Solution_1 {
   public int[] twoSum(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 0; i < nums.length; i++) {
	        map.put(nums[i], i);
	    }
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement) && map.get(complement) != i) {
	            return new int[] { i, map.get(complement) };
	        }
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}
   
   public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		Solution_1 t = new Solution_1();
		int arr[]=t.twoSum(nums, target);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
