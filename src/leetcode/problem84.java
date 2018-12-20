package leetcode;

import java.util.Stack;

public class problem84 {
	public static void main(String[] args) {
		int[] h = {2,1,5,6,2,3};
		System.out.println(new Solution84().maxArea(h));
	}
}

class Solution84 {
    public int maxArea(int[] height) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0 ; i < height.length ; i++) {
        	if(stack.isEmpty() || stack.peek() <= height[i]) {
        		stack.push(height[i]);
        	} else {
        		int count = 0;
        		while(!stack.isEmpty() && stack.peek() > height[i]) {
        			count++;
        			ans = Math.max(ans, stack.peek()*count);
        			//System.out.println(ans);
        			stack.pop();
        		}
        		while(count-- > 0) {
            		stack.push(height[i]);
            	}
        		stack.push(height[i]);
        	}
        }
        int count = 1;
        while(!stack.isEmpty()) {
        	ans = Math.max(ans, stack.peek()*count);
        	//System.out.println(ans);
        	stack.pop();
        	count++;
        }
        return ans;
    }
}