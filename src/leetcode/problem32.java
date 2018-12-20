package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class problem32 {
	public static void main(String[] args) {
		System.out.println(new Solution32().longestValidParentheses("()(()"));
		System.out.println(new Solution32().longestValidParentheses(")()())"));
		System.out.println(new Solution32().longestValidParentheses("()(())"));
	}
}

class Solution32 {
    public int longestValidParentheses(String s) {
    	if(s.length() <= 1)
    		return 0;
    	List<Map<Integer, Character>> list = new ArrayList<>();
    	for(int i = 0 ; i < s.length() ; i++) {
    		if(s.charAt(i) == '(') {
    			Map<Integer, Character> map = new HashMap<>();
    			map.put(i, '(');
    			list.add(map);
    		}
    		else {
    			if(list.isEmpty()) {
    				Map<Integer, Character> map = new HashMap<>();
        			map.put(i, ')');
        			list.add(map);
    			}
    			else if(list.get(list.size()-1).containsValue('(')) {
    				list.remove(list.size()-1);
    			}
    			else {
    				Map<Integer, Character> map = new HashMap<>();
        			map.put(i, ')');
        			list.add(map);
    			}
    		}
    	}
    	
    	if(list.isEmpty())
    		return s.length();
    	
    	//δƥ�����������ջ�У����Լ���ջ������index�ĲΪ���䳤��
    	int max = 0;
    	int lastIndex = -1;  //��������������
    	for(Map<Integer, Character> m : list) {
    		for(int index : m.keySet()) {
    			max = Math.max(max, index-lastIndex-1);
    			lastIndex = index;
    		}
    	}
    	//���һ������ĳ���,[lastIndex,s.length-1]
    	max = Math.max(max, s.length()-lastIndex-1);
    	return max;
    }
}