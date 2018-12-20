package leetcode;

public class problem24 {
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		ListNode ans = new Solution24().swapPairs(node);
		print(ans);
	}
	public static void print(ListNode ans) {
		while(ans != null) {
			System.out.println(ans.val);
			ans = ans.next;
		}
	}
}

class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
        	return head;
        }
        //增加头结点，方便运算
        ListNode p = new ListNode(0);
        p.next = head;
        head = p;
        while(head.next != null && head.next.next != null) {
        	ListNode t1 = head.next;
        	ListNode t2 = head.next.next;
        	head.next = t2;
        	t1.next = t2.next;
        	t2.next = t1;
        	head = t1;
        }
        return p.next;
    }
}