package cn.lnu.array;

public class AjustArrayWithOdd_Even {

	/**
	 * 调整数组顺序使得奇数位于偶数的前面
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={1,2,3,4,5,6,7,8};
		ajustArrayWithOdd_Even(a);
		printArray(a);
	}

	private static void printArray(int[] a) {
		// TODO Auto-generated method stub
		if(a==null)
			return;
		for(int x:a){
			System.out.print(x+" ");
		}
	}

	private static void ajustArrayWithOdd_Even(int[] a) {
		// TODO Auto-generated method stub
		int len=a.length;
		int low=0;
		int high=len-1;
		int pivot=a[low];
		while(low<high){
			while(low<high&&a[high]%2==0) high--;
			a[low]=a[high];
			while(low<high&&a[low]%2!=0) low++;
			a[high]=a[low];
		}
		a[low]=pivot;
	}

}
