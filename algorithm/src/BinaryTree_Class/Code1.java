package BinaryTree_Class;

import java.util.LinkedList;

import javax.security.auth.x500.X500Principal;

import publicMethod.Node;

public class Code1 {
	public static int preValue = Integer.MIN_VALUE;
	
	public static void main(String args[]) {
		Node head = new Node(5);
		head.left = new Node(3);
		head.right = new Node(7);
		head.left.left = new Node(2);
		head.left.right = new Node(4);
		head.left.left.left = new Node(1);
		head.right.left = new Node(6);
		head.right.right = new Node(8);
		System.out.println(checkBST(head));
	}
	
	//中序判断，是否是搜索二叉树
	public static boolean checkBST(Node head) {
		if(head == null) {
			return true;
		}
		
		boolean isLeftBst = checkBST(head.left);
		if(!isLeftBst) {
			return false;
			
		}
		
		if(head.value <= preValue) {
			return false;
		}else {
			preValue = head.value;
		}
		
		
		
		return checkBST(head.right);
	}
	
	
	//所有宽度优先遍历判断是否是完全二叉树
	public static boolean isCBT(Node head) {
		if(head == null) {
			return true;
		}
		
		LinkedList<Node> queue = new LinkedList<>();
		
		//是否遇过左右两个孩子不双全的节点
		boolean leaf = false;
		Node l = null;
		Node r = null;
		queue.add(head);
		while (!queue.isEmpty()) {
			head = queue.poll();
			l=head.left;
			r=head.right;
			if((leaf && (l != null || r != null)) || (l == null && r != null)) {
				return false;
			}
			
			if(l != null) {
				queue.add(l);
			}
			
			if (r != null) {
				queue.add(r);
			}
			
			if(l==null||r==null) {
				return true;
			}
		}
		return true;
	}
	
	//返回该节点是否是平衡二叉树
	public static boolean isBalanced(Node head) {
		return process(head).isBalanced;
	}
	
	//判断是否是平衡二叉树
	public  static class ReturnType{
		//是否是平衡二叉树
		public boolean isBalanced;
		//高度
		public int height;
		
		public ReturnType(boolean isBalanced,int height) {
			this.isBalanced = isBalanced;
			this.height = height;
		}
	}
	
	//判断是否是平衡二叉树的方法
	private static ReturnType process(Node head) {
		if (head == null) {
			return new ReturnType(true, 0);
		}
		ReturnType leftDataReturn = process(head.left);
		ReturnType rightDataReturn = process(head.right);
		int height = Math.max(leftDataReturn.height, rightDataReturn.height)+1;
		boolean isbalanced = leftDataReturn.isBalanced && rightDataReturn.isBalanced &&
							Math.abs(leftDataReturn.height - rightDataReturn.height) < 2;
		
		return new ReturnType(isbalanced, height);
	}

	//搜索二叉树
	public static class ReturnData {
		public boolean isBST;
		public int min;
		public int max;
		
		public ReturnData(boolean isBST,int min,int max) {
			this.isBST = isBST;
			this.min = min;
			this.max = max;
		}
	}
	//判断是否是搜索二叉树
	public static ReturnData process1(Node xNode) {
		if(xNode == null) {
			return null;
		}
		
		ReturnData leftData = process1(xNode.left);
		ReturnData rightData = process1(xNode.right);
		
		int min = xNode.value;
		int max = xNode.value;
		
		if(leftData != null) {
			min = Math.min(min, leftData.min);
			max = Math.min(max, leftData.max);
		}
		if(rightData != null) {
			min = Math.min(min, rightData.min);
			max = Math.min(max, rightData.max);
		}
		
		
		boolean isBST = true;
		if(leftData != null && (!leftData.isBST || leftData.max >= xNode.value)) {
			isBST = false;
		}
		if(rightData != null && (!rightData.isBST || rightData.min <= xNode.value)) {
			isBST = false;
		}
		
		return new ReturnData(isBST, min, max);
	}

	//查找二叉树的某两个节点的最初公共祖先
	//两种情况:
	//1) 以两个节点中的一个为最初公共祖先时
	//1) 不以两个节点中的一个为最初公共祖先时
	public static Node lowestAncestor(Node head,Node o1,Node o2) {
		//如果再递归的过程中，碰到当前节点等于两个需要返回的某一个节点，则直接返回head(因为这个情况一)
		if(head == null || head == o1 || head ==o2) {
			return head;
		}
		
		Node left = lowestAncestor(head.left, o1, o2);
		Node right = lowestAncestor(head.right, o1, o2);
		
		//第二种情况时的返回
		if(left != null && right != null) {
			return head;
		}
		// 左右两课树 
		return left != null ? left : right;
	}
}
