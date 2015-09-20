package cn.lnu.array;
import java.util.Arrays;
import java.util.HashSet;

public class LongestZHSubArray {
	/*
	 * ��Ŀ�����������ĳ���
	   �ȸ�������������Ķ��塣���һ������������֮��ÿ������������ľ���ֵ��Ϊ1��
	   �������Ϊ���������顣���磬[5,3,4,6,2]����֮��Ϊ[2,3,4,5,6]������ÿ������������ľ���ֵ��Ϊ1��
	   �����������Ϊ���������顣����һ����������arr���뷵��������������������ĳ��ȡ�
	   ���磬[5,5,3,2,6,4,3]����������������Ϊ[5,3,2,6,4]�����Է���5��
	 * */

	public static void main(String[] args) {
		int[] a = { 1, 2, 2, 3, 3, 4, 7 };
		int[] b = { 5, 5, 3, 2, 6, 4, 3 };
		int len=getLengthOfLongestZHSubArray(b);
		System.out.println("len="+len);
		/*int[] result = getLengthOfLongestZHSubArray1(a);
		  System.out.println("����������һ�����������" + Arrays.toString(result)+"����Ϊ��"+result.length);
		int[] result1 = getLengthOfLongestZHSubArray1(b);
		System.out.println("����������һ�����������" + Arrays.toString(result1)+"����Ϊ��"+result1.length);*/
	}

	private static int getLengthOfLongestZHSubArray(int[] a) {
		if(a==null||a.length==0)
			return 0;
		int len=0;
		int max=0;
		int min=0;
		HashSet<Integer> set=new HashSet<Integer>();//�ж��ظ�
		for(int i=0;i<a.length;i++){
			max=Integer.MIN_VALUE;
			min=Integer.MAX_VALUE;
			for(int j=i;j<a.length;j++){
				if(set.contains(a[j])){//�����ǰi��j֮������ظ��ַ�����������ѭ�����´δ�i+1λ�ÿ�ʼ��������������
					break;
				}
				set.add(a[j]);
				max=Math.max(max, a[j]);
				min=Math.min(min, a[j]);
				if(max-min==j-i){//����lenֵ
					len=Math.max(len, j-i+1);
				}
			}
			set.clear();//ÿ��i������������֮����Ҫ���set����
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
			// ����Ƿ����ظ�
			if (!duplicate(a, i, j)) {
				maxmin = getMaxMin(a, i, j);
				// ���û���ظ������ҷ���max-min==len-1��һ��������ô���������ͷ�������
				if ((maxmin[0] - maxmin[1] == j - i) && ((j - i + 1) > maxLen)) {
					maxLen = j - i + 1;
					maxBegin = i;
					maxEnd = j;
				}
			} else {
				// ������ظ�����ô��������ظ������������ж������
				i = j;
			}
			j++;
		}
		//����������
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

