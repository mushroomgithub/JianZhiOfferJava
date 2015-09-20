package cn.lnu.array;

public class AppearOnlyOnceNumInArray {

	/**
	 * 一个数组中只有一个元素出现一次，其他元素都出现两次，
	 * 请在O(n)时间范围内查找到这个只出现一次的元素
	 * @param args
	 */
	public static void main(String[] args) {
		int a[]={1,2,3,4,1,2,4};
		int result=appearOnlyOnceNumInArray(a);
		System.out.println("数组中只出现一次的元素是："+result);
	}
	//异或操作找出数组中只出现一次的元素
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
