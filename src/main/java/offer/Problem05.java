package offer;

import java.util.ArrayList;
import java.util.Stack;

/**题目：
 * 输入一个链表，从尾到头打印链表每个节点的值。
 *
 *
 * Created by gfn on 2017/5/26.
 */
public class Problem05 {
	ArrayList<Integer> arrayList=new ArrayList<Integer>();
	//递归实现
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		if(listNode!=null){
			this.printListFromTailToHead(listNode.next);
			arrayList.add(listNode.val);
		}
		return arrayList;
	}

	//非递归实现
	public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
		Stack<Integer> stack = new Stack<>();
		while (listNode!=null) {
			stack.push(listNode.val);
			listNode = listNode.next;
		}
		while (!stack.isEmpty()) {
			arrayList.add(stack.pop());
		}
		return arrayList;
	}
}
