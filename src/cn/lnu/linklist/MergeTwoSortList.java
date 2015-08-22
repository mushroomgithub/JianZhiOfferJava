package cn.lnu.linklist;

/*class LinkList{
	int data;
	LinkList next;
}*/
public class MergeTwoSortList {

	/**
	 * 合并两个有序单链表
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={0,1,3,5,7,9};
		int b[]={0,2,4,6,8};
		LinkList headA=CreateLinkList(a);
		PrintLinkList(headA);
		System.out.println();
		LinkList headB=CreateLinkList(b);
		PrintLinkList(headB);
		System.out.println();
		LinkList mergeHead=mergeList(headA,headB);
		PrintLinkList(mergeHead);
	}

	private static LinkList mergeList(LinkList headA, LinkList headB) {
		// TODO Auto-generated method stub
		if(headA==null){
			return headB;
		}
		if(headB==null){
			return headA;
		}
		
		LinkList mergeHead=null;
		if(headA.value<=headB.value){
			mergeHead=headA;
			mergeHead.next=mergeList(headA.next,headB);
		}
		if(headA.value>headB.value){
			mergeHead=headB;
			mergeHead.next=mergeList(headA,headB.next);
		}
		
		return mergeHead;
	}

	private static void PrintLinkList(LinkList head) {
		// TODO Auto-generated method stub
		if(head==null)
			return;
		LinkList p=head;
		while(p!=null){
			System.out.print(p.value+" ");
			p=p.next;
		}
	}

	private static LinkList CreateLinkList(int[] a) {
		// TODO Auto-generated method stub
		LinkList head=new LinkList();
		LinkList p=null;
		for(int i=1;i<a.length;i++){
			if(1==i){
				head.value=a[i];
				p=head;
			}else{
				LinkList q=new LinkList();
				q.value=a[i];
				q.next=null;
				p.next=q;
				p=q;
			}
		}
		return head;
	}

}
