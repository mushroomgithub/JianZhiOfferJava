package cn.lnu.basesort;

public class BinaryInsertSort {

	/**
	 * ∂˛∑÷≤Â»Î≈≈–Ú
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a={7,4,6,5,3,8,1};
		binaryInsertSort(a);
		printArray(a);
	}

	private static void printArray(int[] a) {
		// TODO Auto-generated method stub
		for(int x:a){
			System.out.print(x+" ");
		}
	}

	private static void binaryInsertSort(int[] a) {
		// TODO Auto-generated method stub
		for(int i=1;i<a.length;i++){
			int temp=a[i];
			int low=0;
			int high=i-1;
			while(low<=high){
				int mid=(high+low)>>1;
				if(temp>a[mid])
					low=mid+1;
				if(temp<a[mid])
					high=mid-1;
			}
			for(int j=i-1;j>=low;j--)
				a[j+1]=a[j];
			a[low]=temp;
		}
	}
}
