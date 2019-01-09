package leetcode;

public class problem33 {
	public static void main(String[] args) {
		int[] nums = {4,5,6,7,0,1,2};
		System.out.println(new Solution33().search(nums, 5));
	}
}

class Solution33 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        
        if(nums.length == 0)
        	return -1;
        
        if(nums.length == 1)
        	return nums[0] == target ? 0 : -1;
        
        if(nums[0] == target || nums[nums.length-1] == target) {
        	return nums[0] == target ? 0 : nums.length-1;
        }
        
        while(left <= right) {
        	int mid = (left+right)/2;
        	System.out.println(nums[left]+" " + nums[right] + " " + nums[mid]);
        	if(nums[mid] == target || nums[mid+1] == target) {
        		return nums[mid] == target ? mid : mid+1;
        	}
        	if(right-left <= 1) break;
        	if(nums[mid] < nums[mid-1]) {
        		right = mid;
        	}
        	else {
        		left = mid;
        	}
        }
        return -1;
    }
}
