package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class problem23 {
	public static void main(String[] args) {
		ListNode[] lists = new ListNode[3];
		lists[0] = new ListNode(1);
		lists[0].next = new ListNode(4);
		lists[0].next.next = new ListNode(5);
		lists[1] = new ListNode(1);
		lists[1].next = new ListNode(3);
		lists[1].next.next = new ListNode(4);
		lists[2] = new ListNode(2);
		lists[2].next = new ListNode(6);
		ListNode ans = new Solution23().mergeKLists(lists);
		while(ans != null) {
			System.out.print(ans.val + "->");
			ans = ans.next;
		}
	}
}

class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < lists.length ; i++) {
        	ListNode temp = lists[i];
        	while(temp != null) {
        		list.add(temp.val);
        		temp = temp.next;
        	}
        }
        Collections.sort(list);
        
        ListNode ans = new ListNode(0);
        ListNode p = ans;
        for(int t : list) {
        	ListNode temp = new ListNode(t);
        	p.next = temp;
        	p = p.next;
        }
        
        return ans.next;
    }
}