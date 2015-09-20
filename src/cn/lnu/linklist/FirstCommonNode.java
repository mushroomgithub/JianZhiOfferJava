package cn.lnu.linklist;

public class FirstCommonNode {

	/**
	 * 求两个链表的第一个公共节点
	 */
	public static void main(String[] args) {
		int a[]={0,1,3,5,7};
		int b[]={0,2,4,6};
		int c[]={0,8,9,10};
		LinkList headA=CreateLinkList(a);
		LinkList headB=CreateLinkList(b);
		addCommonNode(headA,headB,c);
		LinkList commonNode=findCommonNode(headA,headB);
		System.out.println(commonNode.value);
	}

	private static LinkList findCommonNode(LinkList headA, LinkList headB) {
		int lenA=0,lenB=0;
		lenA=getLength(headA);
		lenB=getLength(headB);
		LinkList longHead=null;
		LinkList shortHead=null;
		int diffLen=0;
		if(lenA>lenB){
			longHead=headA;
			shortHead=headB;
			diffLen=lenA-lenB;
		}
		if(lenA<lenB){
			longHead=headB;
			shortHead=headA;
			diffLen=lenB-lenA;
		}
		while(diffLen>0){
			longHead=longHead.next;
			diffLen--;
		}
		while(shortHead!=null){
			if(shortHead==longHead)
				return shortHead;
			longHead=longHead.next;
			shortHead=shortHead.next;
		}
		return null;
	}
	private static int getLength(LinkList head) {
		// TODO Auto-generated method stub
		LinkList p=head;
		int len=0;
		while(p!=null){
			p=p.next;
			len++;
		}
		return len;
	}
	private static void addCommonNode(LinkList headA, LinkList headB,
			int[] c) {
		// TODO Auto-generated method stub
		LinkList headC=CreateLinkList(c);
		LinkList p,q;
		p=headA;
		q=headB;
		while(p.next!=null){
			p=p.next;
		}
		while(q.next!=null){
			q=q.next;
		}
		p.next=headC;
		q.next=headC;
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
		System.out.println();
	}

	private static LinkList CreateLinkList(int[] a) {
		// TODO Auto-generated method stub
		if(a==null)
			return null;
		LinkList head=new LinkList();
		head.next=null;
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
