package leetcode;

public class problem38 {
	public static void main(String[] args) {
		for(int i = 1 ; i < 10 ; i ++) {
			System.out.println(new Solution38().countAndSay(i));
		}
	}
}

class Solution38 {
	public String countAndSay(int n) {
		if (n == 1)
			return "1";
		StringBuilder sb = new StringBuilder();
		int index = 0;
		sb.append("1");
		while (n-- > 1) {
			StringBuilder t = new StringBuilder();
			char c=' ';
			int count = 0;
			while (index < sb.length()) {
				c = sb.charAt(index);
				for (; index < sb.length(); index++) {
					if (sb.charAt(index) == c) {
						count++;
					} else {
						t.append(String.valueOf(count) + String.valueOf(c));
						c = sb.charAt(index);
						count = 0;
						break;
					}
				}
			}
			if(count == 0) count++;
			t.append(String.valueOf(count) + String.valueOf(c));
			//System.out.println(sb.toString());
			index = 0;
			sb = t;
		}

		return sb.toString();
	}
}
