package leetcode;

public class problem11 {
	public static void main(String[] args) {
		int[] height = {2,3,4,5,18,17,6};
		System.out.println(new Solution11().maxArea(height));
	}
}

class Solution11 {
	public int maxArea(int[] height) {
		if(height.length == 0 || height.length == 1)
			return 0;
		
		int ans = 0;
		int left = 0;
		int right = height.length-1;
		while(left != right) {
			ans = Math.max(ans, (right-left)*Math.min(height[right], height[left]));
			//System.out.println(ans + " " + left + " " + right);
			if(height[left] < height[right])
				left++;
			else
				right--;
		}
		return ans;
	}
}
