package cn.lnu.binaryTree;

class BTreeNode{
	int data;//结点值
	int nMaxLeft;//该节点左子树中的最长距离
	int nMaxRight;//该节点右子树的最长距离
	BTreeNode left;
	BTreeNode right;
}

public class FindMaxLen {
	/**
	 *求二叉树中节点的最长距离
	 */
	private static int MaxLen;
	public static void main(String[] args) {
		int []a={-1,1,2,3,4,5,6,7,8,9,10};
		BTreeNode root=CreateBinaryTree(a,1,a.length-1);
		PrintBinaryTree(root);
		System.out.println();
		FindMaxLen(root);
		System.out.println("二叉树中节点的最长距离是："+MaxLen);
	}

	private static void FindMaxLen(BTreeNode root) {
		//遍历到叶子节点，返回
		if(root==null){
			return;
		}
		//如果左子树为空，那么该节点的左边最长距离为0
		if(root.left==null){
			root.nMaxLeft=0;
		}
		//如果右子树为空，那么该节点的右边最长距离为0
		if(root.right==null){
			root.nMaxRight=0;
		}
		//如果左子树不为空，递归寻找左子树最长距离
		if(root.left!=null){
			FindMaxLen(root.left);
		}
		//如果右子树不为空，递归寻找右子树最长距离
		if(root.right!=null){
			FindMaxLen(root.right);
		}
		//计算左子树最长节点距离
		if(root.left!=null){
			int tempMax=0;
			if(root.left.nMaxLeft>root.left.nMaxRight){
				tempMax=root.left.nMaxLeft;
			}else{
				tempMax=root.left.nMaxRight;
			}
			root.nMaxLeft=tempMax+1;
		}
		//计算右子树最长节点距离
		if(root.right!=null){
			int tempMax=0;
			if(root.right.nMaxLeft>root.right.nMaxRight){
				tempMax=root.right.nMaxLeft;
			}else{
				tempMax=root.right.nMaxRight;
			}
			
			root.nMaxRight=tempMax+1;
		}
		//不断更新求得的最长距离
		if(root.nMaxLeft+root.nMaxRight>MaxLen){
			MaxLen=root.nMaxLeft+root.nMaxRight;
		}
	}

	//先序打印二叉树
	private static void PrintBinaryTree(BTreeNode root) {
		if(root==null)
			return;
		System.out.print(root.data+" ");
		PrintBinaryTree(root.left);
		PrintBinaryTree(root.right);
		
	}

	//先序创建二叉树
	private static BTreeNode CreateBinaryTree(int[] a, int i, int len) {
		if(i>len)
			return null;
		BTreeNode root=new BTreeNode();
		root.data=a[i];
		root.left=CreateBinaryTree(a, 2*i, len);
		root.right=CreateBinaryTree(a, 2*i+1, len);
		
		return root;
	}
}
