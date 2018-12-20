package leetcode;

import leetcode.ListNode;

public class problem19 {
	public static void main(String[] args) {
		ListNode t = new ListNode(1);
		ListNode test = t;
		int i = 1;
		while(i++ < 5) {
			ListNode temp = new ListNode(i);
			t.next = temp;
			t = t.next;
		}
		ListNode ans = new Solution19().removeNthFromEnd(test, 5);
		while(ans != null) {
			System.out.print(ans.val + "->");
			ans = ans.next;
		}
	}
}

class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	if(head.next == null) {
    		return null;
    	}
        int length = 0;
        ListNode len = head;
        while(len != null) {
        	length++;
        	len = len.next;
        }
        
        if(length == n)
        	return head.next;
        
        len = head;
        int index = 0; 
        while(index++ < length-n-1) {
        	len = len.next;
        }
        ListNode temp = len.next.next;
        len.next = temp;
        
        return head;
    }
}