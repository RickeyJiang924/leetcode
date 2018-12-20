package leetcode;

import java.util.HashMap;
import java.util.Map;

public class problem13 {
	public static void main(String[] args) {
		System.out.println(new Solution13().romanToInt("MCMXCIV"));
	}
}

class Solution13 {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        
        int temporal_sum = 0;
        for(int i = 0 ; i < s.length() ; i++) {
        	temporal_sum += map.get(s.charAt(i)+"");
        }
        
        int minus_sum = 0;
        for(int i = 0 ; i < s.length()-1 ; i++) {
        	if(map.get(s.charAt(i)+"") < map.get(s.charAt(i+1)+"")) {
        		minus_sum += map.get(s.charAt(i)+"");
        	}
        }
        
    	return temporal_sum - 2*minus_sum;
    }
}