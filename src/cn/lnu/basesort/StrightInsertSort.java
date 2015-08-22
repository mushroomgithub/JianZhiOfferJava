package cn.lnu.basesort;

public class StrightInsertSort {

	/**
	 *÷±Ω”≤Â»Î≈≈–Ú
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a={7,4,6,5,3,8,1};
		strightInsertSort(a);
		printArray(a);
	}

	private static void printArray(int[] a) {
		// TODO Auto-generated method stub
		for(int x: a){
			System.out.print(x+" ");
		}
	}

	private static void strightInsertSort(int[] a) {
		// TODO Auto-generated method stub
		for(int i=1;i<a.length;i++){
			int temp=a[i];
			int k=i;
			if(a[i]<a[i-1]){
				for(int j=i-1;j>=0;j--){
					if(temp<a[j]){
						k=j;
					}
				}
				for(int m=i-1;m>=k;m--)
					a[m+1]=a[m];
			}
			a[k]=temp;
		}
	}

}
