package leetcode;

public class problem25 {
	public static void main(String[] args) {
		ListNode nodes = new ListNode(1);
		nodes.next = new ListNode(2);
		nodes.next.next = new ListNode(3);
		nodes.next.next.next = new ListNode(4);
		nodes.next.next.next.next = new ListNode(5);
		ListNode ans = new Solution25().reverseKGroup(nodes, 4);
//		ListNode ans = new Solution25().reverse(nodes, 2);
		while (ans != null) {
			System.out.println(ans.val);
			ans = ans.next;
		}

	}
}

class Solution25 {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null || k == 1)
			return head;
		ListNode p = new ListNode(0);
		p.next = head;
		head = p;
		while(head.next != null && check(head.next, k)) {
			head.next = reverse(head.next, k);
			for(int i = 0 ; i < k ; i++) {
				head = head.next;
			}
		}
		return p.next;
	}

	// 返回前k个数的倒置链表的头结点
	public ListNode reverse(ListNode node, int k) {
		// 至少倒置两个数
		int actual = k - 2;
		if (node == null)
			return node;
		ListNode pre = node;
		ListNode mid = pre.next;
		ListNode post = null;
		pre.next = null;
		while (actual-- > 0 && mid.next != null) {
			post = mid.next;
			mid.next = pre;
			pre = mid;
			mid = post;
		}

		ListNode tail = mid.next;

		mid.next = pre;

		ListNode t = mid;
		while (k-- > 1) {
			t = t.next;
		}
		t.next = tail;
		return mid;
	}

	// 检查链表长度是否大于等于k
	public boolean check(ListNode n, int k) {
		ListNode check = n;
		for (int i = 0; i < k; i++) {
			if (check == null) {
				return false;
			}
			check = check.next;
		}
		return true;
	}
}