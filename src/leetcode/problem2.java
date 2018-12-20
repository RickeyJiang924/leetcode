package leetcode;

import java.util.ArrayList;
import java.util.List;

public class problem2 {
	public static void main(String[] args) {
		
	}
}

class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list = new ArrayList<>();
        while(true) {
        	if(l1 != null && l2 != null) {
        		list.add(l1.val + l2.val);
        		l1 = l1.next;
        		l2 = l2.next;
        	}
        	else if(l1 == null) {
        		while(l2 != null) {
        			list.add(l2.val);
        			l2 = l2.next;
        		}
        		break;
        	}
        	else {
        		while(l1 != null) {
        			list.add(l1.val);
        			l1 = l1.next;
        		}
        		break;
        	}
        }
        ListNode node = new ListNode(list.get(list.size()-1));
        ListNode result = new ListNode(0);
        for(int i = list.size()-2 ; i >= 0 ; i--) {
        	ListNode t = new ListNode(list.get(i));
        	t.next = node;
        	result.next = t;
        	node = result;
        }
        return result;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { 
    	val = x; 
    }
}