package cn.lnu.array;

import java.util.Arrays;

public class MaxSubArray {

	/**
	 * 求整数数组中和最大的子数组
	 * @param args
	 */
	public static void main(String[] args) {
		int a[]={1,-2,3,10,-4,7,2,-5};
		int[] maxSubArray=getMaxSubArray(a);
		System.out.println("数组中的最大的连续子数组是："+Arrays.toString(maxSubArray));
	}

	private static int[] getMaxSubArray(int[] a) {
		int maxSum=0;
		int maxStart=0;
		int maxEnd=0;
		int curSum=0;
		int curStart=0;
		for(int i=0;i<a.length;i++){
			if(i==0){
				curSum=maxSum=a[i];
				curStart=maxStart=i;
				continue;
			}
			if(curSum<0){
				curSum=0;
				curStart=i;
			}
			curSum+=a[i];
			if(curSum>maxSum){
				maxSum=curSum;
				maxStart=curStart;
				maxEnd=i;
			}
		}
		int len=maxEnd-maxStart+1;
		int maxSubArray[]=new int[len];
		for(int j=maxStart,i=0;i<len&&j<=maxEnd;j++,i++){
			maxSubArray[i]=a[j];
		}
		return maxSubArray;
	}
}
