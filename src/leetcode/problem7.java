package leetcode;

public class problem7 {
	public static void main(String[] args) {
		System.out.println(new Solution7().reverse(-123));
	}
}

class Solution7 {
    public int reverse(int x) {
        int flag;
        if(x > 0) {
        	flag = 1;
        }
        else if(x < 0) {
        	flag = -1;
        }
        else {
        	return 0;
        }
        
        x = Math.abs(x);
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        sb.reverse();
        try {
        	int ans = Integer.parseInt(sb.toString());
        	return ans*flag;
        }catch(Exception e) {
        	return 0;
        }
    }
}
