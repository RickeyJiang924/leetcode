package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class problem39 {
	public static void main(String[] args) {
		int[] candidates = {2,3,5};
		List<List<Integer>> ans = new Solution39().combinationSum(candidates, 8);
		for(List<Integer> list : ans) {
			for(int item : list) {
				System.out.print(item+ " ");
			}
			System.out.println();
		}
	}
}

class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> ans = new ArrayList<>();
    	List<Integer> tmp = new ArrayList<>();
    	Arrays.sort(candidates);
    	dfs(ans, tmp, candidates, target, 0);
    	return ans;
    }
    
    public static void dfs(List<List<Integer>> ans,List<Integer> tmp, int[] candidates, int target, int num) {
    	if(target == 0) {
    		ans.add(tmp);
    		return;
    	}
    	if(target < candidates[0]) 
    		return;
    	for(int i = num ; i < candidates.length && candidates[i] <= target; i++) {
    		List<Integer> t = new ArrayList<>(tmp);
    		t.add(candidates[i]);
    		dfs(ans, t, candidates, target-candidates[i], i);
    	}
    }
}
