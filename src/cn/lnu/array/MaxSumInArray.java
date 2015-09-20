package cn.lnu.array;

public class MaxSumInArray {

	/**
	 * 求连续子数组的最大和
	 * @param args
	 */
	public static void main(String[] args) {
		int a[]={1,-2,3,10,-4,7,2,-5};
		int maxSum=getMaxSumInArray(a);
		System.out.println("数组中的最大的连续子数组和是："+maxSum);
	}

	private static int getMaxSumInArray(int[] a) {
		int maxSum=0;
		int curSum=0;
		for(int i=0;i<a.length;i++){
			curSum+=a[i];
			if(curSum>maxSum)
				maxSum=curSum;
			if(curSum<0)
				curSum=0;
		}
		return maxSum;
	}
}
