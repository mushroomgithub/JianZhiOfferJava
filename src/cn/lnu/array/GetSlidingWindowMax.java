package cn.lnu.array;

import java.util.Arrays;
public class GetSlidingWindowMax {
	/**
	 * ����һ������ͻ������ڵĴ�С���ҳ����л�����������ֵ�����ֵ�� ���磬�����������{2,3,4,2,6,2,5,1}���������ڵĴ�С3��
	 * ��ôһ������6���������ڣ����ǵ����ֵ�ֱ�Ϊ{4,4,6,6,6,5}�� �������{2,3,4,2,6,2,5,1}�Ļ�������������6����
	 * {[2,3,4],2,6,2,5,1}�� {2,[3,4,2],6,2,5,1}�� {2,3,[4,2,6],2,5,1}��
	 * {2,3,4,[2,6,2],5,1}�� {2,3,4,2,[6,2,5],1}�� {2,3,4,2,6,[2,5,1]}��
	 */
	public static void main(String[] args) {
		int[] a = { 2, 3, 4, 2, 6, 2, 5, 1 };
		// result: {4,4,6,6,6,5}
		int[] result = getSlidingWindowMax(a, 3);
		System.out.println("���л�����������ֵ�����ֵΪ��"+Arrays.toString(result));
	}

	private static int[] getSlidingWindowMax(int[] a, int size) {
		if (size == 0 || size > a.length)
			return null;
		int[] max = new int[a.length - size + 1];
		// ��ʼ�����ڿ�ʼ����λ��
		int begin = 0;
		int end = begin + size - 1;
		// �ҵ���һ�����ڵ����ֵ
		max[begin] = findMax(a, begin, end);
		// �ҵ����洰�ڵ����ֵ
		while (end < a.length - 1) {
			begin++;
			end++;
			if (max[begin - 1] == a[begin - 1]) {//˵����ǰbegin�±�Խ�������ֵ�����ֵ�Ѳ��ٴ����У���Ҫ���¸���
				max[begin] = findMax(a, begin, end);
			} else if (a[end] > max[begin - 1]) {//���max�е����һ��Ԫ�أ���Ȼ�ڴ����У�ֱ�ӱȽ����endָ���Ԫ���뵱ǰ�������ֵ�Ĵ�С
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
