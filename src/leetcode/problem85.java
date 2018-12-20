package leetcode;

import java.util.Stack;

public class problem85 {
	public static void main(String[] args) {
		char[][] matrix = {{'1','0','1','0','0'},
				  {'1','0','1','1','1'},
				  {'1','1','1','1','1'},
				  {'1','0','0','1','0'}};
		char[][] c = {{'1','1'}};
		char[][] a = {};
		char[][] b = {{'0', '1'}, {'1', '0'}};
		System.out.println(new Solution85().maximalRectangle(matrix));
		System.out.println(new Solution85().maximalRectangle(c));
		System.out.println(new Solution85().maximalRectangle(a));
		System.out.println(new Solution85().maximalRectangle(b));
	}
}

class Solution85 {
	public int maximalRectangle(char[][] matrix) {
		int ans = 0;
		
		if(matrix.length == 0)
			return 0;
		
		int length = matrix[0].length;
		int height = matrix.length;
		int[][] m = new int[height][length];
		
		for(int i = 0 ; i < height ; i++) {
			for(int j = 0 ; j < length ; j++) {
				if(i != 0 && m[i-1][j] > 0 && matrix[i][j] == '1') {
					m[i][j] = Integer.parseInt(matrix[i][j]+"") + m[i-1][j];
				}
				else {
					m[i][j] = Integer.parseInt(matrix[i][j]+"");
				}
			}
		}
		
//		for(int i = 0 ; i < height ; i++) {
//			for(int j = 0 ; j < length ; j++) {
//				System.out.print(m[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		for(int i = 0 ; i < height ; i++) {
			ans = Math.max(ans, process(m[i]));
		}
		
		return ans;
	}
	
	public int process(int[] h) {
		int ans = 0;
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0 ; i < h.length ; i++) {
			if(stack.isEmpty() || stack.peek() <= h[i]) {
				stack.push(h[i]);
			}
			else {
				int count = 0;
				while(!stack.isEmpty() && stack.peek() > h[i]) {
					count++;
					ans = Math.max(ans, stack.peek()*count);
					stack.pop();
				}
				while(count-- > 0) {
					stack.push(h[i]);
				}
				stack.push(h[i]);
			}
		}
		int count = 0;
		while(!stack.isEmpty()) {
			count++;
			ans = Math.max(ans, stack.peek()*count);
			stack.pop();
		}
		return ans;
	}
}