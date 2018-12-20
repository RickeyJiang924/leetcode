package leetcode;

public class problem27 {
	public static void main(String[] args) {
		int[] nums = {0,1,2,2,3,0,4,2};
		System.out.println(new Solution27().removeElement(nums, 2));
	}
}

class Solution27 {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0)
        	return 0;
        
        int index = 0;
        int count = 0;
        for(int i = 0 ; i < nums.length ; i++) {
        	if(nums[i] != val) {
        		nums[index++] = nums[i];
        		count++;
        	}
        }
        return count;
    }
}