package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class problem31 {
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		new Solution31().nextPermutation(nums);
		for(int i : nums)
			System.out.print(i + " ");
	}
}

class Solution31 {
    public void nextPermutation(int[] nums) {
    	if(nums.length <= 1)
    		return;
    	boolean flag = true;
    	//ջ����� �����±�
    	Stack<Integer> stack = new Stack<>();
    	stack.push(nums.length-1);
    	//��β����ǰ�ж��Ƿ����������
        for(int i = nums.length-2 ; i >= 0 ; i--) {
        	if(nums[i] < nums[i+1]) {
        		int temp = 0;
        		while(!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
        			temp = stack.pop();
        		}
        		int t = nums[i];
        		nums[i] = nums[temp];
        		nums[temp] = t;
        		Arrays.sort(nums, i+1, nums.length);
        		flag = false;
        		break;
        	}
        	else{
            	stack.push(i);
        	}
        }
        if(flag) {
        	Arrays.sort(nums);
        }
    }
}