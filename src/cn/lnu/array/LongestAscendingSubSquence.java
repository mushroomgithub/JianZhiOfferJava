package cn.lnu.array;

import java.util.Arrays;

public class LongestAscendingSubSquence {

	/**
	 * 给定一个数组，求出该数组的其中一个最长递增子序列(可以不连续)
	 * 思想：
	 * 遍历一遍原数组，构建一个help数组，用于保存当前递增子序列的长度，maxLen记录当前
	 * 递增子序列的最大长度，maxIndex记录取得递增子序列取得最大长度时的下标
	 * 当原数组遍历结束，maxLen的大小就是递增子序列的最大长度，满足条件的子序列可能有
	 * 多个，采用从maxIndex位置向前找子序列，满足a[i]>a[j]且help[i]=help[i-1]+1的
	 * 元素就添加到结果子序列中，最终就可求得一个最长递增子序列，时间复杂度O(n^2)
	 * @param args
	 */
	public static void main(String[] args) {
		int a[]={2,1,6,5,3,7,8};
		String result=getLongestAscendingSubSquence(a);
		String result1=getLongestAscendingSubSquence1(a);
		System.out.println("求得一个最长递增子序列是："+result);
		System.out.println("求得一个最长递增子序列是："+result1);
	}

	private static String getLongestAscendingSubSquence(int[] a) {//时间复杂度为O(n^2)
		int help[]=new int[a.length];//创建一个help数组，保存递增子序列的长度
		help[0]=1;//初始设置为1
		int maxLen=1;//记录递增子序列的最大长度
		int maxIndex=0;//记录递增子序列取得最大长度的下标
		for(int i=1;i<a.length;i++){//从第二个位置开始生成help数组
			help[i]=1;//初始为1
			for(int j=i-1;j>=0;j--){//从后前找，只要满足a[i]>a[j]，此时更新help[i]的值，否则就是初始的1
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
		//从子序列取得最大值的下标处从后向前找满足条件的子序列
		StringBuffer sb=new StringBuffer();
		sb.append(a[maxIndex]);
		for(int i=maxIndex;i>0;i--){
			if(a[i]>a[i-1]&&help[i]==help[i-1]+1){
				sb.append(a[i-1]);
			}
		}
		return sb.toString();
	}
	//采用折半查找的方式构建help数组，时间复杂度O(nlogn)
	private static String getLongestAscendingSubSquence1(int[] arr) {
		int[] dp = new int[arr.length];
		int[] help = new int[arr.length];
		// 初始化第一个数
		dp[0] = 1;
		help[0] = arr[0];
		int size_help = 0;// help数组里元素的个数
		int left = 0;// help开始下标
		int right = 0;// help结尾下标
		int mid = 0;
		int max_posi = 0;// 保持最大子序列长度
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
