package leetcode;

import java.util.HashSet;

public class problem41 {
	public static void main(String[] args) {
		int[] nums = {1,2,0};
		System.out.println(new Solution41().firstMissingPositive(nums));
	}
}

class Solution41 {
	public int firstMissingPositive(int[] nums) {
		if(nums.length == 0)
			return 1;
		HashSet<Integer> set = new HashSet<Integer>();
		int max = nums[0];
		for(int i = 0 ; i < nums.length ; i++) {
			set.add(nums[i]);
			if(max < nums[i])
				max= nums[i];
		}
		for(int i = 1 ; i <= max ; i++) {
			if(!set.contains(i))
				return i;
		}
		
		return max+1;
	}
}