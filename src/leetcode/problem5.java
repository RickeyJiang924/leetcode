package leetcode;

public class problem5 {
	public static void main(String[] args) {
		System.out.println(new Solution5().longestPalindrome("a"));
		System.out.println(new Solution5().longestPalindrome("abba"));
		System.out.println(new Solution5().longestPalindrome("babad"));
		System.out.println(new Solution5().longestPalindrome("cbbd"));
		System.out.println(new Solution5().longestPalindrome("aaaa"));
	}
}

class Solution5 {
	public String longestPalindrome(String s) {
		if (s.length() == 0)
			return "";
		if (s.length() == 1)
			return s;

		int max_length = 1;
		String ans = s.substring(0, 1);
		int mid = (s.length() + 1) / 2;
		
		for (int i = mid; i >= 0; i--) {
			for (int j = 1; i - j >= 0 && i + j < s.length(); j++) {
				if (s.charAt(i - j) == s.charAt(i + j)) {
					if (2 * j >= max_length) {
						ans = s.substring(i-j, i+j+1);
						//System.out.println(ans);
						max_length = 2 * j;
					}
				}
				 else
					break;
			}
		}

		for (int i = mid; i < s.length(); i++) {
			for (int j = 1; i - j >= 0 && i + j < s.length(); j++) {
				if (s.charAt(i - j) == s.charAt(i + j)) {
					if (2 * j >= max_length) {
						ans = s.substring(i-j, i+j+1);
						//System.out.println(ans);
						max_length = 2 * j;
					} 
				}
				else
					break;
			}
		}

		for (int p = mid, q = mid - 1; q >= 0; p--, q--) {
			for (int i = 0; q - i >= 0 && p + i < s.length(); i++) {
				if (s.charAt(p + i) == s.charAt(q - i)) {
					//System.out.println((p+i)+ " "+s.charAt(p + i));
					if (p - q + 2 * i >= max_length) {
						ans = s.substring(q - i, p + i + 1);
						//System.out.println(ans);
						max_length = p - q + 2 * i;
					}
				}
				else
					break;
			}
		}

		for (int p = mid + 1, q = mid; p < s.length(); p++, q++) {
			for (int i = 0; q - i >= 0 && p + i < s.length(); i++) {
				if (s.charAt(p + i) == s.charAt(q - i)) {
					if (p - q + 2 * i >= max_length) {
						ans = s.substring(q - i, p + i + 1);
						//System.out.println(ans);
						max_length = p - q + 2 * i;
					}
				}
				else
					break;
			}
		}

		return ans;
	}
}
