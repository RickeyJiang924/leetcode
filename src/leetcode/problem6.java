package leetcode;

import java.util.ArrayList;
import java.util.List;

public class problem6 {
	public static void main(String[] args) {
		System.out.println(new Solution6().convert("LEETCODEISHIRING", 3));
		System.out.println(new Solution6().convert("LEETCODEISHIRING", 4));
		System.out.println(new Solution6().convert("A", 1));
	}
}

class Solution6 {
    public String convert(String s, int numRows) {
    	if(numRows == 1)
    		return s;
    	
    	//初始化numRows行的数组
        List<ArrayList<Character>> list = new ArrayList<>();
        for(int i = 0 ; i < numRows ; i++) {
        	ArrayList<Character> c = new ArrayList<>();
        	list.add(c);
        }
        
        //int x_axis = 1;
        for(int i = 0 ; i < s.length() ; i=i+numRows*2-2) {
        	int temp = i;
        	for(int j = 0 ; j < numRows ; j++) {
        		if(temp < s.length())
        			list.get(j).add(s.charAt(temp++));
        	}
        	for(int j = numRows-2 ; j > 0 ; j--) {
        		if(temp < s.length())
        			list.get(j).add(s.charAt(temp++));
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < numRows ; i++) {
        	//ArrayList<Character> ch = new ArrayList<>();
        	for(int j = 0 ; j < list.get(i).size() ; j++) {
        		sb.append(list.get(i).get(j));
        	}
        }
        return sb.toString();
    }
}
