package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class problem18 {
	public static void main(String[] args) {
		int[] nums = {-3,-2,-1,0,0,1,2,3};
		//int[] nums = {};
		List<List<Integer>> ans = new Solution18().fourSum(nums, 0);
		for(List<Integer> list : ans)
			System.out.println(list);
	}
}

class Solution18 {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		if(nums.length == 0)
			return ans;
		Set<List<Integer>> set = new HashSet<>();
		Arrays.sort(nums);
		for(int i = 0 ; i < nums.length-3; i++) {
			int first_left = target - nums[i];
			for(int j = i+1 ; j < nums.length-2 ; j++) {
				int second_left = first_left - nums[j];
				int left = j+1;
				int right = nums.length-1;
				while(left < right) {
					int sum = nums[left]+nums[right];
					if(sum == second_left) {
						List<Integer> t = new ArrayList<>();
						t.add(nums[i]);
						t.add(nums[j]);
						t.add(nums[left]);
						t.add(nums[right]);
						set.add(t);
						left++;
						//break;
					}
					else if(sum > second_left) {
						right--;
					}
					else {
						left++;
					}
				}
			}
		}
		
		for(List<Integer> list : set) {
			ans.add(list);
		}
		
		return ans;
	}
}
