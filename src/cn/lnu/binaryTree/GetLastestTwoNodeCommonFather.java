package cn.lnu.binaryTree;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*class BTiNode{
	int data;
	BTiNode left;
	BTiNode right;
}*/

public class GetLastestTwoNodeCommonFather {

	public static void main(String[] args) {
		int[] nodeValue={-1,1,2,3,4,5,6,7,8,9,10,11};
		BTiNode root=CreateBinaryTree(nodeValue,1,nodeValue.length-1);
		int node1=9;
		int node2=10;
		BTiNode theLastestCommonFatherNode=GetLCF(root,node1,node2);
		if(theLastestCommonFatherNode==null){
			System.out.println("结点"+node1+"与结点"+node2+"不存在最低公共祖先.");
		}else{
			System.out.println("结点"+node1+"与结点"+node2+"的最低公共祖先是:"+theLastestCommonFatherNode.data);
		}
	}
	public static BTiNode GetLCF(BTiNode root, int node1, int node2) {
		List<BTiNode> node1Path=new ArrayList<BTiNode>();
		List<BTiNode> node2Path=new ArrayList<BTiNode>();
		node1Path=GetNodePath(root,node1);
		node2Path=GetNodePath(root,node2);
		BTiNode commonNode=null;
		if(node1Path.isEmpty()){
			System.out.println("不存在到node1结点的路径！");
			return null;
		}
		PrintPath(node1Path);
		if(node2Path.isEmpty()){
			System.out.println("不存在到node2结点的路径！");
			return null;
		}
		PrintPath(node2Path);
		int index=0;
		while(index<node1Path.size() && index<node2Path.size()){
			if(node1Path.get(index).data!=node2Path.get(index).data){
				commonNode=node1Path.get(index-1);
				break;
			}
			index++;
		}
		return commonNode;
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
	public static List<BTiNode> GetNodePath(BTiNode p, int node) {
		List<BTiNode> path=new ArrayList<BTiNode>();
		Stack<BTiNode> stkNode=new Stack<BTiNode>();
		int flag;
		Stack<Integer> stkFlag=new Stack<Integer>();
		while(p!=null || !stkNode.isEmpty()){
			while(p!=null){
				stkNode.push(p);
				stkFlag.push(0);
				path.add(p);
				p=p.left;
			}
			p=stkNode.pop();
			flag=stkFlag.pop();
			if(flag==0){
				stkNode.push(p);
				stkFlag.push(1);
				p=p.right;
			}else{
				if(p.data==node){
					return path;
				}else{
					path.remove(path.size()-1);
					p=null;
				}
			}
		}
		return null;
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
