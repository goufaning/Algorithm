package offer;

import java.util.Stack;

/**
 * Created by gfn on 2017/6/1.
 */
public class Problem20 {
	/**
	 * 题目：
	 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
	 * @param root
	 */
	//递归实现
	public void Mirror(TreeNode root) {
		if(root == null) {
			return ;
		}
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		Mirror(root.left);
		Mirror(root.right);
	}
	//非递归实现
	public void Mirror2(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left==null&&root.right==null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		while(root!=null||!stack.isEmpty()){
			while(root!=null){
				TreeNode temp=root.left;
				root.left=root.right;
				root.right=temp;
				stack.push(root);
				root=root.left;
			}
			root=stack.pop();
			root=root.right;
		}
	}
}
