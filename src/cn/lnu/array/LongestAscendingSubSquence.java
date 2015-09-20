package cn.lnu.array;

import java.util.Arrays;

public class LongestAscendingSubSquence {

	/**
	 * ����һ�����飬��������������һ�������������(���Բ�����)
	 * ˼�룺
	 * ����һ��ԭ���飬����һ��help���飬���ڱ��浱ǰ���������еĳ��ȣ�maxLen��¼��ǰ
	 * ���������е���󳤶ȣ�maxIndex��¼ȡ�õ���������ȡ����󳤶�ʱ���±�
	 * ��ԭ�������������maxLen�Ĵ�С���ǵ��������е���󳤶ȣ����������������п�����
	 * ��������ô�maxIndexλ����ǰ�������У�����a[i]>a[j]��help[i]=help[i-1]+1��
	 * Ԫ�ؾ���ӵ�����������У����վͿ����һ������������У�ʱ�临�Ӷ�O(n^2)
	 * @param args
	 */
	public static void main(String[] args) {
		int a[]={2,1,6,5,3,7,8};
		String result=getLongestAscendingSubSquence(a);
		String result1=getLongestAscendingSubSquence1(a);
		System.out.println("���һ��������������ǣ�"+result);
		System.out.println("���һ��������������ǣ�"+result1);
	}

	private static String getLongestAscendingSubSquence(int[] a) {//ʱ�临�Ӷ�ΪO(n^2)
		int help[]=new int[a.length];//����һ��help���飬������������еĳ���
		help[0]=1;//��ʼ����Ϊ1
		int maxLen=1;//��¼���������е���󳤶�
		int maxIndex=0;//��¼����������ȡ����󳤶ȵ��±�
		for(int i=1;i<a.length;i++){//�ӵڶ���λ�ÿ�ʼ����help����
			help[i]=1;//��ʼΪ1
			for(int j=i-1;j>=0;j--){//�Ӻ�ǰ�ң�ֻҪ����a[i]>a[j]����ʱ����help[i]��ֵ��������ǳ�ʼ��1
				if(a[i]>a[j]){
					help[i]=help[j]+1;
					if(maxLen<help[i]){
						maxLen=help[i];
						maxIndex=i;
					}
					break;
				}
			}
		}
		//��������ȡ�����ֵ���±괦�Ӻ���ǰ������������������
		StringBuffer sb=new StringBuffer();
		sb.append(a[maxIndex]);
		for(int i=maxIndex;i>0;i--){
			if(a[i]>a[i-1]&&help[i]==help[i-1]+1){
				sb.append(a[i-1]);
			}
		}
		return sb.toString();
	}
	//�����۰���ҵķ�ʽ����help���飬ʱ�临�Ӷ�O(nlogn)
	private static String getLongestAscendingSubSquence1(int[] arr) {
		int[] dp = new int[arr.length];
		int[] help = new int[arr.length];
		// ��ʼ����һ����
		dp[0] = 1;
		help[0] = arr[0];
		int size_help = 0;// help������Ԫ�صĸ���
		int left = 0;// help��ʼ�±�
		int right = 0;// help��β�±�
		int mid = 0;
		int max_posi = 0;// ������������г���
		// O(nlogn)
		for (int i = 1; i < arr.length; i++) {
			left = 0;
			right = size_help;
			while (left <= right) {
				mid = (left + right) / 2;
				if (arr[i] > help[mid]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
			size_help = Math.max(right, left);
			help[left] = arr[i];
			dp[i] = left + 1;
			if (dp[i] > dp[max_posi])
				max_posi = i;
		}
		// O(n)
		StringBuffer sb = new StringBuffer();
		sb.append(arr[max_posi] + ",");
		for (int i = max_posi; i > 0; i--)
			if (arr[i] > arr[i - 1] && (dp[i - 1] + 1 == dp[i]))
				sb.append(arr[i - 1] + ",");
		return sb.toString();
		
	}
}
