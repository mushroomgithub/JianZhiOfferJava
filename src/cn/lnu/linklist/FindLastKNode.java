package cn.lnu.linklist;


public class FindLastKNode {

	/**
	 * 输出链表中倒数第k个节点
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={0,1,2,3,4,5,6,7};
		LinkList head=CreateLinkList(a);
		PrintLinkList(head);
		
		int kValue=findLastKNode(head,4);
		if(kValue!=-1){			
			System.out.println(kValue);
		}else{
			System.out.println("不合法的K值");
		}
	}

	private static int findLastKNode(LinkList head, int k) {
		// TODO Auto-generated method stub
		if(head==null)
			return -1;
		LinkList p,q;
		p=q=head;
		int len=0;
		while(p!=null){
			len++;
			p=p.next;
		}
		p=head;
		if(k>len||k<=0){
			return -1;
		}
		while(k>0&&p!=null){
			p=p.next;
			k--;
		}
		if(k==0){
			while(p!=null){
				p=p.next;
				q=q.next;
			}
			return q.value;
		}
		return -1;
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
