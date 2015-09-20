package cn.lnu.array;

import java.util.Arrays;
public class GetSlidingWindowMax {
	/**
	 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
	 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
	 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
	 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
	 */
	public static void main(String[] args) {
		int[] a = { 2, 3, 4, 2, 6, 2, 5, 1 };
		// result: {4,4,6,6,6,5}
		int[] result = getSlidingWindowMax(a, 3);
		System.out.println("所有滑动窗口里数值的最大值为："+Arrays.toString(result));
	}

	private static int[] getSlidingWindowMax(int[] a, int size) {
		if (size == 0 || size > a.length)
			return null;
		int[] max = new int[a.length - size + 1];
		// 初始化窗口开始结束位置
		int begin = 0;
		int end = begin + size - 1;
		// 找到第一个窗口的最大值
		max[begin] = findMax(a, begin, end);
		// 找到后面窗口的最大值
		while (end < a.length - 1) {
			begin++;
			end++;
			if (max[begin - 1] == a[begin - 1]) {//说明当前begin下标越过了最大值，最大值已不再窗口中，需要重新更新
				max[begin] = findMax(a, begin, end);
			} else if (a[end] > max[begin - 1]) {//如果max中的最后一个元素，依然在窗口中，直接比较最后end指向的元素与当前窗口最大值的大小
				max[begin] = a[end];
			} else {
				max[begin] = max[begin - 1];
			}
		}
		return max;
	}

	private static int findMax(int[] a, int begin, int end) {
		int max = a[begin];
		for (int i = begin + 1; i <= end; i++) {
			if (max < a[i]) {
				max = a[i];
			}
		}
		return max;
	}
}
