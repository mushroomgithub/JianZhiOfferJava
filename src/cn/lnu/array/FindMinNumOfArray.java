package cn.lnu.array;

public class FindMinNumOfArray {

	/**
	 * 把一个数组最开始的若干元素搬到数组的末尾，我们称之为数组的旋转。
	 * 输入一个递增有序的数组的一个旋转，输出旋转数组的最小元素。
	 * 例如，数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1.
	 * 思想：
	 * 针对一个排序的数组的旋转，得到的两个子序列也都是排序的，且前一个序列的元素都大于
	 * 后一个序列的元素，并且最小的元素就在后一个序列的第一个元素，使用二分查找的方式不断
	 * 缩小查找范围方式，直到high-low==1，此时high指向的下标元素就是最小元素。
	 * @param args
	 */
	public static void main(String[] args) {
		int a[]={3,4,5,1,2};
		//int a[]={1,1,0,1,1};
		int minNum=findMinNumofArray(a);
		System.out.println("旋转数组中最小的数是："+minNum);
	}
	private static int findMinNumofArray(int[] a) {
		int n=a.length;
		int low=0;
		int high=n-1;
		int mid=(low+high)/2;
		if(a==null||n<=0)
			return -1;
		while(a[low]>=a[high]){//这是循环条件
			if(high-low==1){//查找到最小元素
				mid=high;
				break;
			}
			if(a[mid]==a[low]&&a[mid]==a[high]){//针对这种情况无法判断最小数在哪一侧，只能使用原始方法查找该区间最小的数返回
				return getMinNum(a,low,high);
			}
			if(a[mid]>=a[low]){//说明中间元素在前一个子序列中，调整low的值
				low=mid;
			}
			if(a[mid]<=a[high]){//说明中间元素在后一个子序列中，调整high的值
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
