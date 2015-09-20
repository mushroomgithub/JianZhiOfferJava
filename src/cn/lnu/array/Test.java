package cn.lnu.array;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[]={4,6,2,3,6,7,8,1};
		shellSortArray(a,2);
		for(int i:a){
			System.out.print(i+" ");
		}
	}

	private static void shellSortArray(int[] a, int d) {// 一趟步长为2的希尔排序
		for (int i = d; i < a.length; i++) {
			int temp = a[i];
			int k = i;
			if ((i % 2) == 0 && (i - d) % 2 == 0 && a[i] < a[i - d]) {
				for (int j = i - d; j >= 0; j -= d) {
					if (temp < a[j])
						k = j;
				}
			} else if ((i % 2) != 0 && (i - d) % 2 != 0 && a[i] > a[i - d]) {
				for (int j = i - d; j >= 0; j -= d) {
					if (temp > a[j])
						k = j;
				}
			}
			for (int m = i - d; m >= k; m -= d)
				a[m + d] = a[m];
			a[k] = temp;
		}
	}

}
