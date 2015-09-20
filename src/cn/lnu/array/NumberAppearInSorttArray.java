package cn.lnu.array;

import java.util.HashMap;
import java.util.Map;

public class NumberAppearInSorttArray {

	/**
	 * 统计数字在排序数组中出现的次数
	 * 例如输入排序数组{1,2,3,3,3,3,4,5}和数字3，
	 * 由于3在这个数组中出现了4次，因此输出4.
	 * 思路：
	 * 使用递归的二分查找算法找到数字在排序数组的开始与结束下标
	 * start与end，然后使用end-start+1计算得出该数字在排序数组中出现的次数
	 * @param args
	 */
	public static void main(String[] args) {
		int a[]={1,2,3,3,3,3,4,5};
		int num=3;
		int count=getNumAppearInSortArray(a,num);
		System.out.println("数字"+num+"在排序数组中出现的次数是："+count);
	}

	private static int getNumAppearInSortArray(int[] a,int num) {
		int start=0;
		int end=0;
		start=getFistAppearIndex(a,num,0,a.length-1);
		end=getLastAppearIndex(a,num,0,a.length-1);
		int count=0;
		if(start!=-1&&end!=-1)
			count=end-start+1;
		return count;
	}

	private static int getLastAppearIndex(int[] a, int num,int low,int high) {
		if(a==null||low>high)
			return -1;
		int mid=(low+high)/2;
		if(a[mid]==num){
			if((mid<a.length-1&&a[mid+1]!=num)||mid==a.length-1){
				return mid;
			}else{
				low=mid+1;
			}
		}else if(a[mid]>num){
			high=mid-1;
		}else{
			low=mid+1;
		}
		return getLastAppearIndex(a,num,low,high);
	}

	private static int getFistAppearIndex(int[] a, int num,int low,int high) {
		if(a==null||low>high)
			return -1;
		int mid=(low+high)/2;
		if(a[mid]==num){
			if((mid>0&&a[mid-1]!=num)||mid==0){
				return mid;
			}else{
				high=mid-1;
			}
		}else if(a[mid]>num) {
			high=mid-1;
		}
		else low=mid+1;
		return getFistAppearIndex(a,num,low,high);
	}

}
