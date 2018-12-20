package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class problem17 {
	public static void main(String[] args) {
		System.out.println(new Solution17().letterCombinations("23"));
	}
}

class Solution17 {
    public List<String> letterCombinations(String digits) {
    	List<String> ans = new ArrayList<>();
    	if(digits.length() == 0) {
    		return ans;
    	}
        Map<Integer, String> map = new HashMap<>();
    	map.put(2, "abc");
    	map.put(3, "def");
    	map.put(4, "ghi");
    	map.put(5, "jkl");
    	map.put(6, "mno");
    	map.put(7, "pqrs");
    	map.put(8, "tuv");
    	map.put(9, "wxyz");
    	
    	ans = dfs(ans, map, digits, 0, "");
    			
    	return ans;
    }
    
    public List<String> dfs(List<String> ans, Map<Integer, String> map, String digits, int step, String res) {
    	if(step < digits.length()) {
    		for(int i = 0 ; i < map.get(Integer.parseInt(digits.charAt(step)+"")).length() ; i++) {
    			ans = dfs(ans, map, digits, step+1, res+map.get(Integer.parseInt(digits.charAt(step)+"")).charAt(i));
    		}
    	}
    	else {
    		ans.add(res);
    	}
    	
    	return ans;
    }
}
