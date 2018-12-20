package leetcode;

public class problem42 {
	public static void main(String[] args) {
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(new Solution42().trap(height));
	}
}

class Solution42 {
	public int trap(int[] height) {
		int start = 0;
		for(int i = 0 ; i < height.length ; i++) {
			if(height[i] != 0) {
				start = i;
				break;
			}
		}
		int ans = 0;
		int h = height[start];
		int area = height[start];
		
		for(int i = start+1 ; i < height.length ; i++) {
			if(height[i] < height[i-1]) {
				area += height[i];
			}
			else {
				//ans += 
				h = height[i];
				start = i;
				break;
			}
		}
		
		for(int i = start+1 ; i < height.length ; i++) {
			if(height[i] < height[i-1]) {
				area += height[i];
			}
			else {
				h = height[i];
				start = i;
			}
		}
		
		
		return ans;
	}
}