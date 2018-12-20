package leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class problem20 {
	public static void main(String[] args) {
		System.out.println(new Solution20().isValid("){"));
	}
}

class Solution20 {
    public boolean isValid(String s) {
        if(s.length() == 0)
        	return true;
        if(s.length() %2 == 1)
        	return false;
        
        Stack<Character> stack = new Stack<>();
        Set<Character> set = new HashSet<>();
        set.add('{');
        set.add('[');
        set.add('(');
        if(!set.contains(s.charAt(0)))
        	return false;
        
        for(int i = 0 ; i < s.length() ; i++) {
        	if(set.contains(s.charAt(i))) {
        		stack.push(s.charAt(i));
        	}
        	else {
        		if(isMatch(stack.peek(), s.charAt(i))) {
        			stack.pop();
        		}
        		else
        			return false;
        	}
        }
        
        if(stack.isEmpty())
        	return true;
        else
        	return false;
    }
    
    public boolean isMatch(char c1, char c2) {
    	if(c1 == '{' && c2 == '}') {
    		return true;
    	}
    	else if(c1 == '[' && c2 == ']') {
    		return true;
    	}
    	else if(c1 == '(' && c2 == ')') {
    		return true;
    	}
    	else
    		return false;
    }
}
