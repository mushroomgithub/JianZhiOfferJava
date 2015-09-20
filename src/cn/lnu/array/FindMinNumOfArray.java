package cn.lnu.array;

public class FindMinNumOfArray {

	/**
	 * ��һ�������ʼ������Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת��
	 * ����һ����������������һ����ת�������ת�������СԪ�ء�
	 * ���磬����{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1.
	 * ˼�룺
	 * ���һ��������������ת���õ�������������Ҳ��������ģ���ǰһ�����е�Ԫ�ض�����
	 * ��һ�����е�Ԫ�أ�������С��Ԫ�ؾ��ں�һ�����еĵ�һ��Ԫ�أ�ʹ�ö��ֲ��ҵķ�ʽ����
	 * ��С���ҷ�Χ��ʽ��ֱ��high-low==1����ʱhighָ����±�Ԫ�ؾ�����СԪ�ء�
	 * @param args
	 */
	public static void main(String[] args) {
		int a[]={3,4,5,1,2};
		//int a[]={1,1,0,1,1};
		int minNum=findMinNumofArray(a);
		System.out.println("��ת��������С�����ǣ�"+minNum);
	}
	private static int findMinNumofArray(int[] a) {
		int n=a.length;
		int low=0;
		int high=n-1;
		int mid=(low+high)/2;
		if(a==null||n<=0)
			return -1;
		while(a[low]>=a[high]){//����ѭ������
			if(high-low==1){//���ҵ���СԪ��
				mid=high;
				break;
			}
			if(a[mid]==a[low]&&a[mid]==a[high]){//�����������޷��ж���С������һ�ֻ࣬��ʹ��ԭʼ�������Ҹ�������С��������
				return getMinNum(a,low,high);
			}
			if(a[mid]>=a[low]){//˵���м�Ԫ����ǰһ���������У�����low��ֵ
				low=mid;
			}
			if(a[mid]<=a[high]){//˵���м�Ԫ���ں�һ���������У�����high��ֵ
				high=mid;
			}
			mid=(low+high)/2;
		}
		return a[mid];
	}

	private static int getMinNum(int[] a, int low, int high) {
		int min=a[low];
		for(int i=low+1;i<=high;i++){
			if(min>a[i]){
				min=a[i];
			}
		}
		return min;
	}
}
