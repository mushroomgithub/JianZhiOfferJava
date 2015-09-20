package cn.lnu.array;

import java.util.Arrays;

public class MergeTwoSortArrayInOrder {

	/**
	 * 将两个有序数组合并为一个有序数组
	 * @param args
	 */
	public static void main(String[] args) {
		int a[]={1,3,5,7,9};
		int b[]={2,4,6,8};
		int merge[]=mergeTwoSortArrayInOrder(a,b);
		System.out.println(Arrays.toString(merge));
	}

	private static int[] mergeTwoSortArrayInOrder(int[] a, int[] b) {
		int len1=a.length;
		int len2=b.length;
		int result[]=new int[len1+len2];
		int i=0,j=0,k=0;
		while(i<len1&&j<len2){
			if(a[i]<=b[j]){
				result[k++]=a[i];
				i++;
			}else{
				result[k++]=b[j];
				j++;
			}
		}
		if(j==len2){
			while(i<len1){
				result[k++]=a[i];
				i++;
			}
		}
		if(i==len1){
			while(j<len2){
				result[k++]=b[j];
				j++;
			}
		}
		return result;
	}
}
