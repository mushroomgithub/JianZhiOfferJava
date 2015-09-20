package cn.lnu.linklist;

/*class LinkList{
	int value;
	LinkList next;
}*/
public class SortLinkList {

	/**
	 * 实现单链表的排序
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={0,3,4,2,1,5,7,6};
		LinkList head=CreateLinkList(a);
		PrintLinkList(head);
		head=sortLinkList(head);
		PrintLinkList(head);
	}
	//采用冒泡排序的思想对单链表进行排序
	private static LinkList sortLinkList(LinkList head) {
		// TODO Auto-generated method stub
		if(head==null||head.next==null)
			return head;
		int n=getLength(head);
		LinkList p=null;
		for(int i=1;i<n;i++){
			p=head;
			for(int j=1;j<=n-i;j++){
				if(p.value>p.next.value){
					int temp=p.value;
					p.value=p.next.value;
					p.next.value=temp;
				}
				p=p.next;
			}
		}
		return head;
	}

	private static int getLength(LinkList head) {
		// TODO Auto-generated method stub
		if(head==null)
			return 0;
		LinkList p=head;
		int count=0;
		while(p!=null){
			count++;
			p=p.next;
		}
		return count;
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
