package offer;

/**
 * Created by gfn on 2017/6/1.
 */
public class Problem18 {
	/**
	 * 题目：
	 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
	 * @param list1
	 * @param list2
	 * @return
	 */
	//递归版本
	public static ListNode Merge(ListNode list1,ListNode list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		if (list1.val <= list2.val) {
			list1.next = Merge(list1.next,list2);
			return list1;
		} else {
			list2.next = Merge(list1,list2.next);
			return list2;
		}
	}

	//非递归版本
	public static ListNode Merge2(ListNode list1,ListNode list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		ListNode mergeHead = null;
		ListNode current = null;
		while (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
				if (mergeHead == null) {
					mergeHead = current = list1;
				} else {
					current.next = list1;
					current = current.next;
				}
				list1 = list1.next;
			} else {
				if (mergeHead == null) {
					mergeHead = current = list2;
				} else {
					current.next = list2;
					current = current.next;
				}
				list2 = list2.next;
			}
		}
		if (list1 == null) {
			current.next = list2;
		} else {
			current.next = list1;
		}
		return mergeHead;
	}





	public static void main(String[] args) {
		ListNode head1=new ListNode(1);
		ListNode second1=new ListNode(3);
		ListNode head2=new ListNode(2);
		ListNode second2=new ListNode(2);
		ListNode third2=new ListNode(2);
		head1.next=second1;
		head2.next=second2;
		second2.next=third2;
		Problem18 test=new Problem18();
		ListNode result=test.Merge2(head1, head2);
		System.out.println(result.next.next.val);
	}
}
