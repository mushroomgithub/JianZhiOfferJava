package cn.lnu.basesort;

public class ShellSort {

	/**
	 *Ï£¶ûÅÅÐò
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={49,38,65,97,76,13,27,49,55,4};
		int d[]={5,3,1};
		shellSort(a, d);
		printArray(a);
	}
	
	private static void shellSort(int[] a,int[] d) {
		// TODO Auto-generated method stub
		for(int i=0;i<d.length;i++){
			shellInsert(a,d[i]);
		}
	}

	private static void shellInsert(int[] a, int d) {
		// TODO Auto-generated method stub
		for(int i=d;i<a.length;i++){
			int temp=a[i];
			int k=i;
			if(a[i]<a[i-d]){
				for(int j=i-d;j>=0;j-=d){
					if(temp<a[j])
						k=j;
				}
				for(int m=i-d;m>=k;m-=d)
					a[m+d]=a[m];
			}
			a[k]=temp;
		}
	}

	private static void printArray(int[] a) {
		// TODO Auto-generated method stub
		for(int x:a){
			System.out.print(x+" ");
		}
	}

}
