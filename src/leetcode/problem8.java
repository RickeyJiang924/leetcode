package leetcode;

public class problem8 {
	public static void main(String[] args) {
		System.out.println(new Solution8().myAtoi("4193 with words"));
		System.out.println(new Solution8().myAtoi("   -42"));
		System.out.println(new Solution8().myAtoi(""));
		System.out.println(new Solution8().myAtoi("3.14159"));
	}
}

class Solution8 {
	public int myAtoi(String str) {
		if(str.length() == 0)
			return 0;
		for(int i = 0 ; i < str.length() ; i++) {
			if(str.charAt(i) != ' ') {
				str = str.substring(i);
				break;
			}
		}
		if (str.charAt(0) == '+') {
			return process(str.substring(1), 1);
		} else if (str.charAt(0) == '-') {
			return (-1)*process(str.substring(1), -1);
		} else if(Character.isDigit(str.charAt(0))) {
			return process(str, 1);
		} else {
			return 0;
		}
	}
	
	public int process(String s,int flag) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if(Character.isDigit(s.charAt(i))) {
				sb.append(s.charAt(i));
			}
			else {
				break;
			}
		}
		if(sb.length() == 0) {
			return 0;
		}
		try {
			int ans = Integer.parseInt(sb.toString());
			return ans;
		}catch(Exception e) {
			if(flag == 1) {
				return Integer.MAX_VALUE;
			}
			else {
				return Integer.MIN_VALUE;
			}
		}
	}
}
