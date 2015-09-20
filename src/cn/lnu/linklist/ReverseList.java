package cn.lnu.linklist;

class LinkList{
	int value;
	LinkList next;
}
public class ReverseList {

	/**
	 * ��ת������
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={0,3,4,2,1,5,7,6};
		LinkList head=CreateLinkList(a);
		PrintLinkList(head);
		System.out.println();
		head=reverseList(head);
		PrintLinkList(head);
	}
	
	private static LinkList reverseList(LinkList head) {
		// TODO Auto-generated method stub
		if(head==null)
			return null;
		LinkList reverseHead=null;
		LinkList p=head,prev=null;
		while(p!=null){
			LinkList q=p.next;//���õ�ǰ�ڵ�ĺ��
			if(q==null){//˵���Ѿ������һ���ڵ㣬���÷�ת֮���ͷָ��
				reverseHead=p;
			}
			p.next=prev;
			prev=p;
			p=q;
		}
		return reverseHead;
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
