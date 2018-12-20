package leetcode;

import java.util.Arrays;

public class problem16 {
	public static void main(String[] args) {
		int[] nums = {0, 2, 1, -3};
		System.out.println(new Solution16().threeSumClosest(nums, 1));
	}
}

class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
    	for(int i = 0 ; i < nums.length-2 ; i++) {
    		int left = i+1, right = nums.length-1;
    		while(left < right) {
    			int sum = nums[i] + nums[left] + nums[right];
    			if(Math.abs(sum-target) < Math.abs(closest-target)) {
    				closest = sum;
    			}
    			if(sum > target) {
    				right--;
    			}
    			else if(sum < target) {
    				left++;
    			}
    			else {
    				return target;
    			}
    		}
    	}
    	
    	return closest;
    }
}