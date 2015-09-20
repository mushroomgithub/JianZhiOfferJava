package cn.lnu.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindPathInBinaryWithSum {
	public static void main(String[] args) {
		int[] nodeValue={-1,10,5,12,4,7};
		BTiNode root=CreateBinaryTree(nodeValue,1,nodeValue.length-1);
		PrintBinaryTree(root);
		System.out.println();
		findNodePath(root, 22);
	}
	public static void findNodePath(BTiNode p, int nodeSum) {
		List<BTiNode> path=new ArrayList<BTiNode>();
		Stack<BTiNode> stkNode=new Stack<BTiNode>();
		int flag;
		int curSum=0;
		Stack<Integer> stkFlag=new Stack<Integer>();
		while(p!=null || !stkNode.isEmpty()){
			while(p!=null){
				stkNode.push(p);
				stkFlag.push(0);
				path.add(p);
				curSum+=p.data;
				p=p.left;
			}
			p=stkNode.pop();
			flag=stkFlag.pop();
			if(flag==0){
				stkNode.push(p);
				stkFlag.push(1);
				p=p.right;
			}else{
				if(p.left==null&&p.right==null&&curSum==nodeSum){
					System.out.print("find A path:");
					PrintPath(path);
				}
				p=path.remove(path.size()-1);
				curSum-=p.data;
				p=null;
			}
		}
	}
	private static void PrintPath(List<BTiNode> path) {
		System.out.print("[");
		for(int i=0;i<path.size();i++){
			if(i!=path.size()-1){
				System.out.print(path.get(i).data+",");
			}else{
				System.out.println(path.get(i).data+"]");
			}
		}
		
	}
	private static void PrintBinaryTree(BTiNode root) {
		if(root==null)
			return;
		System.out.print(root.data+" ");
		PrintBinaryTree(root.left);
		PrintBinaryTree(root.right);
		
	}
	//先序创建二叉树
	public static BTiNode CreateBinaryTree(int[] nodeValue, int i, int length) {
		if(i>length)
			return null;
		BTiNode root=new BTiNode();
		root.data=nodeValue[i];
		root.left=CreateBinaryTree(nodeValue,2*i,length);
		root.right=CreateBinaryTree(nodeValue,2*i+1,length);
		return root;
	}
}
