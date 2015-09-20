package cn.lnu.binaryTree;

import java.util.LinkedList;

class BinaryTreeNode{
	int data;
	BinaryTreeNode left;
	BinaryTreeNode right;
}
public class BinaryTreeWidth_Depth {

	/**
	 * 求二叉树的宽度和高度
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={0,1,2,3,4,5,6,7,8,9};
		BinaryTreeNode root=CreateBinaryTree(a,1,a.length-1);
		PrintBinaryTree(root);
		System.out.println();
		int depth=getBinaryTreeDepth(root);
		System.out.println("the depth of BinaryTree is:"+depth);
		int width=getBinaryTreeWidth(root);
		System.out.println("the width of BinaryTree is:"+width);
	}

	private static int getBinaryTreeWidth(BinaryTreeNode root) {
		// TODO Auto-generated method stub
		if(root==null)
			return 0;
		LinkedList<BinaryTreeNode> dq=new LinkedList<BinaryTreeNode>();
		dq.add(root);
		int width=1;
		int maxWidth=1;
		while(!dq.isEmpty()){
			int curWidth=0;
			while(width!=0){
				BinaryTreeNode curNode=dq.removeFirst();
				if(curNode.left!=null){
					dq.addLast(curNode.left);
					curWidth++;
				}
				if(curNode.right!=null){
					dq.addLast(curNode.right);
					curWidth++;
				}
				width--;
			}
			width=curWidth;
			if(curWidth>maxWidth)
				maxWidth=curWidth;
		}
		return maxWidth;
	}

	private static int getBinaryTreeDepth(BinaryTreeNode root) {
		// TODO Auto-generated method stub
		if(root==null)
			return 0;
		int left=getBinaryTreeDepth(root.left);
		int right=getBinaryTreeDepth(root.right);
		return left>right?left+1:right+1;
	}

	private static void PrintBinaryTree(BinaryTreeNode root) {
		// TODO Auto-generated method stub
		if(root==null)
			return;
		System.out.print(root.data+" ");
		PrintBinaryTree(root.left);
		PrintBinaryTree(root.right);
	}

	private static BinaryTreeNode CreateBinaryTree(int[] a, int i, int n) {
		if(i>n)
			return null;
		BinaryTreeNode root=new BinaryTreeNode();
		root.data=a[i];
		root.left=CreateBinaryTree(a,2*i,n);
		root.right=CreateBinaryTree(a,2*i+1,n);
		return root;
	}
	
}
