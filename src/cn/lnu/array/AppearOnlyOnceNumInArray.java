package cn.lnu.array;

public class AppearOnlyOnceNumInArray {

	/**
	 * һ��������ֻ��һ��Ԫ�س���һ�Σ�����Ԫ�ض��������Σ�
	 * ����O(n)ʱ�䷶Χ�ڲ��ҵ����ֻ����һ�ε�Ԫ��
	 * @param args
	 */
	public static void main(String[] args) {
		int a[]={1,2,3,4,1,2,4};
		int result=appearOnlyOnceNumInArray(a);
		System.out.println("������ֻ����һ�ε�Ԫ���ǣ�"+result);
	}
	//�������ҳ�������ֻ����һ�ε�Ԫ��
	private static int appearOnlyOnceNumInArray(int[] a) {
		if(a==null)
			return -1;
		int result=0;
		for(int i=0;i<a.length;i++){
			result^=a[i];
		}
		return result;
	}
}
