package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class problem30 {
	public static void main(String[] args) {
		String s = "wordgoodgoodgoodbestword";
		String[] words = {"word","good","best","word"};
//		String s = "barfoothefoobarman";
//		String[] words = {"foo","bar"};
		List<Integer> ans = new Solution30().findSubstring(s, words);
		for(int a : ans) {
			System.out.print(a + " ");
		}
	}
}

class Solution30 {
    public List<Integer> findSubstring(String s, String[] words) {
    	List<Integer> ans = new ArrayList<>();
    	if(s.length() == 0 || words.length == 0) {
    		return ans;
    	}
    	int w_length = words[0].length()*words.length;
    	if(w_length > s.length())
    		return ans;
    	
        for(int i = 0 ; i <= s.length()-w_length ; i++) {
        	if(isSub(s.substring(i, i+words[0].length()*words.length), words)) {
        		ans.add(i);
        	}
        }
        
        return ans;
    }
    
    public boolean isSub(String s, String[] words) {
    	//初始化键值对，值为词汇出现次数
        Map<String, Integer> map = new HashMap<>();
        for(String w : words) {
        	if(map.containsKey(w)) {
        		int n = map.get(w)+1;
        		map.put(w, n);
        	}
        	else {
        		map.put(w, 1);
        	}
        }
        
        for(int i = 0 ; i < words[0].length()*words.length ; i=i+words[0].length()) {
        	String t = s.substring(i, i+words[0].length());
        	//System.out.println(t);
        	if(map.containsKey(t)) {
        		int n = map.get(t)-1;
        		map.put(t, n);
        	}
        	else {
        		return false;
        	}
        }
        //检查键值对中的值是否都为0
        for(String w : words) {
        	if(map.get(w) != 0)
        		return false;
        }
        return true;
    }
}