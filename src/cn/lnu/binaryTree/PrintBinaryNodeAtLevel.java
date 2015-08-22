package cn.lnu.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

class BTiNode{
	int data;
	BTiNode left;
	BTiNode right;
}

public class PrintBinaryNodeAtLevel {
	/*
	 * 分层打印自上而下，自左到右打印二叉树结点
	 * */
	
	public static void main(String[] args) {
		int[] a={-1,1,2,3,4,5,6,7,8,9};
		BTiNode root=CreateBinaryTree(a,1,a.length-1);
		PrintBinaryTree(root);
		System.out.println();
		PrintBinaryTreeAtLevel(root);
	}

	//先序创建二叉树
	private static  BTiNode CreateBinaryTree(int[] a,int i,int length){
		if(i>length)
			return null;
		BTiNode root=new BTiNode();
		root.data=a[i];
		root.left=CreateBinaryTree(a, 2*i, length);
		root.right=CreateBinaryTree(a, 2*i+1, length);
		return root;
	}
	//先序打印二叉树
	private static void PrintBinaryTree(BTiNode root){
		if(root==null)
			return;
		System.out.print(root.data+" ");
		PrintBinaryTree(root.left);
		PrintBinaryTree(root.right);
	}
	
	//分层打印自上而下，自左到右打印二叉树结点
	private static void PrintBinaryTreeAtLevel(BTiNode root){
		LinkedList<BTiNode> dq=new LinkedList<BTiNode>();
		if(root!=null){
			dq.addLast(root);
		}
		int curWidth=1;
		int newLen=0;
		while(!dq.isEmpty()){
			while(curWidth!=0){
				BTiNode p=dq.removeFirst();
				System.out.print(p.data+" ");
				if(p.left!=null){
					dq.addLast(p.left);
					newLen++;
				}
				if(p.right!=null){
					dq.addLast(p.right);
					newLen++;
				}
				curWidth--;
			}
			System.out.println();
			curWidth=newLen;
			newLen=0;
		}
	}
}
