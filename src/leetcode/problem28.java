package leetcode;

public class problem28 {
	public static void main(String[] args) {
		System.out.println(new Solution28().strStr("aaaaa", "bba"));
		System.out.println(new Solution28().strStr("hello", "ll"));
	}
}

class Solution28 {
    public int strStr(String haystack, String needle) {
    	if(needle.length() == 0 || haystack.equals(needle))
    		return 0;
    	if(haystack.length() < needle.length() || haystack.length() == 0 )
    		return -1;
       for(int i = 0 ; i+needle.length() <= haystack.length() ; i++) {
    	   if(haystack.substring(i, i+needle.length()).equals(needle)) {
    		   return i;
    	   }
       }
       return -1;
    }
}