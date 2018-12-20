package leetcode;

public class problem29 {
	public static void main(String[] args) {
		System.out.println(new Solution29().divide(-2147483648, -1));
	}
}
class Solution29 {
    public int divide(int dividend, int divisor) {
    	if(dividend == Integer.MIN_VALUE && divisor == -1)
    		return Integer.MAX_VALUE;
    	try {
    		return dividend/divisor;
    	}catch(Exception e) {
    		return Integer.MAX_VALUE;
    	}
    }
}