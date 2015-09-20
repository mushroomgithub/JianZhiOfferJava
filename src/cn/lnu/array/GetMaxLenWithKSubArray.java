package cn.lnu.array;

import java.util.Arrays;

public class GetMaxLenWithKSubArray {

	/**
	 * ����һ�����������һ��kֵ���������������������֮�͵���k,
	 * ���ҳ������������,ע��˴��������е�Ԫ�ض�������
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
			if(sum==k){//˵�����ҵ�һ�����������������飬����������ĳ����Լ���ʼ�����±꣬ͬʱleft����һλ���������ڣ�ͬʱsum��ȥ֮ǰ��a[left]
				maxLen=Math.max(maxLen, right-left+1);
				maxStart=left;
				maxEnd=right;
				
				sum-=a[left++];
			}
			if(sum<k){//�������ڣ�sum�ۼ�
				right++;
				if(right==a.length){
					break;
				}
				sum+=a[right];
			}
			if(sum>k){//���������ڴ�С��ͬʱsum��΢��С
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
