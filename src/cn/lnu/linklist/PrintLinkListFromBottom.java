package cn.lnu.linklist;

import java.util.Stack;

public class PrintLinkListFromBottom {

	/**
	 * 从尾到头打印单链表
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={0,1,2,3,4,5,6,7};
		LinkList head=CreateLinkList(a);
		PrintLinkList(head);
		PrintLinkListFromBottom(head);
	}

	private static void PrintLinkListFromBottom(LinkList head) {
		// TODO Auto-generated method stub
		if(head==null)
			return;
		LinkList p=head;
		Stack<LinkList> stk=new Stack<LinkList>();
		while(p!=null){
			stk.push(p);
			p=p.next;
		}
		while(!stk.empty()){
			LinkList q=stk.pop();
			System.out.print(q.value+" ");
		}
		System.out.println();
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
