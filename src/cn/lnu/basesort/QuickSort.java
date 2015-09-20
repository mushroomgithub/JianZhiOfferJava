package cn.lnu.basesort;

public class QuickSort {

	/**
	 * øÏ≈≈
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a={7,4,6,5,3,8,1};
		printArray(a);
		System.out.println();
		quickSort(a,0,a.length-1);
		printArray(a);
	}

	private static void printArray(int[] a) {
		// TODO Auto-generated method stub
		for(int x: a){
			System.out.print(x+" ");
		}
	}

	private static int partition(int[] a,int low,int high){
		
		int pivot=a[low];
		while(low<high){
			while(low<high && a[high]>pivot) high--;
			a[low]=a[high];
			while(low<high && a[low]<pivot) low++;
			a[high]=a[low];	
		}
		a[low]=pivot;
		return low;
	}
	
	private static void quickSort(int[] a,int low,int high){
		if(low<high){
			int pivotLoc=partition(a,low,high);
			quickSort(a,low,pivotLoc-1);
			quickSort(a,pivotLoc+1,high);
		}
	}
}
