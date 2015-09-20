package cn.lnu.array;

public class AppearMoreThanHalfOfArray {

	/**
	 * 数组中出现次数超过一半的数字
	 * @param args
	 */
	public static void main(String[] args) {
		int a[]={1,2,3,2,2,2,5,4,2};
		int result=appearMoreThanHalfOfArray(a);
		System.out.println("数组中出现次数超过一半的数字是："+result);
	}

	private static int appearMoreThanHalfOfArray(int[] a) {
		int len=a.length;
		int low=0;
		int high=len-1;
		int mid=(low+high)/2;
		int index=paritition(a,low,high);
		while(index!=mid){
			if(index>mid){
				high=index-1;
				index=paritition(a,low,high);
			}
			if(index<mid){
				low=index+1;
				index=paritition(a,low,high);
			}
		}	
		boolean b=check(a,a[index]);
		if(b)
			return a[index];
		return -1;
	}
	//验证中间元素出现次数是否超过一半
	private static boolean check(int[] a, int value) {
		int count=0;
		for(int i=0;i<a.length;i++){
			if(value==a[i]){
				count++;
			}
		}
		if(count*2<a.length)
			return false;
		return true;
	}
	//一趟快排
	private static int paritition(int[] a, int low, int high) {
		if(a==null)
			return -1;
		int pivot=a[low];
		while(low<high){
			while(low<high&&a[high]>=pivot)high--;
			a[low]=a[high];
			while(low<high&&a[low]<pivot)low++;
			a[high]=a[low];
		}
		a[low]=pivot;
		return low;
	}
}
