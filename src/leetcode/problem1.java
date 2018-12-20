package leetcode;

public class problem1 {
	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		System.out.println(new Solution1().twoSum(nums, 9)[0]);
	}
}

class Solution1 {
    public int[] twoSum(int[] nums, int target) {
    	int[] result = new int[2];
        for(int i = 0 ; i < nums.length-1 ; i++) {
        	for(int j = i+1 ; j < nums.length ; j++) {
        		if(nums[i]+nums[j] == target) {
        			result[0] = i;
        			result[1] = j;
        		}
        	}
        }
    	return result;
    }
}