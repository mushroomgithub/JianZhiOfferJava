package cn.lnu.array;
import java.util.Arrays;
import java.util.HashSet;

public class LongestZHSubArray {
	/*
	 * 最长的可整合子数组的长度
	   先给出可整合数组的定义。如果一个数组在排序之后，每相邻两个数差的绝对值都为1，
	   则该数组为可整合数组。例如，[5,3,4,6,2]排序之后为[2,3,4,5,6]，符合每相邻两个数差的绝对值都为1，
	   所以这个数组为可整合数组。给定一个整型数组arr，请返回其中最大可整合子数组的长度。
	   例如，[5,5,3,2,6,4,3]中最大可整合子数组为[5,3,2,6,4]，所以返回5。
	 * */

	public static void main(String[] args) {
		int[] a = { 1, 2, 2, 3, 3, 4, 7 };
		int[] b = { 5, 5, 3, 2, 6, 4, 3 };
		int len=getLengthOfLongestZHSubArray(b);
		System.out.println("len="+len);
		/*int[] result = getLengthOfLongestZHSubArray1(a);
		  System.out.println("满足条件的一个最长子数组是" + Arrays.toString(result)+"长度为："+result.length);
		int[] result1 = getLengthOfLongestZHSubArray1(b);
		System.out.println("满足条件的一个最长子数组是" + Arrays.toString(result1)+"长度为："+result1.length);*/
	}

	private static int getLengthOfLongestZHSubArray(int[] a) {
		if(a==null||a.length==0)
			return 0;
		int len=0;
		int max=0;
		int min=0;
		HashSet<Integer> set=new HashSet<Integer>();//判断重复
		for(int i=0;i<a.length;i++){
			max=Integer.MIN_VALUE;
			min=Integer.MAX_VALUE;
			for(int j=i;j<a.length;j++){
				if(set.contains(a[j])){//如果当前i到j之间存在重复字符，结束本次循环，下次从i+1位置开始查找整合子数组
					break;
				}
				set.add(a[j]);
				max=Math.max(max, a[j]);
				min=Math.min(min, a[j]);
				if(max-min==j-i){//更新len值
					len=Math.max(len, j-i+1);
				}
			}
			set.clear();//每趟i查找完子数组之后，需要清空set集合
		}
		return len;
	}
	
	/*private static int[] getLengthOfLongestZHSubArray1(int[] a) {
		int maxLen = 0;
		int maxBegin = 0;
		int maxEnd = 0;
		int[] maxmin = new int[2];
		
		int i = 0;
		int j = 0;
		while (j < a.length) {
			// 检测是否有重复
			if (!duplicate(a, i, j)) {
				maxmin = getMaxMin(a, i, j);
				// 如果没有重复，而且符合max-min==len-1这一条件，那么这个自数组就符合条件
				if ((maxmin[0] - maxmin[1] == j - i) && ((j - i + 1) > maxLen)) {
					maxLen = j - i + 1;
					maxBegin = i;
					maxEnd = j;
				}
			} else {
				// 如果有重复，那么跳过这个重复的数，继续判定后面的
				i = j;
			}
			j++;
		}
		//保存子数组
		int result[]=new int[maxLen];
		int m=0;
		for (int k = maxBegin; k <= maxEnd; k++)
			result[m++]=a[k];
		return result;
	}

	private static int[] getMaxMin(int[] a, int begin, int end) {
		int[] maxmin = new int[2];
		maxmin[0] = maxmin[1] = a[begin];
		for (int i = begin + 1; i <= end; i++) {
			if (a[i] > maxmin[0])
				maxmin[0] = a[i];
			if (a[i] < maxmin[1])
				maxmin[1] = a[i];
		}
		return maxmin;
	}

	private static boolean duplicate(int[] a, int begin, int end) {
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i = begin; i <= end; i++) {
			if (!hs.contains(a[i])) {
				hs.add(a[i]);
			} else {
				return true;
			}
		}
		return false;
	}
*/
}

