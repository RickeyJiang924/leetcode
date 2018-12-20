package leetcode;

//class ListNode {
//	int val;
//	ListNode next;
//
//	ListNode(int x) {
//		val = x;
//	}
//}

public class problem21 {
	public static void main(String[] args) {
//		ListNode l1 = new ListNode(1);
//		l1.next = new ListNode(2);
//		l1.next.next = new ListNode(4);
//		ListNode l2 = new ListNode(1);
//		l2.next = new ListNode(3);
//		l2.next.next = new ListNode(4);
//		ListNode l = new Solution21().mergeTwoLists(l1, l2);
//		while(l != null) {
//			System.out.print(l.val + "->");
//			l = l.next;
//		}
	}
}

class Solution21 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		ListNode temp = new ListNode(Math.min(l1.val, l2.val));
		ListNode ans = temp;
		if(l1.val <= l2.val)
			l1 = l1.next;
		else
			l2 = l2.next;
		while(l1 != null && l2 != null) {
			if(l1.val <= l2.val) {
				temp.next = new ListNode(l1.val);
				temp = temp.next;
				l1 = l1.next;
			}
			else {
				temp.next = new ListNode(l2.val);
				temp = temp.next;
				l2 = l2.next;
			}
		}
		
		if(l1 != null) {
			temp.next = l1;
		}
		if(l2 != null) {
			temp.next = l2;
		}
		
		return ans;
	}
}