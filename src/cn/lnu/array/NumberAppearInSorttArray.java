package cn.lnu.array;

import java.util.HashMap;
import java.util.Map;

public class NumberAppearInSorttArray {

	/**
	 * ͳ�����������������г��ֵĴ���
	 * ����������������{1,2,3,3,3,3,4,5}������3��
	 * ����3����������г�����4�Σ�������4.
	 * ˼·��
	 * ʹ�õݹ�Ķ��ֲ����㷨�ҵ���������������Ŀ�ʼ������±�
	 * start��end��Ȼ��ʹ��end-start+1����ó������������������г��ֵĴ���
	 * @param args
	 */
	public static void main(String[] args) {
		int a[]={1,2,3,3,3,3,4,5};
		int num=3;
		int count=getNumAppearInSortArray(a,num);
		System.out.println("����"+num+"�����������г��ֵĴ����ǣ�"+count);
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
