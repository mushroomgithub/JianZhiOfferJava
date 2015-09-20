package cn.lnu.basesort;

public class BubbleSort {

	/**
	 * √∞≈›≈≈–Ú
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a={7,4,6,5,3,8,1};
		printArray(a);
		System.out.println();
		bubbleSort(a);
		
		printArray(a);
	}

	private static void printArray(int[] a) {
		// TODO Auto-generated method stub
		/*for(int x:a){
			System.out.print(x+" ");
		}*/
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}

	private static void bubbleSort(int[] a) {
		// TODO Auto-generated method stub
		int n=a.length;
		boolean flag=true;
		for(int i=1;i<=n-1&&flag;i++){
			flag=false;
			for(int j=1;j<=n-i;j++){
				if(a[j-1]>a[j]){
					swap(a,j-1,j);
					flag=true;
				}
			}
		}
	}

	private static void swap(int[] a, int i, int j) {
		// TODO Auto-generated method stub
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}

}
