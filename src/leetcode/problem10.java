package leetcode;

import java.util.regex.Pattern;

public class problem10 {
	public static void main(String[] args) {
		System.out.println(new Solution10().isMatch("aa", "a*"));
	}
}

class Solution10 {
    public boolean isMatch(String s, String p) {
//        if(s.length() == 0 || p.length() == 0)
//        	return true;
//        
//        if(p.equals(".*"))
//        	return true;
//        
//        int i = 0;
//        int j = 0;
//        while(i < s.length()) {
//        	if()
//        }
    	return Pattern.matches(p, s);
    }
}
