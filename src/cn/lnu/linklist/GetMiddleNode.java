package cn.lnu.linklist;

public class GetMiddleNode {

	/**
	 * 返回链表中间节点
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={0,1,2,3,4,5,6};
		LinkList head=CreateLinkList(a);
		PrintLinkList(head);
		LinkList middleNode=getMiddleNode(head);
		System.out.println(middleNode.value);
	}

	private static LinkList getMiddleNode(LinkList head) {
		// TODO Auto-generated method stub
		if(head==null||head.next==null)
			return head;
		LinkList slow,fast;
		slow=head;
		fast=head;
		while(fast!=null&&fast.next!=null&&fast.next.next!=null){
			fast=fast.next.next;
			slow=slow.next;
		}
		return slow;
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
		LinkList head=new LinkList(),p=null;
		head.next=null;
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
