package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class problem40 {
	public static void main(String[] args) {
		int[] candidates = {10,1,2,7,6,1,5};
		List<List<Integer>> ans = new Solution40().combinationSum2(candidates, 8);
		for(List<Integer> list : ans) {
			for(int item : list) {
				System.out.print(item+ " ");
			}
			System.out.println();
		}
	}
}

class Solution40{
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	List<List<Integer>> ans = new ArrayList<>();
    	List<Integer> tmp = new ArrayList<>();
    	boolean[] is = new boolean[candidates.length];
    	for(boolean flag : is)
    		flag = false;
    	Arrays.sort(candidates);
    	dfs(ans, tmp, candidates, target, 0);
    	HashSet<List<Integer>> set = new HashSet<>(ans);
    	ans = new ArrayList<>(set);
    	return ans;
    }
    
    public static void dfs(List<List<Integer>> ans,List<Integer> tmp, int[] candidates, int target, int index) {
    	if(target == 0) {
    		ans.add(tmp);
    		return;
    	}
    	if(target < candidates[0]) 
    		return;
    	for(int i = index ; i < candidates.length && candidates[i] <= target; i++) {
    		//Éî¿½±´
    		List<Integer> t = new ArrayList<>(tmp);
    		t.add(candidates[i]);
    		dfs(ans, t, candidates, target-candidates[i], i+1);
    	}
    }
}
