package leetcode;

public class problem26 {
	public static void main(String[] args) {
//		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		int[] nums = {1,1,2};
		System.out.println(new Solution26().removeDuplicates(nums));
		for(int i : nums) {
			System.out.print(i + " ");
		}
	}
}

class Solution26 {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0)
        	return 0;
        if(nums.length == 1)
        	return 1;
        
        int count = 1;
        int index = 0;
        for(int i = 1 ; i < nums.length ; i++) {
        	if(nums[i] != nums[i-1]) {
        		count++;
        		nums[index+1] = nums[i];
        		index ++;
        	}
        }
        return count;
    }
}