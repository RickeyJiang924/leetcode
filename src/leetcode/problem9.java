package leetcode;

public class problem9 {
	public static void main(String[] args) {
		System.out.println(new Solution9().isPalindrome(-121));
	}
}

class Solution9 {
    public boolean isPalindrome(int x) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb1.append(String.valueOf(x));
        sb2.append(String.valueOf(x));
        sb2.reverse();
        if(sb1.toString().equals(sb2.toString()))
        	return true;
        else
        	return false;
    }
}