package cn.lnu.basesort;

public class StrightSelectSort {

	/**
	 * ÷±Ω”—°‘Ò≈≈–Ú
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a={7,4,6,5,3,8,1};
		printArray(a);
		System.out.println();
		strightSelectSort(a);
		printArray(a);
	}

	private static void printArray(int[] a) {
		// TODO Auto-generated method stub
		for(int x: a){
			System.out.print(x+" ");
		}
	}

	private static void strightSelectSort(int[] a) {
		// TODO Auto-generated method stub
		int n=a.length;
		for(int i=0;i<n;i++){
			int min=i;
			for(int j=i+1;j<n;j++){
				if(a[min]>a[j]){
					min=j;
				}
			}
			swap(a,i,min);
		}
	}

	private static void swap(int[] a, int i, int min) {
		// TODO Auto-generated method stub
		int temp=a[i];
		a[i]=a[min];
		a[min]=temp;
	}

}
