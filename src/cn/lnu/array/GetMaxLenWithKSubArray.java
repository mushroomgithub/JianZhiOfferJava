package cn.lnu.array;

import java.util.Arrays;

public class GetMaxLenWithKSubArray {

	/**
	 * 给定一个正数数组和一个k值，求出数组中满足子数组之和等于k,
	 * 并且长度最长的子数组,注意此处的数组中的元素都是正数
	 * @param args
	 */
	public static void main(String[] args) {
		int a[]={1,1,2,3,1,1};
		int maxLen=getMaxLen(a,6);
		System.out.println(maxLen);
	}

	private static int getMaxLen(int[] a, int k) {
		if(a==null||a.length==0||k<=0)
			return -1;
		int left=0;
		int right=0;
		int maxLen=0;
		int maxStart=0;
		int maxEnd=0;
		int sum=a[0];
		while(right<a.length){
			if(sum==k){//说明又找到一个满足条件的子数组，更新子数组的长度以及开始结束下标，同时left右移一位，缩减窗口，同时sum减去之前的a[left]
				maxLen=Math.max(maxLen, right-left+1);
				maxStart=left;
				maxEnd=right;
				
				sum-=a[left++];
			}
			if(sum<k){//右扩窗口，sum累加
				right++;
				if(right==a.length){
					break;
				}
				sum+=a[right];
			}
			if(sum>k){//左缩减窗口大小，同时sum稍微减小
				sum-=a[left++];
			}
		}
		int res[]=new int[maxLen];
		int j=0;
		for(int i=maxStart;i<=maxEnd;i++){
			res[j++]=a[i];
		}
		System.out.println(Arrays.toString(res));
		return maxLen;
	}
}
