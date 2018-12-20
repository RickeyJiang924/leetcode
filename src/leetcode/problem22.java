package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class problem22 {
	public static void main(String[] args) {
		List<String> ans = new Solution22().generateParenthesis(3);
		for(String s:ans) {
			System.out.println(s);
		}
	}
}

class Solution22 {
    public List<String> generateParenthesis(int n) {
    	List<String> ans = new ArrayList<>();
    	if(n == 0)
    		return ans;
    	if(n == 1) {
    		ans.add("()");
    		return ans;
    	}
        Set<Character> set = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        set.add('(');
        set.add(')');
        
        ans = dfs(ans, stack, set, 0, 2*n, "");
        return ans;
    }
    
    public List<String> dfs(List<String> ans, Stack<Character> stack, Set<Character> set, int step, int n, String temp){
    	if(step < n) {
    		for(char c : set) {
    			if(!stack.isEmpty() && isMatch(stack.peek(), c)) {
    				char t = stack.pop();
    				dfs(ans, stack, set, step+1, n, temp+c);
    				stack.push(t);
    			}
    			else {
    				stack.push(c);
    				dfs(ans, stack, set, step+1, n, temp+c);
    				stack.pop();
    			}
    		}
    	}
    	else if(step == n && stack.isEmpty()) {
    		//System.out.println(temp);
    		ans.add(temp);
    	}
    	
    	return ans;
    }
    
    public boolean isMatch(char c1, char c2) {
    	if(c1 == '(' && c2 == ')') {
    		return true;
    	}
    	else return false;
    }
}
