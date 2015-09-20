package cn.lnu.basesort;

public class HeapSort {

	 public static void main(String[] args) {
	  int a[] = { 10000, 10, 45, 643, 2, 32, 12, 34, 56, 7, 78, 65, 9, 34,
	    32, 5, 25, 324, 4, 2, 5, 456, 5, 3, 2, 634, 34, 23, 8, 7, 6, 5,
	    4, 3, 2, 1 };
	  heapSort(a);
	  show(a);
	 }

	 public static void heapSort(int a[]) {
	  for (int i = (a.length - 1) / 2; i >= 1; i--) {
	   heapAdjust(a, i, a.length - 1);
	  }
	  for (int i = a.length - 1; i >= 1; i--) {
	   int temp = a[i];
	   a[i] = a[1];
	   a[1] = temp;

	   heapAdjust(a, 1, i - 1);
	  }
	 }

	 public static void heapAdjust(int a[], int low, int high) {
	  int temp = a[low];
	  for (int i = 2 * low; i <= high; i *= 2) {
	   if (i < high && a[i] < a[i + 1]) {
	    i++;
	   }
	   if (temp >= a[i]) {
	    break;
	   } else {
	    a[low] = a[i];
	    low = i;
	   }
	  }
	  a[low] = temp;
	 }

	 public static void show(int a[]) {
	  for (int i = 0; i < a.length; i++) {
	   System.out.print(a[i] + " ");
	  }
	  System.out.println();
	 }

	}
