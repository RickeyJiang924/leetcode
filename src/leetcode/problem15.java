package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class problem15 {
	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		int[] nums1 = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
		System.out.println(new Solution15().threeSum(nums));
		System.out.println(new Solution15().threeSum(nums1));
	}
}

class Solution15 {
	public List<List<Integer>> threeSum(int[] nums) {
		int zero = 0;
		List<Integer> pos = new ArrayList<>();
		List<Integer> neg = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		Set<Integer> set_pos = new HashSet<>();
		Set<Integer> set_neg = new HashSet<>();
		List<List<Integer>> ans = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				zero++;
			} else if (nums[i] > 0) {
				pos.add(nums[i]);
				set_pos.add(nums[i]);
				// set.add(nums[i]);
			} else {
				neg.add(nums[i]);
				set_neg.add(nums[i]);
				// set.add(nums[i]);
			}
		}
		//System.out.println(pos);
		//System.out.println(neg);

		// 3个0
		if (zero >= 3) {
			List<Integer> t = new ArrayList<>();
			t.add(0);
			t.add(0);
			t.add(0);
			ans.add(t);
		}

		// 1个0，正负数组分别找绝对值相等的元素
		if (zero >= 1) {
			for (int i = 0; i < pos.size(); i++) {
				if (!set.contains(pos.get(i))) {
					for (int j = 0; j < neg.size(); j++) {
						if (neg.get(j) * (-1) == pos.get(i)) {
							List<Integer> t = new ArrayList<>();
							t.add(neg.get(j));
							t.add(0);
							t.add(pos.get(i));
							ans.add(t);
							set.add(pos.get(i));
							break;
						}
					}
				}
			}
		}

		// 1正2负
		for (int i = 0; i < neg.size() - 1; i++) {
			for (int j = i + 1; j < neg.size(); j++) {
				if (set_pos.contains(0 - neg.get(i) - neg.get(j))) {
					List<Integer> t = new ArrayList<>();
					t.add(Math.min(neg.get(i), neg.get(j)));
					t.add(Math.max(neg.get(i), neg.get(j)));
					t.add(0 - neg.get(i) - neg.get(j));
					ans.add(t);
				}
			}
		}

		// 1负2正
		for (int i = 0; i < pos.size() - 1; i++) {
			for (int j = i + 1; j < pos.size(); j++) {
				if (set_neg.contains(0 - pos.get(i) - pos.get(j))) {
					List<Integer> t = new ArrayList<>();
					t.add(0 - pos.get(i) - pos.get(j));
					t.add(Math.min(pos.get(i), pos.get(j)));
					t.add(Math.max(pos.get(i), pos.get(j)));
					ans.add(t);
				}
			}
		}

		Set<List<Integer>> res = new HashSet<>();
		for(List<Integer> arr : ans) {
			res.add(arr);
		}
		ans.clear();
		for(List<Integer> arr : res) {
			ans.add(arr);
		}
		return ans;
	}
}