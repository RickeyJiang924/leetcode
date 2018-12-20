package leetcode;

import java.util.Arrays;

public class problem53 {
	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(new Solution53().maxSubArray(nums));
	}
}

class Solution53 {
    public int maxSubArray(int[] nums) {
    	int[] dp = Arrays.copyOf(nums, nums.length);
    	int max = Integer.MIN_VALUE;
        for(int i = 1 ; i < nums.length ; i++) {
        	dp[i] = Math.max(dp[i-1]+dp[i], dp[i]);
        }
        for(int ans : dp) {
        	if(ans > max)
        		max = ans;
        }
        return max;
    }
}
