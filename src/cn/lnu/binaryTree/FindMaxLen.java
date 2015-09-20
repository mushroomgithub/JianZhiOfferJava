package cn.lnu.binaryTree;

class BTreeNode{
	int data;//���ֵ
	int nMaxLeft;//�ýڵ��������е������
	int nMaxRight;//�ýڵ��������������
	BTreeNode left;
	BTreeNode right;
}

public class FindMaxLen {
	/**
	 *��������нڵ�������
	 */
	private static int MaxLen;
	public static void main(String[] args) {
		int []a={-1,1,2,3,4,5,6,7,8,9,10};
		BTreeNode root=CreateBinaryTree(a,1,a.length-1);
		PrintBinaryTree(root);
		System.out.println();
		FindMaxLen(root);
		System.out.println("�������нڵ��������ǣ�"+MaxLen);
	}

	private static void FindMaxLen(BTreeNode root) {
		//������Ҷ�ӽڵ㣬����
		if(root==null){
			return;
		}
		//���������Ϊ�գ���ô�ýڵ����������Ϊ0
		if(root.left==null){
			root.nMaxLeft=0;
		}
		//���������Ϊ�գ���ô�ýڵ���ұ������Ϊ0
		if(root.right==null){
			root.nMaxRight=0;
		}
		//�����������Ϊ�գ��ݹ�Ѱ�������������
		if(root.left!=null){
			FindMaxLen(root.left);
		}
		//�����������Ϊ�գ��ݹ�Ѱ�������������
		if(root.right!=null){
			FindMaxLen(root.right);
		}
		//������������ڵ����
		if(root.left!=null){
			int tempMax=0;
			if(root.left.nMaxLeft>root.left.nMaxRight){
				tempMax=root.left.nMaxLeft;
			}else{
				tempMax=root.left.nMaxRight;
			}
			root.nMaxLeft=tempMax+1;
		}
		//������������ڵ����
		if(root.right!=null){
			int tempMax=0;
			if(root.right.nMaxLeft>root.right.nMaxRight){
				tempMax=root.right.nMaxLeft;
			}else{
				tempMax=root.right.nMaxRight;
			}
			
			root.nMaxRight=tempMax+1;
		}
		//���ϸ�����õ������
		if(root.nMaxLeft+root.nMaxRight>MaxLen){
			MaxLen=root.nMaxLeft+root.nMaxRight;
		}
	}

	//�����ӡ������
	private static void PrintBinaryTree(BTreeNode root) {
		if(root==null)
			return;
		System.out.print(root.data+" ");
		PrintBinaryTree(root.left);
		PrintBinaryTree(root.right);
		
	}

	//���򴴽�������
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
