package leetcode;

public class problem14 {
	public static void main(String[] args) {
		String[] strs = { "flower", "flow", "flight" };
		String[] strs1 = {};
		System.out.println(new Solution14().longestCommonPrefix(strs));
		System.out.println(new Solution14().longestCommonPrefix(strs1));
	}
}

class Solution14 {
	public String longestCommonPrefix(String[] strs) {
		if(strs.length == 0)
			return "";
		StringBuilder sb = new StringBuilder("");
		int turn = 0;
		boolean flag = true;
		char temp;

		while (true) {
			if (turn >= strs[0].length()) {
				flag = false;
				break;
			}
			else {
				temp = strs[0].charAt(turn);
			}
			for (int i = 1; i < strs.length; i++) {
				if (turn >= strs[i].length() || temp != strs[i].charAt(turn)) {
					flag = false;
					break;
				}
			}
			if (!flag) {
				break;
			}
			sb.append(temp+"");
			turn++;
		}
		return sb.toString();
	}
}